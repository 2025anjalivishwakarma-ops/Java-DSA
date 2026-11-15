
import java.util.*;

public class Arrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        String[] array = new String[size];
        int top = -1;

        while (true) {

            System.out.println("\n--- ARRAY OPERATIONS ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (top == size - 1) {
                        System.out.println("Array is full!");
                    } else {
                        System.out.print("Enter element: ");
                        String element = sc.next();

                        top++;
                        array[top] = element;

                        System.out.println("Element pushed: " + element);
                    }
                    break;

                case 2:
                    if (top == -1) {
                        System.out.println("Array is empty!");
                    } else {
                        System.out.println("Element popped: " + array[top]);
                        top--;
                    }
                    break;

                case 3:
                    if (top == -1) {
                        System.out.println("Array is empty!");
                    } else {
                        System.out.println("Top element: " + array[top]);
                    }
                    break;

                case 4:
                    if (top == -1) {
                        System.out.println("Array is empty!");
                    } else {
                        System.out.println("Array elements:");

                        for (int i = top; i >= 0; i--) {
                            System.out.print(array[i] + " ");
                        }

                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    
}}
