import java.util.*;
public class Array {
    public static void main(String arhs[]) {
        Scanner sc=new Scanner(System.in);
       System.out.print("Enter the size of the array: ");
        int size=sc.nextInt();
        int numbers[]=new int[size];
        for (int i=0;i<size;i++) {
            numbers[i]=sc.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int x=sc.nextInt();
        for (int i=0;i<numbers.length;i++) {
            if (numbers[i]==x) {
                System.out.println("Element found at index: "+i);
                break;
            }
           
             else {
                System.out.println("Element not found");
        }
    }
}
}