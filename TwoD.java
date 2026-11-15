import java.util.*;
public class TwoD {
    public static void main(String[] args) {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows=Sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols=Sc.nextInt();
        int nums[][]=new int [rows] [cols];

        //input
        for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                nums[i][j]=Sc.nextInt();
            }
        }
         System.out.print("Enter number to search: ");
        int x=Sc.nextInt();
    for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(nums[i][j]==x) {
                    System.out.println("Element found at: "+i+" "+j);
                    return;
                }
            }
            System.out.println();
        }
    }
}

