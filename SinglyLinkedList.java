class SinglyLinkedList {
// Node class
class Node {
int data;
Node next;
Node(int data) {
this.data = data;
this.next = null;
}
}
Node head = null;
// 1. Create / Insert at End
void create(int data) {
Node newNode = new Node(data);
if (head == null) {
head = newNode;
return;
}
Node temp = head;
while (temp.next != null) {
temp = temp.next;
}
temp.next = newNode;
}
// 2. Insert at Start
void insertStart(int data) {
Node newNode = new Node(data);
newNode.next = head;
head = newNode;
}
// 3. Insert at End
void insertEnd(int data) {
Node newNode = new Node(data);

if (head == null) {
head = newNode;
return;
}
Node temp = head;
while (temp.next != null) {
temp = temp.next;
}
temp.next = newNode;
}
// 4. Insert in Middle
// position starts from 1
void insertMiddle(int data, int position) {
if (position <= 1) {
insertStart(data);
return;
}
Node newNode = new Node(data);
Node temp = head;
// Move to node just before the required position
for (int i = 1; i < position - 1 && temp != null; i++) {
temp = temp.next;
}
if (temp == null) {
System.out.println("Invalid position");
return;
}
newNode.next = temp.next;
temp.next = newNode;
}
// 5. Delete from Start
void deleteStart() {
if (head == null) {

System.out.println("List is empty");
return;
}
head = head.next;
}
// 6. Delete from End
void deleteEnd() {
if (head == null) {
System.out.println("List is empty");
return;
}
// Only one node
if (head.next == null) {
head = null;
return;
}
Node temp = head;
while (temp.next.next != null) {
temp = temp.next;
}
temp.next = null;
}
// 7. Delete from Middle
// position starts from 1
void deleteMiddle(int position) {
if (head == null) {
System.out.println("List is empty");
return;
}
if (position <= 1) {
deleteStart();
return;
}

Node temp = head;
// Move to node just before the node to be deleted
for (int i = 1; i < position - 1 && temp.next != null; i++) {
temp = temp.next;
}
if (temp.next == null) {
System.out.println("Invalid position");
return;
}
temp.next = temp.next.next;
}
// Display the list
void display() {
if (head == null) {
System.out.println("List is empty");
return;
}
Node temp = head;
while (temp != null) {
System.out.print(temp.data + " -> ");
temp = temp.next;
}
System.out.println("NULL");
}
// Main method
public static void main(String[] args) {
SinglyLinkedList list = new SinglyLinkedList();
// Create list
list.create(10);
list.create(20);
list.create(30);
list.create(40);

System.out.println("Initial List:");
list.display();
// Insert at start
list.insertStart(5);
System.out.println("After inserting 5 at start:");
list.display();
// Insert at end
list.insertEnd(50);
System.out.println("After inserting 50 at end:");
list.display();
// Insert in middle
list.insertMiddle(25, 4);
System.out.println("After inserting 25 at position 4:");
list.display();
// Delete from start
list.deleteStart();
System.out.println("After deleting from start:");
list.display();
// Delete from end
list.deleteEnd();
System.out.println("After deleting from end:");
list.display();
// Delete from middle
list.deleteMiddle(3);
System.out.println("After deleting node at position 3:");
list.display();
}
}
