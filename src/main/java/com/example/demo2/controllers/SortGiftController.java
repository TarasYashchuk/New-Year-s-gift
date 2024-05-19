package com.example.demo2.controllers;

import dao.GiftDao;
import dao.impl.GiftDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import model.Sweets;

import java.util.Comparator;
import java.util.List;

public class SortGiftController {

    private GiftDao giftDao = new GiftDaoImpl();

    private List<Sweets> giftComposition;

    public void setGiftComposition(List<Sweets> giftComposition) {
        this.giftComposition = giftComposition;
    }

    @FXML
    private Label label;

    public void setLabelToUpdate(Label label) {
        this.label = label;
    }

    private MenuController menuController;

    // Оновлення мітки після сортування
    private void updateLabel(List<Sweets> sortedGift) {
        StringBuilder sb = new StringBuilder();
        for (Sweets sweets : sortedGift) {
            sb.append(sweets.getName()).append("\n");
        }
        menuController.getLabel().setText(sb.toString());
    }

    // Метод для налаштування посилання на контролер меню
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    @FXML
    void sortByName(ActionEvent event) {
        List<Sweets> sortedGift = giftDao.sortGiftByName();
        updateLabel(sortedGift);
        showAlert("Сортування за іменем", "Подарунок відсортовано за іменем.");
    }


    @FXML
    void sortBySugarContent(ActionEvent event) {
        List<Sweets> sortedGift  = giftDao.sortGiftBySugarContent();
        updateLabel(sortedGift);
        showAlert("Сортування за вмістом цукру", "Подарунок відсортовано за вмістом цукру.");
        // Оновлення відображення відсортованого подарунку
    }

    @FXML
    void sortByWeight(ActionEvent event) {
        List<Sweets> sortedGift = giftDao.sortGiftByWeight();
        updateLabel(sortedGift);
        showAlert("Сортування за вагою", "Подарунок відсортовано за вагою.");
        // Оновлення відображення відсортованого подарунку
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}