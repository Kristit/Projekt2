package com.example.java;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by kristitammet on 11/11/2016.
 */
public class Tasks {

    Button sumbitButton;
    Button addButton;
    Stage stage = new Stage();
    HBox hBox = new HBox();
    private String courseName;
    private int ap;



    /* Vaata public Tasks(String courseName, int ap)  kuidas Sa toid klassisit ule ja miks panid sinna fildideks
    */

    public Tasks(String courseName, int ap) {// see peaks olema konstruktor (raagi see void ja kontruktor ja meetod (rida 33)?
        this.courseName = courseName;
        this.ap = ap;
        startTaskStage();
    }


    private void startTaskStage() { //startStage meetod

        Scene scene = new Scene(hBox);

        Label total = new Label("List your tasks and working hours!");
        hBox.getChildren().add(total);
        TextField toDoTask = new TextField;
        TextField taskHours = new TextField;
        new TaskLine();
        addButton = new Button("Add task");
        sumbitButton = new Button("Save");
        ArrayList<TextField> toDoTasks = new ArrayList<>();
        ArrayList<TextField> toDoHours = new ArrayList<>();

        addButton.setOnAction(event -> {
            TaskLine();// meetodi kutse vaata TaskLine classi
        });


        sumbitButton.setOnAction(event -> {
            for (TextField toDoTask : toDoTasks) {// toDoTasks ArrayList iterable- saad koikide elementide poole poorduda
                System.out.println(toDoTask.getText()); // Trukib iga uksiku TextFieldi sisu systemouti
            }
            for (TextField taskHours : toDoHours) {// toDoTasks ArrayList iterable- saad koikide elementide poole poorduda
                System.out.println(toDoTask.getText()); // Trukib iga uksiku TextFieldi sisu systemouti
            }
        });

        stage.setScene(scene);// utled et seod Subject tseeni aknaga
        stage.show();//avab akne

        hBox.getChildren().addAll(addButton, sumbitButton);


    }


}







