package Lab02.Lab2_1;

import javax.swing.JOptionPane;

public class InputParsing {
    public static void main(String[] args) {
        String input;
        int[] a = {80, 60, 72, 85, 90};
        String output;

        output = "The 5 marks are:";
        for (int i = 0; i < 5; i++)
            output += " " + a[i];
        output += "\nAverage of how many numbers?";

        do {
            input = JOptionPane.showInputDialog(output);
            try {
                parseInput(a, input);
            } catch (Exception e) {
                System.out.println("Number should be in 1 to 5!");
            }
        } while (JOptionPane.showConfirmDialog(null, "Enter again?", "elect an option", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION);
    }

    public static void parseInput(int[] a, String input) {
        int num = 0;
        int total = 0;
        double average = 0.0;

        try {
            System.out.println("Input length = " + input.length());
            num = Integer.parseInt(input);
            if (num == 0) {
                throw new ArithmeticException();
            }
            if (num < 0) {
                throw new NegativeNumberException();
            }
            total = 0;
            for (int i = 0; i < num; i++)
                total += a[i];
            average = total / num;
        } catch (NullPointerException e) {
            System.out.println("Input length = 0\nCancelled");
            throw e;
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No more than 5 please!");
            throw e;
        } catch (NumberFormatException e) {
            System.out.println("Integer please!");
            throw e;
        } catch (ArithmeticException e) {
            System.out.println("Don’t input zero!");
            throw e;
        } catch (RuntimeException e) {
            System.out.println("Run time error!");
            e.printStackTrace();
            return;
        } catch (Exception e) {
            System.out.println("Something wrong!");
            e.printStackTrace();
        } finally {
            System.out.println("Number = " + num);
        }
        System.out.println("Average over first " + num + " numbers = " + average);
    }
}
