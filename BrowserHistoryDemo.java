import java.util.Scanner;

class BrowserHistory {

    String[] stack;
    int top;
    int size;

    BrowserHistory(int size) {
        this.size = size;
        stack = new String[size];
        top = -1;
    }

    void push(String url) {
        if (top == size - 1) {
            System.out.println("Browser history is full!");
        } else {
            top++;
            stack[top] = url;
            System.out.println("Visited: " + url);
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("No previous page available.");
        } else {
            System.out.println("Going back from: " + stack[top]);
            stack[top] = null;
            top--;
        }
    }

    void peek() {
        if (top == -1) {
            System.out.println("Browser history is empty.");
        } else {
            System.out.println("Current page: " + stack[top]);
        }
    }

    void display() {
        if (top == -1) {
            System.out.println("Browser history is empty.");
        } else {
            System.out.println("\nBrowser History:");

            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

public class BrowserHistoryDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = sc.nextInt();

        BrowserHistory browser = new BrowserHistory(size);

        int choice;

        do {
            System.out.println("\n--- Browser History Menu ---");
            System.out.println("1. Visit New Page (Push)");
            System.out.println("2. Back (Pop)");
            System.out.println("3. Current Page (Peek)");
            System.out.println("4. Display History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.next();
                    browser.push(url);
                    break;

                case 2:
                    browser.pop();
                    break;

                case 3:
                    browser.peek();
                    break;

                case 4:
                    browser.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}