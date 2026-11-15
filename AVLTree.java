public class AVLTree { 
// Node structure 
class Node { 
int accountNo; 
int height; 
Node left, right; 
Node(int accountNo) { 
this.accountNo = accountNo; 
height = 1; } } 
Node root; 
// Get height of a node 
int height(Node node) { if (node == null) 
return 0; 
return node.height; } 
// Get balance factor 
int getBalance(Node node) { 
if (node == null) 
return 0; 
return height(node.left) - height(node.right); } 
// Right Rotation 
Node rightRotate(Node y) { 
Node x = y.left; 
Node T2 = x.right; 
x.right = y; 
y.left = T2; 
y.height = Math.max(height(y.left), height(y.right)) + 1; 
x.height = Math.max(height(x.left), height(x.right)) + 1; 
return x; } 
// Left Rotation 
Node leftRotate(Node x) { 
Node y = x.right; 
Node T2 = y.left; 
y.left = x; 
x.right = T2; 
x.height = Math.max(height(x.left), height(x.right)) + 1; 
y.height = Math.max(height(y.left), height(y.right)) + 1; 
return y; } 
// Insert a node 
Node insert(Node node, int accountNo) { 
// Normal BST insertion 
if (node == null) 
return new Node(accountNo); 
if (accountNo < node.accountNo) 
node.left = insert(node.left, accountNo); 
else if (accountNo > node.accountNo) 
node.right = insert(node.right, accountNo); 
else 
return node; // Duplicate account number 
// Update height 
node.height = 1 + Math.max(height(node.left), height(node.right)); 
// Check balance factor 
int balance = getBalance(node); 
// LL Case 
if (balance > 1 && accountNo < node.left.accountNo) 
return rightRotate(node); 
// RR Case 
if (balance < -1 && accountNo > node.right.accountNo) 
return leftRotate(node); 
// LR Case 
if (balance > 1 && accountNo > node.left.accountNo) { 
node.left = leftRotate(node.left); 
return rightRotate(node); } 
// RL Case 
if (balance < -1 && accountNo < node.right.accountNo) { 
node.right = rightRotate(node.right); 
return leftRotate(node); } 
return node; } 
// Find node with minimum account number 
Node minValueNode(Node node) { 
Node current = node; 
while (current.left != null) 
current = current.left; 
return current; } 
// Delete a node 
Node delete(Node root, int accountNo) { 
// Normal BST deletion 
if (root == null) 
return root; 
if (accountNo < root.accountNo) 
root.left = delete(root.left, accountNo); 
else if (accountNo > root.accountNo) 
root.right = delete(root.right, accountNo); 
else { 
// Node with one or no child 
if (root.left == null || root.right == null) { 
Node temp; 
if (root.left != null) 
temp = root.left; 
else 
temp = root.right; 
if (temp == null) { 
root = null; 
} else { 
root = temp; } } 
// Node with two children 
else { 
Node temp = minValueNode(root.right); 
root.accountNo = temp.accountNo; 
root.right = delete(root.right, temp.accountNo); } } 
// If tree had only one node 
if (root == null) 
return root; 
// Update height 
root.height = 1 + Math.max(height(root.left), height(root.right)); 
// Check balance factor 
int balance = getBalance(root); 
// LL Case 
if (balance > 1 && getBalance(root.left) >= 0) 
return rightRotate(root); 
// LR Case 
if (balance > 1 && getBalance(root.left) < 0) { 
root.left = leftRotate(root.left); 
return rightRotate(root); 
} 
// RR Case 
if (balance < -1 && getBalance(root.right) <= 0) 
return leftRotate(root); 
// RL Case 
if (balance < -1 && getBalance(root.right) > 0) { 
root.right = rightRotate(root.right); 
return leftRotate(root); } 
return root; } 
// Search for an account number 
boolean search(Node root, int accountNo) { 
if (root == null) 
return false; 
if (root.accountNo == accountNo) 
return true; 
if (accountNo < root.accountNo) 
return search(root.left, accountNo); 
return search(root.right, accountNo); } 
// Inorder traversal 
void inorder(Node root) { 
if (root != null) { 
inorder(root.left); 
System.out.print(root.accountNo + " "); 
inorder(root.right); } } 
// Main method 
public static void main(String[] args) { 
AVLTree tree = new AVLTree(); 
// Insert customer account numbers 
int[] accounts = {30, 20, 40, 10, 25, 50, 5}; 
for (int account : accounts) { 
tree.root = tree.insert(tree.root, account); } 
System.out.println("AVL Tree after insertion:"); 
tree.inorder(tree.root); 
// Search 
int key = 25; 
if (tree.search(tree.root, key)) 
System.out.println("\n\nAccount " + key + " found."); 
else 
System.out.println("\n\nAccount " + key + " not found."); 
// Delete 
tree.root = tree.delete(tree.root, 20); 
System.out.println("\nAVL Tree after deleting account 20:"); 
tree.inorder(tree.root); }}
