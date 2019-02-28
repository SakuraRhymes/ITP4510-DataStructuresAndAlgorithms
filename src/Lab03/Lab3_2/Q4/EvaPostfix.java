package Lab03.Lab3_2.Q4;

import java.util.*;

public class EvaPostfix {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Postfix expression? ");
        String exp = keyboard.nextLine();

        try {
            int result = evalPostfix(exp);
            System.out.println("The result is " + result);
        } catch (Exception e) {
            System.out.println("Invalid postfix expression!");
            e.printStackTrace();
        }
    }

    public static int evalPostfix(String postfix) {
        ArrayStack s = new ArrayStack(); // stack of Integer objects
        int opd1, opd2; // operand1 and operand2

        for (char c : postfix.toCharArray()) {

            // skip space characters
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (Character.isDigit(c)) {
                // push digit value into stack
                s.push(Character.getNumericValue(c));
            } else { // operator is found, pop operands to calculate
                opd2 = (Integer) s.pop();
                opd1 = (Integer) s.pop();
                int value;
                switch (c) {
                    case '+':
                        value = opd1 + opd2;
                        break;
                    case '-':
                        value = opd1 - opd2;
                        break;
                    case '*':
                        value = opd1 * opd2;
                        break;
                    case '/':
                        value = opd1 / opd2;
                        break;
                    default:
                        value = 0;
                }
                s.push(value);
            }
        }

        // return the final result of postfix expression kept in the stack
        return (Integer) s.pop();

    } // evalPostfix
}

