package Lab03.Lab3_1.Q1;

public class SllTest {
    public static void main(String[] args) {
        LinkedList s = new LinkedList();
        System.out.println(s);
        System.out.println("Number of elements = " + s.sillyCount());
        s.addToTail(new Integer(42));
        System.out.println(s);
        s.addToTail(new Character('n'));
        System.out.println(s);
        s.addToTail(new String("hello"));
        System.out.println(s);
        s.addToHead(new String("apple"));
        System.out.println(s);
        System.out.println("Number of elements = " + s.sillyCount());
        while (!s.isEmpty()) {
            System.out.println("removed: " + s.removeFromHead());
            System.out.println(s);
        }
        System.out.println("Number of elements = " + s.sillyCount());
    }
}
