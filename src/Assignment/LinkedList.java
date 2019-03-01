package Assignment;

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int count;

    public LinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int getCount() {
        return count;
    }

    public Object getItemAt(int n) {
        if (n < 0 || n >= count)
            throw new IndexOutOfBoundsException();

        int currentPos = 0;
        ListNode current = head;
        while (currentPos < n) {
            current = current.next;
            currentPos++;
        }
        return current.data;
    }

    public void addToHead(Object item) {
        count++;
        if (isEmpty()) {
            head = tail = new ListNode(item);
        } else {
            head = new ListNode(item, head);
        }
    }

    public void addToTail(Object item) {
        count++;
        if (isEmpty()) {
            head = tail = new ListNode(item);
        } else {
            tail.next = new ListNode(item);
            tail = tail.next;
        }
    }

    public Object removeFromHead() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        }
        count--;
        Object item = head.data;
        if (head == tail) // there's only one single node
            head = tail = null;
        else
            head = head.next;
        return item;
    }

    public Object removeFromTail() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        }
        count--;
        Object item = tail.data;
        if (head == tail) {   // there is only one node
            head = tail = null;
            return item;
        }
        // search for the second last node
        ListNode current = head;
        while (current.next != tail)
            current = current.next;
        // set second last node as new tail
        tail = current;
        tail.next = null;
        return item;
    }

    public String toString() {
        String s = "[ ";
        ListNode current = head;
        while (current != null) {
            s += current.data + " ";
            current = current.next;
        }
        return s + "]";
    }

    private int searchPosition(int cardNumber) {
        int position = 0;
        ListNode current = head;

        while (current != null) {
            if ((int) current.data == cardNumber) {
                break;
            }
            current = current.next;
            position++;
        }
        return position;
    }

    private void moveDownLinkedList(int cardNumber) {
        int position = searchPosition(cardNumber);
        ListNode current = head;

        Object data = getItemAt(position);
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        if (current.next == null) {
            current.data = head.data;
            head.data = data;
            return;
        }
        current.data = current.next.data;
        current.next.data = data;
    }

    private void displayStep(int step) {
        System.out.println("S" + step + ": " + toString());
    }

    public void displayKeyGeneration(int messageLength) {
        moveDownLinkedList(27);
        displayStep(1);
        moveDownLinkedList(28);
        moveDownLinkedList(28);
        displayStep(2);
    }
}





