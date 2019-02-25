package Lab03.Lab3_1.Q2;

public class Test {
    public static void main(String[] args) {
        Comparator c = new StringComparator();
        LinkedList s = new LinkedList(c);
        System.out.println(s);

        s.insertInOrder("Betty");
        System.out.println(s);
        s.insertInOrder("Dave");
        System.out.println(s);
        s.insertInOrder("Catherine");
        System.out.println(s);
        s.insertInOrder("Thomas-1");
        System.out.println(s);
        s.insertInOrder("Sandra");
        System.out.println(s);
        s.insertInOrder("Thomas-2");
        System.out.println(s);
        s.insertInOrder("Alice-1");
        System.out.println(s);
        s.insertInOrder("Alice-2");
        System.out.println(s);
    }
}		
