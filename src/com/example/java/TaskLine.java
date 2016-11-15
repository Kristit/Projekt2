package com.example.java;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by kristitammet on 15/11/2016.
 */

public class TaskLine extends HBox {
    TextField nameField;
    TextField hoursField;








    TaskLine() {
        nameField =
        hoursField = new TextField();


        getChildren().add(hoursField);
        getChildren().add(nameField);
        //getChildren().add(removeButton);


    }
}
