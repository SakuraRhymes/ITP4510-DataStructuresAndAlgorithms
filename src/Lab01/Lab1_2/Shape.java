package Lab01.Lab1_2;

public abstract class Shape {
    protected String name;

    public Shape(String n) {
        name = n;
    }

    public abstract double getArea();

    public String getName() {
        return name;
    }
}

