package Lab01.Lab1_1;

public class TestWorker {
    public static void main(String[] args) {
        Worker[] w = new Worker[4];

        w[0] = new Worker("Peter");
        w[1] = new CommissionWorker("John", 120, 10);
        w[2] = new HourlyWorker("Mary", 25, 40);
        w[3] = new MonthlyWorker("Paul", 1500);

        for (int i = 0; i < w.length; i++)
            System.out.println(w[i]);
    }
}

