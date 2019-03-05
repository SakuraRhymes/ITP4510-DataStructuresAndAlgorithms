package Lab03.Lab3_3.Q3.Q3b;

public class EmptyListException extends RuntimeException {
    public EmptyListException() {
        super("List is empty.");
    }
}
