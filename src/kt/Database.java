package kt;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by kristitammet on 26/11/2016.
 */
public class Database {
    Connection conn = null;

    // Constructor, ehk meetod mis käivitub kohe objekti välja kutsumisel
    public Database() {
        openConnection();
        createTables();
    }

    // Et andmebaasi kasutada peame sellega esiteks ühenduse looma
    private void openConnection() {
        try {
            Class.forName("org.sqlite.JDBC");                          // Lae draiver sqlite.jar failist
            conn = DriverManager.getConnection("jdbc:sqlite:taskcalc.db"); // loo ühendus andmebaasi failiga
        } catch (Exception e) {                                      // püüa kinni võimalikud errorid
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Opened database successfully");            // lihtsalt meie enda jaoks teade
    }

    // Et andmebaasist kasu oleks, loome uue tabeli. See on nagu uus 'sheet' excelis.
    public void createTables() {

        // Käsk ise on CREATE TABLE ja sulgude vahel on kõik tulbad, mida tahan, et tabel hoiaks.

        update("CREATE TABLE IF NOT EXISTS Course (id INT AUTO_INCREMENT, name TEXT, credits INT)");
        update("CREATE TABLE IF NOT EXISTS Task (id INT AUTO_INCREMENT, course_id INT, name TEXT, hours INT, deadline DATE, hours_worked INT)");
    }

    // Andmebaasi muudatused ei tagasta väärtusi (erinevalt
    // päringutest) ja on lihtne eraldi meetodi tuua.
    private void update(String sql) {
        try {
            // Statement objekt on vajalik, et SQL_Login käsku käivitada
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            stat.close(); // Statement tuleb samuti kinni panna nagu ka Connection.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Course addCourse(Course course) {
        if (course.id != null) {
            throw new IllegalArgumentException("This course has already been added");
        }


        // https://blogs.oracle.com/WebLogicServer/entry/using_try_with_resources_with


        // Andmete sisestamiseks on käsk INSERT. Esimestes sulgudes on tulabad KUHU salvestada,
        // teistes sulgudes VALUES() on MIDA salvestada.
        // Example: INSERT INTO Course (name, credits) VALUES ('java', 12)
        update("INSERT INTO Course (name, credits) VALUES ('" + course.name + "', " + course.credits + ")");
        // get the id
        try (Statement stmt = conn.createStatement()) {
            ResultSet res = stmt.executeQuery("SELECT last_insert_rowid()");
            // there should always be a first row, so not even bothering to check if this is true
            res.next();
            // the id value is in the 1st column
            course.id = res.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return course;
    }

    public void addTask(Task t) {
        // Andmete sisestamiseks on käsk INSERT. Esimestes sulgudes on tulabad KUHU salvestada,
        // teistes sulgudes VALUES() on MIDA salvestada.
        // Example: INSERT INTO Course (course_id, name, hours, deadline, hours_worked) VALUES (1, 'my task', 5, '2016-12-31', 2)
        String deadlineString = t.deadline.format(DateTimeFormatter.ISO_LOCAL_DATE);
        update("INSERT INTO Task (course_id, name, hours, deadline, hours_worked) VALUES (" + t.courseId + ",'" + t.name + "'," + t.hours + ",'" + deadlineString + "', " + t.hoursWorked + " )");
    }

    public ArrayList<Course> getCourses() {
        // here we put the courses that we find from the database
        ArrayList<Course> courses = new ArrayList<>();

        // run a SELECT on the database
        try (Statement stmt = conn.createStatement()) {
            ResultSet res = stmt.executeQuery("SELECT * FROM Course");
            // loop through all result lines
            while (res.next()) {
                // get the course details
                int id = res.getInt("id");
                String name = res.getString("name");
                int credits = res.getInt("credits");

                // make the Course instance
                Course c = new Course(name, credits);
                c.id = id;

                courses.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

    public List<Task> getTasks() {
        ArrayList<Task> tasks= new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            ResultSet res = stmt.executeQuery("SELECT * FROM Task");
            // loop through all result lines
            while (res.next()) {
                // get the course details

                int courseId = res.getInt("course_id");
                String name = res.getString("name");
                int hours = res.getInt("hours");

                LocalDate deadline = LocalDate.parse(res.getString("deadline"));
                int hoursWorked = res.getInt("hours_worked");

                // make the Task instance
                Task t = new Task(courseId, name, hours, deadline, hoursWorked);

                tasks.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }
}
