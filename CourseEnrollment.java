 import java.util.ArrayList;
import java.util.Scanner;

class Course {
    int courseId;
    String courseName;
    int duration; 
    Course(int courseId, String courseName, int duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
    }

    void display() {
        System.out.println("Course ID   : " + courseId);
        System.out.println("Course Name : " + courseName);
        System.out.println("Duration    : " + duration + " weeks");
        System.out.println("---------------------------");
    }
}

public class CourseEnrollment {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details of Course " + (i + 1));

            System.out.print("Enter Course ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Duration (weeks): ");
            int duration = sc.nextInt();
            sc.nextLine();

            Course c = new Course(id, name, duration);
            courses.add(c);
        }

        System.out.println("\nCourse Enrollment Details");
        System.out.println("==========================");

        for (Course c : courses) {
            c.display();
        }

        sc.close();
    }
}