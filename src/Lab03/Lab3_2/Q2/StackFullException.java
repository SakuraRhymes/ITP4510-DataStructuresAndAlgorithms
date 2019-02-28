package Lab03.Lab3_2.Q2;

public class StackFullException extends RuntimeException {
    public StackFullException() {
        super("Stack is full.");
    }
}
