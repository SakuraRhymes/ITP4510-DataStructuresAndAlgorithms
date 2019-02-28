package Lab03.Lab3_2.Q3;

public class StackFullException extends RuntimeException {
    public StackFullException() {
        super("Stack is full.");
    }
}
