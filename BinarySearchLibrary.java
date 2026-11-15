import java.util.Scanner;
public class BinarySearchLibrary {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
// Sorted list of book IDs
int[] bookIDs = {101, 105, 110, 115, 120, 125, 130, 135, 140};
System.out.print("Enter Book ID to search: ");
int key = sc.nextInt();
int low = 0;
int high = bookIDs.length - 1;
int mid;
boolean found = false;
// Binary Search
while (low <= high) {
mid = (low + high) / 2;
if (bookIDs[mid] == key) {
System.out.println("Book ID " + key + " found at position " + (mid + 1));
found = true;
break;
}
else if (bookIDs[mid] < key) {
low = mid + 1;
}
else {
high = mid - 1;
}
}
if (!found) {
System.out.println("Book ID " + key + " not found in the library.");
}
sc.close();
}
}