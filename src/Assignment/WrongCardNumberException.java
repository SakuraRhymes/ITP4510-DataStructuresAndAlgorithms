package Assignment;

public class WrongCardNumberException extends RuntimeException {
    public WrongCardNumberException() {
        super("The deck contain card number outside 1-28.");
    }
}
