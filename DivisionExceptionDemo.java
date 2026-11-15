import java.util.Scanner;
import java.util.InputMismatchException;

public class DivisionExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Name: Anjali Vishwakarma");
        System.out.println("Roll No: 59");

        try {
            System.out.print("Enter first integer: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second integer: ");
            int num2 = sc.nextInt();

            int result = num1 / num2;

            System.out.println("Division Result = " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
        catch (InputMismatchException e) {
            System.out.println("Error: Invalid numeric input. Please enter integers only.");
        }
        finally {
            sc.close();
        }
    }
}