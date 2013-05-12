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

    void add(Towar t) {
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
    
    void push(Towar t) {
        TowarNode node = new TowarNode(t);
        if (head == null) {
            head = tail = node;
        } else if (head == tail) {
            head = node;
            head.next = tail;
            tail.prev = head;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }
    
    Towar popBack() {
        if (size > 0 && tail != null) {
            size--;
            if (tail == head) {
                Towar t = tail.towar;
                tail = null;
                head = null;
                return t;
            } else {
                Towar t = tail.towar;
                tail = tail.prev;
                tail.next = null;
                return t;
            }
        } else {
            return null;
        }
    }
    
    

    Towar get(int i) {
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
