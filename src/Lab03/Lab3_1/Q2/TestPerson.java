package Lab03.Lab3_1.Q2;

public class TestPerson {
    public static void main(String[] args) {
        Comparator c = new PersonComparator();
        LinkedList s = new LinkedList(c);
        System.out.println(s);

        s.insertInOrder(new Person("Betty", 21));
        System.out.println(s);
        s.insertInOrder(new Person("Sandra", 19));
        System.out.println(s);
        s.insertInOrder(new Person("Alice", 32));
        System.out.println(s);
        s.insertInOrder(new Person("John", 15));
        System.out.println(s);
        s.insertInOrder(new Person("Kenneth", 19));
        System.out.println(s);

        s.removeItem(new Person("unknown", 15));
        System.out.println(s);
    }
}
