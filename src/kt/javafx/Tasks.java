package kt.javafx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kt.Database;

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
    ArrayList<TaskLine> toDoTasks = new ArrayList<>();//when you have a Text Line not a TextField anymore


    //proovikas

    /* Vaata public Tasks(String courseName, int ap)  kuidas Sa toid klassisit ule ja miks panid sinna fildideks
    */

    public Tasks(String courseName, int ap) {// see peaks olema konstruktor (raagi see void ja kontruktor ja meetod (rida 33)?
        this.courseName = courseName;
        this.ap = ap;
        startTaskStage();
    }

    private void startTaskStage() { //startStage meetod

        Scene scene = new Scene(vBox,400, 200);

        Label total = new Label("List your tasks and working hours!");
        vBox.getChildren().add(total);
        HBox topLine = new HBox();


        addButton = new Button("Add task");
        saveButton = new Button("Save");

        addButton.setOnAction(event -> {
            addTaskLine(true);

        });


        saveButton.setOnAction(event -> {
            Database.save(courses);
            //for (TaskLine toDoTask : toDoTasks) {// toDoTasks ArrayList iterable- saad koikide elementide poole poorduda
                //System.out.println(toDoTask.nameField.getText()); // Trukib iga uksiku TextFieldi sisu systemouti
                //System.out.println(toDoTask.getName() + ": " + toDoTask.getHours()+ " and deadline is: "+ toDoTask.getDeadline());
                //Main.database.addTask(toDoTask.getTask());
            //}
        });

        stage.setScene(scene);// utled et seod Subject tseeni aknaga
        stage.show();//avab akne

        vBox.getChildren().addAll(addButton, saveButton);
        addTaskLine(false);// ???
    }

    private void addTaskLine(boolean useXButton) {
        TaskLine newTaskLine = new TaskLine(useXButton);

        vBox.getChildren().add(vBox.getChildren().size() - 2, newTaskLine);// creats new TaskLine()
        toDoTasks.add(newTaskLine);
        if (useXButton) {
            newTaskLine.removeButton.setOnAction(event -> {
                vBox.getChildren().remove(newTaskLine);
                toDoTasks.remove(toDoTasks.size() - 1);
            });
        }
    }

}










