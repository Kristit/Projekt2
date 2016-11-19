package com.example.java;

import com.sun.javafx.scene.text.TextLine;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by kristitammet on 11/11/2016.
 */
public class Tasks {

    Button saveButton;
    Button addButton;
    Stage stage = new Stage();
    VBox vBox = new VBox();
    private String courseName;
    private int ap;



    /* Vaata public Tasks(String courseName, int ap)  kuidas Sa toid klassisit ule ja miks panid sinna fildideks
    */

    public Tasks(String courseName, int ap) {// see peaks olema konstruktor (raagi see void ja kontruktor ja meetod (rida 33)?
        this.courseName = courseName;
        this.ap = ap;
        startTaskStage();
    }

//
    private void startTaskStage() { //startStage meetod

        Scene scene = new Scene(VBox, 400, 500);
        VBox vBox= new VBox;

        Label total = new Label("List your tasks and working hours!");
        vBox.getChildren().add(total);
        HBox topLine= new HBox;
        vBox.getChildren().add(new TaskLine());// uue lapse lisamine??? KUSI JARGI!

        addButton = new Button("Add task");
        saveButton = new Button("Save");
        ArrayList<TextLine> toDoTasks = new ArrayList<>();//when you have a Text Line not a TextField anymore


        addButton.setOnAction(event -> {
            vBox.getChildren().add(vBox.getChildren().size()-2)(new TaskLine());// creats new TaskLine()
        });


        saveButton.setOnAction(event -> {
            for (TextField toDoTask : toDoTasks) {// toDoTasks ArrayList iterable- saad koikide elementide poole poorduda
                System.out.println(toDoTask.getText()); // Trukib iga uksiku TextFieldi sisu systemouti
            }
            for (TextField taskHours : toDoHours) {// toDoTasks ArrayList iterable- saad koikide elementide poole poorduda
                System.out.println(toDoTask.getText()); // Trukib iga uksiku TextFieldi sisu systemouti
            }
        });

        stage.setScene(scene);// utled et seod Subject tseeni aknaga
        stage.show();//avab akne

        VBox.getChildren().addAll(addButton, sumbitButton);


    }


}







