package Lab03.Lab3_1.Q2;

public class EmptyListException extends RuntimeException {
    public EmptyListException() {
        super("List is empty.");
    }
}
