package Lab03.Lab3_3.Q3.Q3a;

public interface Queue {
    public abstract boolean isEmpty();

    public abstract int size();

    public abstract Object front() throws QueueEmptyException;

    public abstract void enqueue(Object item) throws QueueFullException;

    public abstract Object dequeue() throws QueueEmptyException;
}

