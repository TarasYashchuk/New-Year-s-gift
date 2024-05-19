package com.example.demo2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Sweets;
import model.SweetsList;

import java.io.IOException;
import java.util.List;

public class SweetsListInfoController {
    @FXML
    private Label label;

    @FXML
    private void handleShowButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/SweetsList.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        // Створення нового вікна
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void displaySweetsInfo() {
        // Логіка для відображення інформації про солодощі
        StringBuilder sb = new StringBuilder();

        List<Sweets> sweetsList = SweetsList.getSweetsList();
        for (Sweets sweets : sweetsList) {
            sb.append(sweets.toString()).append("\n");
        }

        label.setText(sb.toString());
    }
}
