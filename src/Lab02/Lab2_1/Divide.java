package Lab02.Lab2_1;

import java.util.Random;

public class Divide {
    public static void main(String[] args) {
        int a, n;

        for (int i = 0; i < 10; i++) {
            n = (int) (Math.random() * 10);
            try {
                a = 100 / n;
            } catch (ArithmeticException e) {
                System.out.println("Division by Zero");
                a = 0;
            }
            System.out.println("n:" + n + ", a:" + a);
        }
    }
}

