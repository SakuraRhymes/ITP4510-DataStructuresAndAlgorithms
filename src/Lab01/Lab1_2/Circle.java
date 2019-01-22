package Lab01.Lab1_2;

public class Circle extends Shape {
    double radius;
    Point center;

    public Circle(double radius, double x, double y) {
        super("circle");
        this.radius = radius;
        center = new Point(x, y);
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "center=" + center + "; radius=" + radius;
    }
}
