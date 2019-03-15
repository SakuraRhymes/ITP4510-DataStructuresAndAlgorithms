package Assignment;

public class DuplicateCardException extends RuntimeException {
    public DuplicateCardException() {
        super("The deck contain duplicate card.");
    }
}
