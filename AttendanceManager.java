import java.util.ArrayList;
import java.util.Scanner;

class Attendance {
    int studentId;
    String studentName;
    int daysPresent;

    Attendance(int studentId, String studentName, int daysPresent) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.daysPresent = daysPresent;
    }

    void display() {
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + studentName);
        System.out.println("Days Present : " + daysPresent);
        System.out.println("----------------------------");
    }
}

public class AttendanceManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Attendance> attendanceList = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Days Present: ");
            int daysPresent = sc.nextInt();
            sc.nextLine();

            Attendance a = new Attendance(id, name, daysPresent);
            attendanceList.add(a);
        }

        System.out.println("\nAttendance Details");
        System.out.println("==========================");

        for (Attendance a : attendanceList) {
            a.display();
        }

        sc.close();
    }
}