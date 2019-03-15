package Assignment;

public class WrongDeckCardNumbersException extends RuntimeException {
    public WrongDeckCardNumbersException() {
        super("The deck do not contain exactly 28 cards.");
    }
}
