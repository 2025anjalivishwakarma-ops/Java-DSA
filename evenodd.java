import java.util.*;
class evenodd {
    public static void main(String args[]) {
        boolean n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        n = sc.nextboolean();
        if(n%2==0){
            System.out.println("The number is even");
        }
        else{
            System.out.println("The number is odd");
        }
    }
}