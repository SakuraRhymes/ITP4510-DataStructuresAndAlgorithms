package Lab03.Lab3_3.Q3.Q3a;

public class EmptyListException extends RuntimeException {
    public EmptyListException() {
        super("List is empty.");
    }
}
