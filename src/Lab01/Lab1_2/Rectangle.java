package Lab01.Lab1_2;

public class Rectangle extends Shape {
    Point topLeft;
    double width;
    double height;

    public Rectangle(double x, double y, double width, double height) {
        super("rectangle");
        topLeft = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public String toString() {
        return "top left=" + topLeft + "; width=" + width + "; height=" + height;
    }
}
