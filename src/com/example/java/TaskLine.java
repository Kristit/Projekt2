package com.example.java;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by kristitammet on 15/11/2016.
 */

public class TaskLine extends HBox {
    TextField nameField;
    TextField hoursField;
    Button removeButton;


    TaskLine() {

        nameField = new TextField();//tee sellest tasklists
        nameField.setPromptText("Write here your task name");
        hoursField = new TextField();
        hoursField.setPromptText("How many hours you need for this task?");
        removeButton = new Button("x");

        getChildren().addAll(nameField, hoursField, removeButton);

    }

}
