package com.example.demo2.controllers;

import dao.GiftDao;
import dao.impl.GiftDaoImpl;
import exception.DataProcessingException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class GiftWeightController {

    private final GiftDao giftDao = new GiftDaoImpl();

    @FXML
    private void handleCalculateButton() {
        try {
            double totalWeight = giftDao.getGiftWeight();
            showWeightInfo(totalWeight);
        } catch (DataProcessingException e) {
            showErrorAlert("Помилка", "Помилка під час обчислення ваги подарунку.", e.getMessage());
        }
    }

    private void showWeightInfo(double weight) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Вага подарунку");
        alert.setHeaderText(null);
        alert.setContentText("Загальна вага подарунку: " + weight + " грам");
        alert.showAndWait();
    }

    private void showErrorAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
