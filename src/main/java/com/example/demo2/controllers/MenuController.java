package com.example.demo2.controllers;

import dao.GiftDao;
import dao.impl.GiftDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController{

    private final GiftDao giftDao = new GiftDaoImpl();

    @FXML
    private Label label;

    public Label getLabel() {
        return label;
    }

    private SweetsListInfoController sweetsListInfoController;

    private GiftCompositionController giftCompositionController;

    private AddCandyController addCandyController;

    private GiftWeightController giftWeightController;

    private RemoveCandyController removeCandyController;

    @FXML
    private void handleUpdateButton(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/GiftComposition.fxml"));
        try {
            Parent root = fxmlLoader.load();
            giftCompositionController = fxmlLoader.getController();

            giftCompositionController.setLabelToUpdate(label);

            giftCompositionController.displayGiftComposition();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleShowButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/SweetsList.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Список солодощів");
        stage.show();

        sweetsListInfoController = fxmlLoader.getController();
        if (sweetsListInfoController != null) {
            sweetsListInfoController.displaySweetsInfo();
        } else {
            System.out.println("SweetsListController is not initialized.");
        }
    }

    @FXML
    private void handleAddCandyButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/AddCandy.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Додати цукерку");
        stage.show();
    }

    @FXML
    void handleRemoveCandyButton(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/RemoveCandy.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Вилучити цукерку");
            stage.show();
    }

    @FXML
    private void handleCalculateGiftWeightButton() {
        double totalWeight = giftDao.getGiftWeight(); // Ось тут потрібно викликати ваш метод для обчислення ваги

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Загальна вага подарунку");
        alert.setHeaderText(null);
        alert.setContentText("Загальна вага подарунку: " + totalWeight + " грам");
        alert.showAndWait();
    }

    @FXML
    void handleSortGift(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/SortGift.fxml"));
            Parent root = loader.load();
            SortGiftController sortGiftController = loader.getController();

            sortGiftController.setMenuController(this);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Сортування подарунку");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleFindCandyButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/FindCandy.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Знайти цукерку за вмістом цукру");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

