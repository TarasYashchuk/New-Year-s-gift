package dao;

import exception.DataProcessingException;
import model.Sweets;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public interface GiftDao {
    void add();

    void add(Sweets sweets);


    List<Sweets> getBySugarContent(double from, double to);

    void getBySugarContent();

    Optional<Sweets> get(Long id);

    List<Sweets> getAll();

    void deleteSweetById();

    void deleteSweetById(Long candyId);

    void calculateGiftWeight();

    double getGiftWeight() throws DataProcessingException;

    List<Sweets> getGiftComposition();

    List<Sweets> sortGiftBySugarContent();

    List<Sweets> sortGiftByName();

    List<Sweets> sortGiftByWeight();

    void printSweetsInfo();
}
