import java.util.*;
public class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the fruit: ");
        String fruit=sc.nextLine();
        switch (fruit) {
            case "Banana": 
                System.out.println("Banana is yellow");
                break;
            
            case "Mango": 
                System.out.println("Mango is orange");
                break;
            
            case "Grapes": 
                System.out.println("Grapes are green");
                break;
            
            default: 
                System.out.println("Unknown fruit");
                break;
            }
        }
    }