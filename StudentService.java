import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int id;
    String name;
    double marks;
    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Marks : " + marks);
        System.out.println("----------------------");
    }
}

public class StudentService {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();
            Student s = new Student(id, name, marks);
            students.add(s);
        }

        System.out.println("\nStudent Details");
        System.out.println("======================");
        for (Student s : students) {
            s.display();
        }

        sc.close();
    }
}
