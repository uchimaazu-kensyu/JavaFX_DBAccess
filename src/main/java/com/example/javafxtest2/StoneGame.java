package com.example.javafxtest2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.control.cell.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;


import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class StoneGame implements Initializable {




    @FXML private TableView table;
    @FXML private TableColumn idCol;
    @FXML private TableColumn affiliationCol;
    @FXML private TableColumn nameCol;
    @FXML private TableColumn scoreCol;
    private ObservableList<User> data;


    @FXML private TextField addName;
    @FXML private TextField addScore;




    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        data = FXCollections.observableArrayList();
        table.setItems(data);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        affiliationCol.setCellValueFactory(new PropertyValueFactory<>("affiliation"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));

        data.addAll(new User("RNS","Uchima",30));
        data.addAll(new User("RNS","Matsumoto",50));

    }


    public void addButton(ActionEvent actionEvent) {
        data.addAll(new User("RNS","Uchima",30));
        data.addAll(new User("RNS","Matsumoto",50));
    }

    public void clickAddButton(ActionEvent actionEvent) {
        String name = addName.getText();
        int score = Integer.parseInt(addScore.getText());
        data.addAll(new User("RNS",name,score));
    }
}