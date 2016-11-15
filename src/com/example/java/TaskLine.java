package com.example.java;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

/**
 * Created by kristitammet on 15/11/2016.
 */

public class TaskLine extends HBox {
    TextField newNeedToDoTask;
    TextField newHoursField;
    TextField hoursField;
    Button removeButton;
    ArrayList<TextField> toDoTasks = new ArrayList<>();
    ArrayList<TextField> toDoHours = new ArrayList<>();


    TaskLine() {
        HBox hBox = new HBox();

        newNeedToDoTask = new TextField();//tee sellest tasklists
        newNeedToDoTask.setPromptText("Write here your task name");
        newHoursField = new TextField();
        hoursField.setPromptText("How many hours you need for this task?");
        removeButton = new Button("Clear");

        hBox.getChildren().add(toDoTasks.size() + 1, newNeedToDoTask, toDoHours.size() + 1, newHoursField, removeButton);
        toDoTasks.add(newNeedToDoTask);// votab sisse newNeedToDoTaski elemendi ja lsiab ArrayListi sisse
        toDoHours.add(newHoursField);
        return newNeedToDoTask;
        return newHoursField;

        removeButton.setOnAction(event -> {
            hBox.getChildren().remove(toDoTasks.size(), toDoHours.size(), removeButton);
            toDoTasks.remove(toDoTasks.size() - 1);
            toDoHours.remove(toDoHours.size() - 1);
        });


    }




}