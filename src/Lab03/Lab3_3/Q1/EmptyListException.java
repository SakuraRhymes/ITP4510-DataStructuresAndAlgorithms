package Lab03.Lab3_3.Q1;

public class EmptyListException extends RuntimeException {
    public EmptyListException() {
        super("List is empty.");
    }
}
