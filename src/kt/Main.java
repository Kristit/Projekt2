package kt;

import javafx.application.Application;
import javafx.stage.Stage;
import kt.javafx.LogIn;

import java.util.ArrayList;


public class Main extends Application {
    public static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        courses=Database.load();
        for (Course c : courses) {
            System.out.println("Found course: " + c);
            for (Task t : c.tasks) {
                System.out.println("Found task: "+t);
            }
        }
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {//JavaFX start meetod

        new LogIn(); //kaivitan LogIn akna


    }
}





