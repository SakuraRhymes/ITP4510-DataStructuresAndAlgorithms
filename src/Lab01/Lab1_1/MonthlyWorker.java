package Lab01.Lab1_1;

public class MonthlyWorker extends Worker {
    double monthlyWage;

    public MonthlyWorker(String name, double monthlyWage) {
        super(name);
        this.monthlyWage = monthlyWage;
    }

    public void setMonthlyWage(double monthlyWage) {
        this.monthlyWage = monthlyWage;
    }

    public double earnings() {
        salary = monthlyWage;
        return salary;
    }

    public String toString() {
        return super.toString() + " earned $" + monthlyWage + " in this month";
    }
}
