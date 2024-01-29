package reviewSecdYear;

public class test {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> l1 = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            l1.insert(i);
        }
        l1.delete(0);
        l1.delete(3);
        l1.insert(2);
        System.out.println(l1);
    }
}

class LinkedList<E> {
    Node<E> nil;

    public LinkedList() {
        this.nil = new Node<>(null);
        nil.next = nil;
        nil.prev = nil;
    }

    public Node<E> search(E value) {
        Node<E> node = nil.next;
        while (node != nil && node.key != value) {
            node = node.next;
        }
        return node;
    }

    public void insert(E value) {
        Node<E> node = new Node<>(value);
        node.next = nil.next;
        nil.next.prev = node;
        node.prev = nil;
        nil.next = node;
    }

    public Node<E> delete(E value) throws Exception {
        Node<E> node = search(value);
        if (node == nil) {
            throw new Exception("ELEMENT_NOT_FOUND_ERROR");
        }
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return node;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node<E> node = nil.next;
        sb.append('[');
        while (node != nil) {
            sb.append('_').append(node);
            node = node.next;
        }
        sb.append(']');
        return sb.toString();
    }
}

class Node<E> {
    E key;
    Node<E> next;
    Node<E> prev;

    public Node(E key) {
        this.key = key;
    }

    public String toString() {
        return "" + key;
    }
}
