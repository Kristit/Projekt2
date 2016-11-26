package kt;

import javafx.application.Application;
import javafx.stage.Stage;
import kt.javafx.LogIn;


public class Main extends Application {
    public static Database database = new Database();

    public static void main(String[] args) {
        for (Course c : database.getCourses()) {
            System.out.println("Found course: " + c);
        }
        for (Task t : database.getTasks()) {
            System.out.println("Found task: "+t);
        }
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {//JavaFX start meetod

        new LogIn(); //kaivitan LogIn akna


    }
}





