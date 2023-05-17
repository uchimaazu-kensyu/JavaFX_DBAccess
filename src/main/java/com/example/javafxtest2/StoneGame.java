package com.example.javafxtest2;

import DBClass.DBAccess;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.TableView;

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
    @FXML
    private ComboBox<String> addCompany;
    @FXML
    private ComboBox<String> editCompany;


    @FXML private TextField addName;
    @FXML private TextField addScore;

    @FXML private TextField editName;
    @FXML private TextField editScore;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);







    public void clickEditButton(ActionEvent actionEvent){
        User selectedObject = (User)table.getSelectionModel().getSelectedItem();
        if(selectedObject != null){
            //今入力されている値を取得
            String company = editCompany.getValue();
            String name = editName.getText();
            String score = editScore.getText();

            boolean ok = checkInput(company,name,score);
            if(ok){
                int setScore = Integer.parseInt(editScore.getText());
                selectedObject.setAffiliation(company);
                selectedObject.setName(name);
                selectedObject.setScore(setScore);

                table.refresh();
            }


        }
    }

    public void clickDeleteButton(ActionEvent actionEvent){
        User selectedObject = (User)table.getSelectionModel().getSelectedItem();
        if(selectedObject != null){

            table.getItems().remove(selectedObject);

        }
    }

    public void clickAddButton(ActionEvent actionEvent) {


        String company = addCompany.getValue();
        String name = addName.getText();
        String score = addScore.getText();
        boolean ok = checkInput(company,name,score);
        if(ok){
            data.addAll(new User(company,name,Integer.parseInt(score)));
        }


    }



    public boolean checkInput (String company , String name, String score){
        if(company!=null && !name.equals("") && !score.equals("") ){
            try{
                int setScore = Integer.parseInt(addScore.getText());

            }catch (NumberFormatException e){
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("点数を数字で入力してください");
                alert.showAndWait();
                return false;
            }

            int setScore = Integer.parseInt(addScore.getText());
            if (0 <= setScore  && setScore <100){
                return true;
            }else {
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("0~100までの点数を入力できます。");
                alert.showAndWait();
                return false;
            }

        }else{
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("所属企業、名前、点数のいずれかが入力されていません。");
            alert.showAndWait();
            return false;
        }


    }






    @Override
    public void initialize(URL url, ResourceBundle bundle) {

        data = FXCollections.observableArrayList();
        table.setItems(data);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        affiliationCol.setCellValueFactory(new PropertyValueFactory<>("affiliation"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));

        //returnされたuserListをdataにaddAllして表示。
        var service = new DBAccess();
        var userList = service.findAll();
        for (var e :userList){
            data.addAll(e);
        }



//        data.addAll(new User("RNS","Uchima",30));
//        data.addAll(new User("RNS","Matsumoto",50));

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                User nowSelection = (User)newSelection;
                String affiliation = nowSelection.getAffiliation();
                String name = nowSelection.getName();
                String score = String.valueOf(nowSelection.getScore());
                editName.setText(name);
                editScore.setText(score);
                editCompany.getSelectionModel().select(affiliation);
            }
        });

    }




}