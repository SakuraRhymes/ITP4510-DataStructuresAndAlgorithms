package Lab03.Lab3_3.Q1;

public class QueueFullException extends RuntimeException {
    public QueueFullException() {
        super("Queue is full.");
    }
}