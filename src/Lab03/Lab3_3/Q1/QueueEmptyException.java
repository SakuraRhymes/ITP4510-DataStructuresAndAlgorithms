package Lab03.Lab3_3.Q1;

public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException() {
        super("Queue is empty.");
    }
}
