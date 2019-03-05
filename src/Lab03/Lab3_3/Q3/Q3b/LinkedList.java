package Lab03.Lab3_3.Q3.Q3b;

public class LinkedList {
    private ListNode head;
    private int count;

    public LinkedList() {
        head = null;
        count = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int getCount() {
        return count;
    }

    public void addToHead(Object item) {
        count++;
        if (isEmpty()) {
            head = new ListNode(item);
        } else {
            head = new ListNode(item, head);
        }
    }

    public void addToTail(Object item) {
        count++;
        ListNode current;
        if (isEmpty()) {
            head = new ListNode(item);
        } else {
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(item);
        }
    }

    public Object removeFromHead() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        }
        count--;
        Object item = head.data;
        if (head.next == null) // there's only one single node
            head = null;
        else
            head = head.next;
        return item;
    }

    public Object removeFromTail() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        }
        count--;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        Object item = current.data;
        if (head.next == null) {   // there is only one node
            head = null;
            return item;
        }
        // search for the second last node
        current = head;
        while (current.next.next != null)
            current = current.next;
        // set second last node as new tail
        current.next = null;
        return item;
    }

    public String toString() {
        String s = "[ ";

        // traverse the list from head towards tail
        ListNode current = head;
        while (current != null) {
            s += current.data + " ";
            current = current.next;
        }
        return s + "]";
    }
}





