package reviewSec_Again;

public class LinkedList_Nocircle<E> {
    Node<E> head;

    public void add(E element) {
        Node<E> node = new Node<>(element);
        node.next = this.head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        node.prev = null;
    }

    public Node<E> Search(E element) {
        Node<E> node = head;
        while (node != null && node.key != element) {
            node = node.next;
        }
        return node;
    }

    public Node<E> remove(E element) throws Exception {
        Node<E> node = Search(element);
        if (node == null)
            throw new Exception("ELEMENT_NOT_FOUND");
        if (node.next != null)
            node.next.prev = node.prev;
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        return node;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node<E> node = head;
        while (node != null) {
            sb.append(node).append('-');
            node = node.next;
        }
        return sb.toString();
    }
}
