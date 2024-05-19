package dao.impl;

import exception.DataProcessingException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Sweets;
import model.SweetsList;
import model.SweetsService;
import model.candies.caramel.CaramelCandy;
import model.candies.caramel.Gum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import util.HibernateUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GiftDaoImplTest {
    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    @Mock
    private SweetsService sweetsService;

    @Mock
    private Query query;

    @Mock
    private HibernateCriteriaBuilder criteriaBuilder;

    @Mock
    private JpaCriteriaQuery<Sweets> criteriaQuery;

    @Mock
    private JpaRoot<Sweets> root;

    @InjectMocks
    private GiftDaoImpl giftDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        giftDao = new GiftDaoImpl();
        query = mock(Query.class);
        session = mock(Session.class);
        transaction = mock(Transaction.class);
    }

    @Test
    public void testAddCandyToGift() {
        sessionFactory = mock(SessionFactory.class);
        HibernateUtil.setSessionFactory(sessionFactory);
        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);

        // Створити об'єкт цукерки
        Sweets candy = new CaramelCandy(1L, "Карамельна мелодія", 25.0, 0.2);

        // Викликати метод add
        giftDao.add(candy);

        // Перевірити, що цукерка була збережена
        verify(session, times(1)).save(any(Sweets.class));
        verify(transaction, times(1)).commit();
    }

    @Test
    public void testAddCandyToGift_ExceptionThrown() {
        sessionFactory = mock(SessionFactory.class);
        HibernateUtil.setSessionFactory(sessionFactory);
        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);

        // Створити об'єкт цукерки
        Sweets candy = new CaramelCandy(1L, "Карамельна мелодія", 25.0, 0.2);

        // Змусити сесію кинути виняток при збереженні
        doThrow(new RuntimeException("Exception")).when(session).save(any(Sweets.class));

        // Перевірити, що виключення оброблено правильно
        assertThrows(DataProcessingException.class, () -> giftDao.add(candy));

        // Перевірити, що транзакція була відкотити
        verify(transaction, times(1)).rollback();
    }

    @Test
    void testGet() {
        when(sessionFactory.openSession()).thenReturn(session);
        HibernateUtil.setSessionFactory(sessionFactory);

        // Arrange
        long id = 1L;
        Sweets sweets = new CaramelCandy(id, "Candy1", 10.0, 0.3);

        when(sessionFactory.openSession()).thenReturn(session);
        when(session.get(Sweets.class, id)).thenReturn(sweets);

        // Act
        Optional<Sweets> result = giftDao.get(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(sweets, result.get());

        verify(sessionFactory).openSession();  // Виклик методу openSession()
        verify(session).get(Sweets.class, id);
        verify(session).close();
    }

    @Test
    void testGetNotFound() {
        HibernateUtil.setSessionFactory(sessionFactory);
        // Arrange
        long id = 1L;

        when(sessionFactory.openSession()).thenReturn(session);
        when(session.get(Sweets.class, id)).thenReturn(null);

        // Act
        Optional<Sweets> result = giftDao.get(id);

        // Assert
        assertFalse(result.isPresent());

        // Verify interactions
        verify(sessionFactory).openSession();
        verify(session).get(Sweets.class, id);
        verify(session).close();
    }

    @Test
    void testGetException() {
        HibernateUtil.setSessionFactory(sessionFactory);
        // Arrange
        long id = 1L;
        RuntimeException exception = new RuntimeException("Test Exception");

        when(sessionFactory.openSession()).thenReturn(session);
        when(session.get(Sweets.class, id)).thenThrow(exception);

        // Act & Assert
        assertThrows(DataProcessingException.class, () -> giftDao.get(id));

        // Verify interactions
        verify(sessionFactory).openSession();
        verify(session).get(Sweets.class, id);
        verify(session).close();
    }

    //    @Test
//    public void testAddCandyToGift_CandyNotInList() {
//        sessionFactory = mock(SessionFactory.class);
//        HibernateUtil.setSessionFactory(sessionFactory);
//        when(sessionFactory.openSession()).thenReturn(session);
//        when(session.beginTransaction()).thenReturn(transaction);
//
//        // Створити об'єкт цукерки, яка не входить до списку
//        Sweets candy = new CaramelCandy(999L, "Фальшива цукерка", 25.0, 0.2);
//
//        // Викликати метод add
//        giftDao.add(candy);
//
//        // Перевірити, що цукерка не була збережена
//        verify(session, never()).save(any(Sweets.class));
//        verify(transaction, never()).commit();
//    }


    //    @Test
//    void getBySugarContent() {
//        HibernateUtil.setSessionFactory(mock(SessionFactory.class));
//        when(HibernateUtil.getSessionFactory().openSession()).thenReturn(session);
//        when(session.beginTransaction()).thenReturn(transaction);
//
//        // Arrange
//        double from = 0.2;
//        double to = 0.5;
//        List<Sweets> candies = List.of(
//                new CaramelCandy(1L, "Candy1", 10.0, 0.3),
//                new Gum(2L, "Candy2", 20.0, 0.4)
//        );
//        Query<Sweets> query = mock(Query.class);
//        when(session.createQuery(anyString(), eq(Sweets.class))).thenReturn(query);
//        when(query.setParameter(anyString(), any())).thenReturn(query);
//        when(query.list()).thenReturn(candies);
//
//        // Act
//        List<Sweets> result = giftDao.getBySugarContent(from, to);
//
//        // Assert
//        assertEquals(candies.size(), result.size());
//        assertEquals(candies.get(0), result.get(0));
//        assertEquals(candies.get(1), result.get(1));
//
//        // Verify interactions
//        verify(sessionFactory).openSession();
//        verify(session).beginTransaction();
//        verify(session).createQuery(anyString(), eq(Sweets.class));
//        verify(query, times(2)).setParameter(anyString(), any());
//        verify(query).list();
//        verify(transaction).commit();
//        verify(session).close();
//    }

//    @Test
//    public void testGetAll() {
//        when(sessionFactory.openSession()).thenReturn(session);
//        when(session.createQuery(anyString(), eq(Sweets.class))).thenReturn(query);
//        // Arrange
//        List<Sweets> sweetsList = new ArrayList<>();
//        sweetsList.add(new CaramelCandy(1L, "Карамельна мелодія", 25.0, 0.2));
//        sweetsList.add(new Gum(2L, "Карамельна пісня", 25.0, 0.2));
//
//        when(query.getResultList()).thenReturn(sweetsList);
//
//        // Act
//        List<Sweets> result = giftDao.getAll();
//
//        // Assert
//        assertEquals(sweetsList.size(), result.size());
//        assertEquals(sweetsList, result);
//
//        // Verify interactions
//        verify(sessionFactory).openSession();
//        verify(session).createQuery("SELECT s FROM Sweets s", Sweets.class);
//        verify(query).getResultList();
//        verify(session).close();
//    }
//
//    @Test
//    public void testDeleteSweetById() {
//        // Arrange
//        Long candyId = 1L;
//        Sweets sweetToDelete = new CaramelCandy(candyId, "Candy1", 20.0, 0.3);
//
//        when(sessionFactory.openSession()).thenReturn(session);
//        when(session.get(Sweets.class, candyId)).thenReturn(sweetToDelete);
//        Transaction transaction = mock(Transaction.class);
//        when(session.beginTransaction()).thenReturn(transaction);
//
//        // Act
//        giftDao.deleteSweetById(candyId);
//
//        // Assert
//        verify(session).remove(sweetToDelete);
//        verify(transaction).commit();
//    }
//
//    @Test
//    public void testCalculateGiftWeight() {
//        // Arrange
//        List<Sweets> sweetsList = new ArrayList<>();
//        double expectedWeight = 0.0;
//
//        // Додати більше об'єктів Sweets для тестування
//        for (int i = 0; i < 8; i++) {
//            Sweets sweets = new CaramelCandy((long) (i + 1), "Candy" + (i + 1), 25.0, 0.2);
//            sweetsList.add(sweets);
//            expectedWeight += sweets.getWeight();
//        }
//
//        when(sessionFactory.openSession()).thenReturn(session);
//        Query<Sweets> query = mock(Query.class);
//        when(session.createQuery(anyString(), eq(Sweets.class))).thenReturn(query);
//        when(query.getResultList()).thenReturn(sweetsList);
//
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        // Act
//        giftDao.calculateGiftWeight();
//
//        // Assert
//        String expectedOutput = "Загальна вага подарунка = " + expectedWeight + " грам" + System.lineSeparator();
//        assertEquals(expectedOutput, outContent.toString());
//
//
//    }
//
//    @Test
//    public void testGetGiftComposition() {
//        // Arrange
//        List<Sweets> expectedComposition = new ArrayList<>();
//        expectedComposition.add(new CaramelCandy(1L, "Candy1", 25.0, 0.2));
//        expectedComposition.add(new Gum(2L, "Candy2", 30.0, 0.3));
//
//        // Mock session.createQuery()
//        when(session.createQuery("FROM Sweets", Sweets.class)).thenReturn(query);
//        // Mock query.getResultList()
//        when(query.getResultList()).thenReturn(expectedComposition);
//
//        // Act
//        List<Sweets> actualComposition = giftDao.getGiftComposition();
//
//        // Assert
//        assertEquals(expectedComposition.size(), actualComposition.size());
//        assertEquals(expectedComposition, actualComposition);
//
//        // Verify interactions
//        verify(session).createQuery("FROM Sweets", Sweets.class);
//        verify(query).getResultList();
//        verify(session).close();
//    }

}