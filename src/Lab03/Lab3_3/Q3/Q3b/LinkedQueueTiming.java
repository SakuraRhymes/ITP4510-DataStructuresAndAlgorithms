package Lab03.Lab3_3.Q3.Q3b;

public class LinkedQueueTiming {
    public static void main(String[] args) {
        Queue queue = new LinkedQueue();

        if (args.length != 1)
            System.out.println("java QueueTest <num>");
        else {
            int count = Integer.parseInt(args[0]);
            long startTime = System.nanoTime();
            for (int i = 0; i < count; i++) {
                queue.enqueue(new Integer(i));
            }
            long endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        }
    }
}
