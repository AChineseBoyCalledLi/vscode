package reviewSec_Again;

public class LinkedList<E> {
    Node<E> nil = new Node<>(null);

    public LinkedList() {
        nil.prev = nil.next = nil;
    }

    public void add(E element) {
        Node<E> node = new Node<>(element);
        node.next = nil.next;
        nil.next.prev = node;
        nil.next = node;
        node.prev = nil;
    }

    public Node<E> Search(E element) {
        Node<E> node = nil.next;
        while (node != nil && node.key != element) {
            node = node.next;
        }
        return node;
    }

    public Node<E> remove(E element) throws Exception {
        Node<E> node = Search(element);
        if (node == nil)
            throw new Exception("ELEMENT_NOT_FOUND");
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public String toString() {
        Node<E> node = nil.next;
        StringBuffer sb = new StringBuffer();
        while (node != nil) {
            sb.append(node).append('_');
            node = node.next;
        }
        return sb.toString();
    }

}

class Node<E> {
    E key;
    Node<E> prev;
    Node<E> next;

    public Node(E key) {
        this.key = key;
        prev = null;
        next = null;
    }

    public String toString() {
        return key + "";
    }
}
