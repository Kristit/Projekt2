package com.example.java;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by kristitammet on 11/11/2016.
 */
public class Tasks {

    private String courseName;
    private int ap;
    ArrayList<TextField> toDoTasks = new ArrayList<>();
    Button sumbitButton;
    Button addButton;
    Button clearButton;
    Stage stage = new Stage();
    VBox vbox = new VBox();


    /* Vaata public Tasks(String courseName, int ap)  kuidas Sa toid klassisit ule ja miks panid sinna fildideks
    */

    public Tasks(String courseName, int ap) {// see peaks olema konstruktor (raagi see void ja kontruktor ja meetod (rida 33)?
        this.courseName = courseName;
        this.ap = ap;
        startTaskStage();


    }

    private TextField createNewField() {
        TextField newNeedToDoTask = new TextField();//tee sellest tasklists
        newNeedToDoTask.setPromptText("Write here your task name");

        vbox.getChildren().add(toDoTasks.size() + 1, newNeedToDoTask);
        toDoTasks.add(newNeedToDoTask);// votab sisse newNeedToDoTaski elemendi ja lsiab ArrayListi sisse
        return newNeedToDoTask;//
    }

    private void startTaskStage() { //startStage meetod

        Scene scene = new Scene(vbox, 400, 400);


        Label total = new Label("List your tasks ");// 0 positsioonil
        vbox.getChildren().add(total);
        createNewField();
        addButton = new Button("Add task");
        sumbitButton = new Button("Save");
        clearButton = new Button("Clear");

        addButton.setOnAction(event -> {
            createNewField();// meetodi kutse vaata TextField meetodit
        });

        clearButton.setOnAction(event -> {
            vbox.getChildren().remove(toDoTasks.size());
            toDoTasks.remove(toDoTasks.size() - 1);
        });

        sumbitButton.setOnAction(event -> {
            for (TextField toDoTask : toDoTasks) {// toDoTasks ArrayList iterable- saad koikide elementide poole poorduda
                System.out.println(toDoTask.getText()); // Trukib iga uksiku TextFieldi sisu systemouti
            }
        });

        stage.setScene(scene);// utled et seod Subject tseeni aknaga
        stage.show();//avab akne

        vbox.getChildren().addAll(addButton, sumbitButton, clearButton);


    }

    //SIIA peaks nuud SQL lisama, sest kuidas ma salvestan muidu need erinevad taskid?
    private void addSql() {


    }

}







