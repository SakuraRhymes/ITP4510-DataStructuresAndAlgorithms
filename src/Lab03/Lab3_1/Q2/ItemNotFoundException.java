package Lab03.Lab3_1.Q2;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException() {
        super("Item not found.");
    }
}
