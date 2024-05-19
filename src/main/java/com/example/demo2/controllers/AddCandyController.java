package com.example.demo2.controllers;

import dao.GiftDao;
import dao.impl.GiftDaoImpl;
import exception.DataProcessingException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Sweets;
import model.SweetsList;
import model.SweetsService;

import java.util.List;
import java.util.Optional;

public class AddCandyController {
    SweetsService sweetsService;
    private final GiftDao giftDao = new GiftDaoImpl();


    @FXML
    private TextField candyIdField;

    @FXML
    private Label statusLabel;

    @FXML
    private void handleAddButton(ActionEvent event) {
        try {
            long candyId = Long.parseLong(candyIdField.getText());
            List<Sweets> sweetsList = SweetsList.getSweetsList();
            Optional<Sweets> optionalCandy = sweetsList.stream()
                    .filter(sweets -> sweets.getId() == candyId)
                    .findFirst();
            if (optionalCandy.isPresent()) {
                Sweets selectedCandy = optionalCandy.get();
                giftDao.add(selectedCandy);
                statusLabel.setText("Цукерка '" + selectedCandy.getName() + "' успішно додана до подарунку.");
            } else {
                statusLabel.setText("Цукерка з ID " + candyId + " не знайдена.");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Некоректне значення ID цукерки.");
        } catch (DataProcessingException e) {
            statusLabel.setText("Помилка при додаванні цукерки до подарунку: " + e.getMessage());
        }
    }
}
