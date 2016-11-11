package com.example.java;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;


public class Main extends Application {

    // new Tasks(); kaivitan Tasks akna
    // new CourseName(); kaivitan Coursename akna

    @Override
    public void start(Stage primaryStage) throws Exception {//JavaFX start meetod

        // new Tasks(); kaivitan Tasks akna


        VBox vbox = new VBox();// Lood uue layouti (Vboxi)
        Scene subject = new Scene(vbox, 200, 200);//Teen scene "Subject" ja seon ta VBoxiga

        //hetkel pole Scene "Subject" seotud primaryStagiga. Selleks annan kasu setScene
        primaryStage.setScene(subject);// utled et seod Subject tseeni aknaga
        primaryStage.show();// avab akna


        //selleks, et Scene "Subject" midagi ka paistaks pean sisse panema teksti, nupud jne.

        Label title = new Label("Welcome to Task/Time managment calculator!");

        TextField subjectName = new TextField(); //lisad teksti valja
        subjectName.setPromptText("Write your subject name:"); //et see tekstivalja solev tekst kaoks
        TextField credits = new TextField();
        credits.setPromptText("How many credits you have?");

        TextField taskNumber = new TextField();
        taskNumber.setPromptText("How many tasks you have?");
        Button saveButton = new Button("Save");

        // hetkel pole title,subjectName, jen. Vboxiga seotud. Selleks anan kasu get.Children().add

        vbox.getChildren().addAll(title, subjectName, credits, taskNumber, saveButton);

        //selleks,et see save nupp midagi teeks anna kasu .set.OnAction
        saveButton.setOnAction(event -> {
            String courseName = subjectName.getText();// votan textifildist name teksti sisse!
            String ap = credits.getText();


            System.out.println(courseName); //kasutan seda ekranail kontrollimiseks, et ka snupp tootab
            System.out.println(ap);



        });

    }
}




