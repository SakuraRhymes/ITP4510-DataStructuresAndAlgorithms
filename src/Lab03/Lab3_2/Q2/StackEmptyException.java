package Lab03.Lab3_2.Q2;

public class StackEmptyException extends RuntimeException {
    public StackEmptyException() {
        super("Stack is empty.");
    }
}
