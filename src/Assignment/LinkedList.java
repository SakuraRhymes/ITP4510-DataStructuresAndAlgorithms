package Assignment;

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int count;
    private int[] keyStream;

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

    private ListNode getNodeAt(int position) {
        ListNode current = head;

        if (position > 27)
            position = 27;

        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current;
    }

    private void doTripleCut() {
        ListNode firstPartHead, firstPartTail, secondPartHead, secondPartTail, thirdPartHead, thirdPartTail;
        int firstJoker, secondJoker, firstJokerPosition, secondJokerPosition;

        if (searchPosition(27) < searchPosition(28)) {
            firstJoker = 27;
            secondJoker = 28;
        } else {
            firstJoker = 28;
            secondJoker = 27;
        }

        firstJokerPosition = searchPosition(firstJoker);
        secondJokerPosition = searchPosition(secondJoker);

        firstPartHead = head;
        firstPartTail = getNodeAt(firstJokerPosition - 1);

        secondPartHead = getNodeAt(firstJokerPosition);
        secondPartTail = getNodeAt(secondJokerPosition);

        thirdPartHead = getNodeAt(secondJokerPosition + 1);
        thirdPartTail = tail;

        firstPartTail.next = null;
        secondPartTail.next = null;
        thirdPartTail.next = null;

        if (firstJokerPosition != 0 && secondJokerPosition != 27) {
            head = thirdPartHead;
            thirdPartTail.next = secondPartHead;
            secondPartTail.next = firstPartHead;
            tail = firstPartTail;
        } else if (firstJokerPosition == 0) {
            head = thirdPartHead;
            thirdPartTail.next = secondPartHead;
            tail.next = secondPartTail;
        } else if (secondJokerPosition == 27) {
            head = secondPartHead;
            secondPartTail.next = firstPartHead;
            tail = firstPartTail;
        }
    }

    private void doCountCut() {
        ListNode firstPartHead, firstPartTail, secondPartHead, secondPartTail;
        int cutCount;

        if ((int) tail.data == 27 || (int) tail.data == 28) {
            return;
        }

        cutCount = (int) tail.data;

        firstPartHead = head;
        firstPartTail = getNodeAt(cutCount - 1);

        secondPartHead = getNodeAt(cutCount);
        secondPartTail = getNodeAt(26);

        head = secondPartHead;
        secondPartTail.next = firstPartHead;
        firstPartTail.next = tail;
    }

    private boolean displayKeyValue(int keyCount) {
        int keyValue;

        if ((int) head.data == 28) {
            keyValue = (int) getNodeAt(27).data;
        } else {
            keyValue = (int) getNodeAt((int) head.data).data;
        }

        if (keyValue == 27 || keyValue == 28) {
            System.out.println("Joker: Key skipped");
            return false;
        }

        keyStream[keyCount] = keyValue;
        System.out.println("Key " + (keyCount + 1) + ": " + keyValue);
        return true;
    }

    private boolean nonDisplayKeyValue(int keyCount) {
        int keyValue;

        if ((int) head.data == 28) {
            keyValue = (int) getNodeAt(27).data;
        } else {
            keyValue = (int) getNodeAt((int) head.data).data;
        }

        if (keyValue == 27 || keyValue == 28) {
            return false;
        }

        keyStream[keyCount] = keyValue;
        return true;
    }

    public void displayKeyGeneration(int messageLength) {
        keyStream = new int[messageLength];
        int keyCount = 0;

        while (keyCount < messageLength) {
            moveDownLinkedList(27);
            System.out.println("S1: " + toString());
            moveDownLinkedList(28);
            moveDownLinkedList(28);
            System.out.println("S2: " + toString());
            doTripleCut();
            System.out.println("S3: " + toString());
            doCountCut();
            System.out.println("S4: " + toString());
            if (displayKeyValue(keyCount)) {
                keyCount++;
            }
        }

        System.out.print("Keystream value: [");
        for (int num : keyStream) {
            System.out.print(" " + num);
        }
        System.out.print(" ]");
    }

    public void displayEncryption(String message) {
        keyStream = new int[message.length()];
        int charCount = 0, ascii, encryptedAscii, keyCount = 0;
        char[] encryptedMessage = new char[message.length()];

        while (keyCount < message.length()) {
            moveDownLinkedList(27);
            moveDownLinkedList(28);
            moveDownLinkedList(28);
            doTripleCut();
            doCountCut();
            if (nonDisplayKeyValue(keyCount)) {
                keyCount++;
            }
        }

        for (char c : message.toCharArray()) {
            ascii = (int) c;
            encryptedAscii = (ascii - 64 + keyStream[charCount]) % 26;
            encryptedMessage[charCount] = (char) (encryptedAscii + 64);
            System.out.println(c + "\t" + (ascii - 64) + "\t" + keyStream[charCount] + "\t" + encryptedAscii + "\t" + encryptedMessage[charCount]);
            charCount++;
        }

        System.out.print("Encrypted message: ");
        for (char mgs : encryptedMessage) {
            System.out.print(mgs);
        }
    }

    public void displayDecryption(String message) {
        keyStream = new int[message.length()];
        int charCount = 0, ascii, decryptedAscii, keyCount = 0;
        char[] decryptedMessage = new char[message.length()];

        while (keyCount < message.length()) {
            moveDownLinkedList(27);
            moveDownLinkedList(28);
            moveDownLinkedList(28);
            doTripleCut();
            doCountCut();
            if (nonDisplayKeyValue(keyCount)) {
                keyCount++;
            }
        }

        for (char c : message.toCharArray()) {
            ascii = (int) c;
            decryptedAscii = (ascii - 64 - keyStream[charCount] + 26) % 26;
            decryptedMessage[charCount] = (char) (decryptedAscii + 64);
            System.out.println(c + "\t" + (ascii - 64) + "\t" + keyStream[charCount] + "\t" + decryptedAscii + "\t" + decryptedMessage[charCount]);
            charCount++;
        }

        System.out.print("Decrypted message: ");
        for (char mgs : decryptedMessage) {
            System.out.print(mgs);
        }
    }
}
