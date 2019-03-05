package Lab03.Lab3_3.Q2;

public class QueueFullException extends RuntimeException {
    public QueueFullException() {
        super("Queue is full.");
    }
}
