import java.util.*;
public class sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1=sc.nextLine();
        String str2=str1.substring(0,10);

        System.out.println("The new string is: "+str2);
    }
}