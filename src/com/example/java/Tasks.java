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






    public void taskScreen(){

        int leftHours;
        int ap;

        VBox vbox= new VBox();
        Scene scene= new Scene(vbox, 400,400);
        stage.setScene(scene);// utled et seod Subject tseeni aknaga
        stage.show();

        Label total= new Label ("Your working hours amount is for \" + courseName + \" course \" + leftHours + \" hours\\"  "Please start inserting your tasks \");
                TextField toDoTask= new TextField();
                toDoTask.setPromptText("Write here your task name");

        Button addButton = new Button("Add task");
        Button sumbitButton = new Button("Save");
        Button clearButton= new Button ("Clear");

        addButton.setOnAction(event -> {
                    TextField toDoTask = new TextField();
                    toDoTask.setPromptText("Write here your task name");
                });

        clearButton.setOnAction(event -> {
            toDoTask.clear();
        });

        sumbitButton.setOnAction(event -> {
            String taskName = toDoTask.getText();// votan textifildist name teksti sisse!
        });


        vbox.getChildren().addAll(total, toDoTask, addButton, sumbitButton, clearButton);

        //SIIA peaks nuud SQL lisama, sest kuidas ma salvestan muidu?

    }





    }



}
