import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {
// Method to perform calculation
static int calculate(int a, int b, char operator) {
switch (operator) {
case '+':
return a + b;
case '-':
return a - b;
case '*':
return a * b;
case '/':
return a / b;

case '%':
return a % b;
case '^':
return (int) Math.pow(a, b);
default:
return 0; } }

// Method to evaluate postfix expression
static int evaluatePostfix(String expression) {
Stack<Integer> stack = new Stack<>();
for (int i = 0; i < expression.length(); i++) {
char ch = expression.charAt(i);
// If character is a digit
if (Character.isDigit(ch)) {

stack.push(ch - '0'); }
// If character is an operator
else {
int b = stack.pop();
int a = stack.pop();
int result = calculate(a, b, ch);
stack.push(result); } }
return stack.pop(); }

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter postfix expression: ");
String expression = sc.nextLine();
int result = evaluatePostfix(expression);
System.out.println("Result = " + result);
sc.close(); } }

