package Lab03.Lab3_3.Q3.Q3a;

public class QueueFullException extends RuntimeException {
    public QueueFullException() {
        super("Queue is full.");
    }
}