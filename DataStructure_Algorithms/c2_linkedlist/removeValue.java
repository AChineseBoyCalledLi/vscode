package c2_linkedlist;

import c2_linkedlist.reverseList.Node;

public class removeValue {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(remove(n1, 3));

    }

    static Node remove(Node head, int key) {
        while (head != null) {
            if (head.value == key)
                head = head.next;
            else
                break;
        }
        Node cur = head;
        Node pre = head; // 记录不是要找的值的最后一个节点

        while (cur != null) {
            if (cur.value == key)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
