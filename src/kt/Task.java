package kt;

import java.time.LocalDate;

/**
 * Created by kristitammet on 26/11/2016.
 */
public class Task {
    int courseId;
    String name;
    int hours;
    LocalDate deadline;
    int hoursWorked;

    public Task(int courseId, String name, int hours, LocalDate deadline, int hoursWorked) {
        this.courseId = courseId;
        this.name = name;
        this.hours = hours;
        this.deadline = deadline;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "Task[courseId="+courseId+",name="+name+ ",hours="+hours+",deadline="+deadline+",hoursWorked="+hoursWorked+"]";
    }
}
