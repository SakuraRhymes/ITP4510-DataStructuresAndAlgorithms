package Lab03.Lab3_4.Q2.Q2b;

public class EmptyListException extends RuntimeException {
    public EmptyListException() {
        super("List is empty.");
    }
}
