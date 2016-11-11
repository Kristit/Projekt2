package com.example.java;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by kristitammet on 11/11/2016.
 */
    public class Tasks {
    TextField toDoTask;
    Button sumbitButton;
    Button addButton;
    Button clearButton;
    Stage stage= new Stage();
    int insertedTaskNumber;
        TextField toDoTask;


    public void Tasks() {// see peaks olema konstruktor
        startTaskStage();
        addSql();

    }


        private void startTaskStage() { //startStage meetod

        VBox vbox= new VBox();
        Scene scene= new Scene(vbox, 400,400);


        Label total= new Label ("List your tasks ");
        TextField needToDoTask= new TextField();
        needToDoTask.setPromptText("Write here your task name");

        Button addButton = new Button("Add task");
        Button sumbitButton = new Button("Save");
        Button clearButton= new Button ("Clear");

        addButton.setOnAction(event -> {
            TextField newNeedToDoTask = new TextField();
            newNeedToDoTask.setPromptText("Write here your task name");
        });

        clearButton.setOnAction(event -> {
            needToDoTask.clear();
        });

        sumbitButton.setOnAction(event -> {
            String taskName = needToDoTask.getText();// votan textifildist name teksti sisse!
            System.out.println(taskName);
        });

        vbox.getChildren().addAll(total, needToDoTask, addButton, sumbitButton, clearButton);

        stage.setScene(scene);// utled et seod Subject tseeni aknaga
        stage.show();//avab akne


    }
    //SIIA peaks nuud SQL lisama, sest kuidas ma salvestan muidu need erinevad taskid?
        private void addSql(){


    }

}







