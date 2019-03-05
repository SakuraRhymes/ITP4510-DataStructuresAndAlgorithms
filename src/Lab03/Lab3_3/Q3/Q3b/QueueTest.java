package Lab03.Lab3_3.Q3.Q3b;

public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new LinkedQueue();
        queue.enqueue("Alex");
        queue.enqueue("Sandy");
        queue.enqueue("Betty");
        System.out.println(queue);
        System.out.println("Removed: " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Removed: " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Removed: " + queue.dequeue());
        System.out.println(queue);
    }
}

