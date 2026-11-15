class CircularLinkedList {
// Node class
class Node {
String player;
Node next;
Node(String player) {
this.player = player;
this.next = null; } }
Node last = null;
// Insert player at the end
void insert(String player) {
Node newNode = new Node(player);
// If list is empty
if (last == null) {
last = newNode;
last.next = last;
}
else {
newNode.next = last.next;
last.next = newNode;
last = newNode; } }
// Delete player by name
void delete(String player) {
if (last == null) {
System.out.println("No players in the game.");
return; }
Node current = last.next;
Node previous = last;
do {
if (current.player.equals(player)) {

// Only one player
if (current == last && current.next == last) {
last = null; }
// Deleting last player
else {
previous.next = current.next;
if (current == last) {
last = previous; } }
System.out.println(player + " deleted.");
return; }
previous = current;
current = current.next;
} while (current != last.next);
System.out.println(player + " not found."); }
// Display players
void traverse() {
if (last == null) {
System.out.println("No players in the game.");
return; }
Node current = last.next;
System.out.print("Players: ");
do {
System.out.print(current.player + " -> ");
current = current.next;
} while (current != last.next);
System.out.println("(back to first player)"); }
// Display turns continuously
void playGame(int rounds) {
if (last == null) {
System.out.println("No players available.");

return; }
Node current = last.next;
System.out.println("\nPlayer Turns:");
for (int i = 0; i < rounds; i++) {
System.out.println("Turn " + (i + 1) + ": " + current.player);
current = current.next; } }
// Main method
public static void main(String[] args) {
CircularLinkedList game = new CircularLinkedList();
// Insert players
game.insert("Player 1");
game.insert("Player 2");
game.insert("Player 3");
game.insert("Player 4");
// Traversal
game.traverse();
// Simulate turns
game.playGame(8);
// Delete a player
System.out.println("\nAfter deleting Player 2:");
game.delete("Player 2");
// Traversal after deletion
game.traverse();
// Simulate turns again
game.playGame(8);
}
}