package Lab01.Lab1_2;

public abstract class Food {
    protected String name;
    protected int price;

    public Food() {
        name = null;
        price = 0;
    }

    public Food(String name, int price) {
        this.name = name;
        setPrice(price);
    }

    public String toString() {
        return "name=" + name + ", price=" + price;
    }

    public abstract void setPrice(int price);
}

