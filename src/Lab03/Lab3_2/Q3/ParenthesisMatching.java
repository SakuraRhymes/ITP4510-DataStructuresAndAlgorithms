package Lab03.Lab3_2.Q3;

import java.util.*;

public class ParenthesisMatching {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Expression? ");
        String exp = keyboard.nextLine();

        if (parenthesisMatching(exp))
            System.out.println("Parenthesis matched");
        else
            System.out.println("Parenthesis not matched");
    }

    public static boolean parenthesisMatching(String exp) {
        Stack stack = new ArrayStack(10);

        for (char c : exp.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                try {
                    char x = (Character) stack.pop();
                    if (!((x == '{' && c == '}') || (x == '[' && c == ']') || (x == '(' && c == ')'))) {
                        return false;
                    }
                } catch (StackEmptyException e) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
