package com.example.demo2.controllers;

import dao.GiftDao;
import dao.impl.GiftDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Sweets;

import java.util.List;

public class GiftCompositionController {

    @FXML
    private Label label;

    private final GiftDao giftDao = new GiftDaoImpl();

    public GiftCompositionController() {
    }

    public void setLabelToUpdate(Label label) {
        this.label = label;
    }

    public void displayGiftComposition() {
        List<Sweets> giftComposition = giftDao.getGiftComposition();
        StringBuilder sb = new StringBuilder();

        for (Sweets sweets : giftComposition) {
            sb.append("ID: ").append(sweets.getId()).append(", ").append(sweets.getName()).append("\n");
        }

        label.setText(sb.toString());
    }
}

