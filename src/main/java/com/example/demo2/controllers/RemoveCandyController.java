package com.example.demo2.controllers;

import dao.GiftDao;
import dao.impl.GiftDaoImpl;
import exception.DataProcessingException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Sweets;

import java.util.Optional;

import static runner.Main.logger;

public class RemoveCandyController {
    @FXML
    private TextField candyIdField;

    @FXML
    private Label statusLabel;

    private GiftDao giftDao = new GiftDaoImpl();

    @FXML
    void handleDeleteButton(ActionEvent event) {
        Long candyId = null;
        try {
            candyId = Long.parseLong(candyIdField.getText());
            Optional<Sweets> optionalCandy = giftDao.get(candyId);
            if (optionalCandy.isPresent()) {
                Sweets selectedCandy = optionalCandy.get();
                giftDao.deleteSweetById(candyId);
                statusLabel.setText("Цукерка '" + selectedCandy.getName() + "' успішно вилучена із подарунку.");

                logger.info("Цукерка '" + selectedCandy.getName() + "' (ID: " + candyId + ") вилучена із подарунку.");
            } else {
                statusLabel.setText("Цукерка з ID " + candyId + " не знайдена.");

                logger.error("Помилка при видаленні цукерки: цукерка з ID " + candyId + " не знайдена.");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Невірний формат ID. Спробуйте ще раз.");
        } catch (DataProcessingException e) {
            statusLabel.setText("Помилка при видаленні цукерки: " + e.getMessage());
            logger.error("Помилка при видаленні цукерки: " + e.getMessage(), e);
        }
    }
}
