package kt;

/**
 * Created by kristitammet on 26/11/2016.
 */
public class Course {
    Integer id=null;
    String name;
    int credits;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course "+id+": "+name+ " ("+credits+")";
    }
}
