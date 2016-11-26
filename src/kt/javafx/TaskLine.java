package kt.javafx;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import kt.Task;

import java.time.LocalDate;

/**
 * Created by kristitammet on 15/11/2016.
 */
public class TaskLine extends HBox {
    private TextField nameField;
    private TextField hoursField;
    Button removeButton;
    private DatePicker deadline;

    TaskLine(boolean useXButton) {
        nameField = new TextField();//tee sellest tasklists
        nameField.setPromptText("Write here your task name");
        hoursField = new TextField();
        hoursField.setPromptText("How many hours you need for this task?");
        deadline = new DatePicker();
        removeButton = new Button("x");
        removeButton.setDisable(!useXButton);// Boolena not


        getChildren().addAll(nameField, hoursField, deadline, removeButton);

    }

    public Task getTask() {
        return new Task(0, getName(), getHours(), getDeadline(), 0);
    }

    public String getName() {
        return nameField.getText();
    }

    public Integer getHours() {
        String hoursString = hoursField.getText();
        Integer hours = Integer.valueOf(hoursString);
        return hours;
    }

    public LocalDate getDeadline() {
        return deadline.getValue();
    }
}
