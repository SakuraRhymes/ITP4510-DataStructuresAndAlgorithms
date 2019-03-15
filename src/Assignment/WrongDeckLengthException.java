package Assignment;

public class WrongDeckLengthException extends RuntimeException {
    public WrongDeckLengthException() {
        super("The deck do not contain exactly 28 cards.");
    }
}
