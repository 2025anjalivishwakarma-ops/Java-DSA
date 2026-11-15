import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
            case '%':
                return 2;

            case '^':
                return 3;

            default:
                return -1;
        }
    }

    static String infixToPostfix(String expression) {

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            else if (ch == '+' || ch == '-' ||
                     ch == '*' || ch == '/' ||
                     ch == '%' || ch == '^') {

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(ch) <= precedence(stack.peek())) {

                    postfix.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String expression = sc.nextLine();

        String postfix = infixToPostfix(expression);

        System.out.println("Postfix expression: " + postfix);

        sc.close();
    }
}