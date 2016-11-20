package com.example.java;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LogIn {
    Button controlTimeButton;
    Button regCourseButton;
    Label loginTitle;
    VBox vBox1 = new VBox();


    private Stage stage1 = new Stage();


    public LogIn() {
        startLogInStage();
        setButtonEvents();

    }

    private void startLogInStage() {


        HBox hBoxNew = new HBox();
        Scene login = new Scene(hBoxNew, 400, 200);
        stage1.setScene(login);// utled et seod Subject tseeni aknaga
        stage1.show();// avabjavafx.scene.Parent vBox; akna

        //Label logInTitle = new Label("Welcome to Task/Time managment calculator!");

        controlTimeButton = new Button("Check your teadlines");
        regCourseButton = new Button("Register new course");
        hBoxNew.getChildren().addAll(controlTimeButton, regCourseButton);

    }


    private void setButtonEvents() {
       controlTimeButton.setOnAction(event -> {

        });
        regCourseButton.setOnAction(event -> {
            new CourseName();
            stage1.hide(); // peaidab ara CourseNami akana

        });

    }


}