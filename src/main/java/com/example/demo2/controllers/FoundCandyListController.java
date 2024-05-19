package com.example.demo2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Sweets;

import java.util.List;

public class FoundCandyListController {
    @FXML
    private ListView<String> candyListView;

    public void setCandyList(List<Sweets> candyList) {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Sweets candy : candyList) {
            items.add(candy.getName() + " - Вміст цукру: " + candy.getSugarContent() + "%");
        }
        candyListView.setItems(items);
    }
}
