package Lab03.Lab3_1.Q1;

import java.util.EmptyStackException;

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int count;

    public LinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public int sillyCount() {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
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
        Object item = null;
        if (isEmpty()) {
            throw new EmptyListException();
        }
        count--;
        item = head.data;
        if (head == tail)      // there's only one single node
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
        ListNode current = head;
        while (current.next != tail)
            current = current.next;
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

    public Object removeItemAt(int n) {
        if (n < 0 || n >= count)
            throw new IndexOutOfBoundsException();
        if (n == 0)
            return removeFromHead();

        count--;
        int currentPos = 0;
        ListNode current = head;
        while (currentPos < (n - 1)) { // locate the node preceding the one to be removed
            current = current.next;
            currentPos++;
        }

        Object item = current.next.data;
        current.next = current.next.next;
        return item;
    }

    public void addItemAt(Object item, int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty() || n == 0) {
            addToHead(item);
            return;
        }
        if (n >= count) {
            addToTail(item);
            return;
        }

        count++;
        int currentPos = 0;
        ListNode current = head;
        while (currentPos < (n - 1)) { // locate the node preceding the one to be removed
            current = current.next;
            currentPos++;
        }

        ListNode newNode = new ListNode(item);  // create a new node
        newNode.next = current.next;
        current.next = newNode;
    }

}
