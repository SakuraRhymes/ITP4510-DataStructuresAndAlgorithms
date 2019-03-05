package Lab03.Lab3_3.Q3.Q3b;

public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException() {
        super("Queue is empty.");
    }
}
