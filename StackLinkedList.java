import java.util.Scanner;
// Node class
class Node {
int data;
Node next;
Node(int data) {
this.data = data;
this.next = null;
}
}
// Stack class
class Stack {
Node top;
// Constructor
Stack() {
top = null;
}
// Push operation
void push(int value) {
Node newNode = new Node(value);
newNode.next = top;
top = newNode;
System.out.println(value + " pushed into stack.");
}
// Pop operation
void pop() {
if (top == null) {
System.out.println("Stack Underflow");
return;
}
System.out.println(top.data + " popped from stack.");
top = top.next;
}
// Peek operation
void peek() {

if (top == null) {
System.out.println("Stack is empty.");
} else {
System.out.println("Top element is: " + top.data);
}
}
// Display operation
void display() {
if (top == null) {
System.out.println("Stack is empty.");
return;
}
System.out.println("Stack elements:");
Node temp = top;
while (temp != null) {
System.out.println(temp.data);
temp = temp.next;
}
}
// Check if stack is empty
boolean isEmpty() {
return top == null;
}
}
// Main class
public class StackLinkedList {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Stack stack = new Stack();
int choice, value;
do {
System.out.println("\n--- Stack Using Linked List ---");
System.out.println("1. Push");
System.out.println("2. Pop");
System.out.println("3. Peek");
System.out.println("4. Display");
System.out.println("5. Is Empty");
System.out.println("6. Exit");

System.out.print("Enter your choice: ");
choice = sc.nextInt();
switch (choice) {
case 1:
System.out.print("Enter value: ");
value = sc.nextInt();
stack.push(value);
break;
case 2:
stack.pop();
break;
case 3:
stack.peek();
break;
case 4:
stack.display();
break;
case 5:
if (stack.isEmpty())
System.out.println("Stack is empty.");
else
System.out.println("Stack is not empty.");
break;
case 6:
System.out.println("Exiting...");
break;
default:
System.out.println("Invalid choice.");
}
} while (choice != 6);
sc.close();
}
}