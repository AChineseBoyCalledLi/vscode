package c2_linkedlist;

public class reverseList {
    public static void main(String[] args) {
        // 单向链表反转测试
        // Node n1 = new Node(1);
        // Node n2 = new Node(2);
        // Node n3 = new Node(3);
        // Node n4 = new Node(4);
        // n1.next = n2;
        // n2.next = n3;
        // n3.next = n4;

        // 测试双向链表反转
        // DoubleNode n1 = new DoubleNode(1);
        // DoubleNode n2 = new DoubleNode(2);
        // DoubleNode n3 = new DoubleNode(3);
        // DoubleNode n4 = new DoubleNode(4);
        // n1.next = n2;
        // n2.prev = n1;
        // n2.next = n3;
        // n3.prev = n2;
        // n3.next = n4;
        // n4.prev = n3;
        // System.out.println(n1);
        // System.out.println(reverse(n1));
    }

    static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    static DoubleNode reverse(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head.prev = next;
            head = next;
        }
        return pre;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " " + next;
        }
    }

    static class DoubleNode {
        int value;
        DoubleNode prev;
        DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }

        public String toString() {
            return value + " " + next;
        }
    }
}
