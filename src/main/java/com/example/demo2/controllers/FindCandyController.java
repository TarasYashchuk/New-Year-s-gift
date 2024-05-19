package com.example.demo2.controllers;

import dao.GiftDao;
import dao.impl.GiftDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Sweets;

import java.io.IOException;
import java.util.List;

public class FindCandyController {

    private GiftDao giftDao = new GiftDaoImpl();

    @FXML
    private TextField fromTextField;

    @FXML
    private TextField toTextField;

    @FXML
    private Button findButton;

    @FXML
    void handleFindButton(ActionEvent event) {
        double from = Double.parseDouble(fromTextField.getText());
        double to = Double.parseDouble(toTextField.getText());

        List<Sweets> foundCandy = giftDao.getBySugarContent(from,to);

        showFoundCandyList(foundCandy);

    }
    private void showFoundCandyList(List<Sweets> foundCandy) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FoundCandyList.fxml"));
        try {
            Parent root = loader.load();
            FoundCandyListController foundCandyListController = loader.getController();
            foundCandyListController.setCandyList(foundCandy);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Список знайдених цукерок");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
