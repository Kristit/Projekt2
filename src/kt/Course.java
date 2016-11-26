package kt;

import java.util.ArrayList;

/**
 * Created by kristitammet on 26/11/2016.
 */
public class Course {
    String name;
    int credits;
    ArrayList<Task> tasks;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course "+name+ " ("+credits+")";
    }
}
