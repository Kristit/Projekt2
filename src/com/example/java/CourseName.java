package com.example.java;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by kristitammet on 11/11/2016.
 */
public class CourseName {

    // salvestan erinevad muutujad, mida mul voib vaja minna
    private Stage stage = new Stage();
    private Scene scene = new Scene();
    TextField subjectName;
    TextField credits;
    Button saveButton;

    //konstruktor peab olema sam nimega mis klass!

    public CourseName { // kuida siin see konstruktor on?
        startStage();
        setClickEvent();

    }

    private void startStage() { //startStage meetod


        VBox vbox = new VBox();// Lood uue layouti (Vboxi)
        Scene subject = new Scene(vbox, 400, 200);//Teen scene "Subject" ja seon ta VBoxiga

        //hetkel pole Scene "Subject" seotud primaryStagiga. Selleks annan kasu setScene
        Stage.setScene(subject);// utled et seod Subject tseeni aknaga
        Stage.show();// avab akna


        //selleks, et Scene "Subject" midagi ka paistaks pean sisse panema teksti, nupud jne.

        Label title = new Label("Welcome to Task/Time managment calculator!");

        TextField subjectName = new TextField(); //lisad teksti valja
        subjectName.setPromptText("Write your subject name:"); //et see tekstivalja solev tekst kaoks
        TextField credits = new TextField();
        credits.setPromptText("How many credits you have?");

        Button saveButton = new Button("Save");

        // hetkel pole title,subjectName, jen. Vboxiga seotud. Selleks anan kasu get.Children().add

        vbox.getChildren().addAll(title, subjectName, credits, saveButton);
    }


    private void setClickEvent() {//NuppuKlikki meetod

        //selleks,et see save nupp midagi teeks anna kasu .set.OnAction
        saveButton.setOnAction(event -> {
            String courseName = subjectName.getText();// votan textifildist name teksti sisse!
            String ap = credits.getText();


            System.out.println(courseName); //kasutan seda ekranail kontrollimiseks, et ka snupp tootab
            System.out.println(ap);


        });
    }
}

