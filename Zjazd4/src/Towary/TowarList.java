package Towary;

/**
 * @author bartosz.kalinowski
 */
public class TowarList {

    TowarNode head;
    TowarNode tail;
    private int size;

    TowarList() {
        head = tail = null;
        size = 0;
    }

    TowarList(TowarNode t) {
        head = tail = t;
        size = 1;
    }

    synchronized void add(Towar t) {
        TowarNode node = new TowarNode(t);
        if (head == null) {
            head = tail = node;
        } else if (head == tail) {
            tail = node;
            head.next = tail;
            tail.prev = head;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    synchronized Towar get(int i) {
        TowarNode node = head;
        if (node == null) {
            return null;
        }

        if (i >= size) {
            return null;
        }

        if (size - i >= i) {
            int counter = 0;
            while (counter < i) {
                node = node.next;
                counter++;
            }
        } else {
            node = tail;
            int counter = size-1;
            while (counter > i) {
                node = node.prev;
                counter--;
            }
        }

        if (node != null) {
            return node.towar;
        } else {
            return null;
        }
    }

    int size() {
        return size;
    }
}
