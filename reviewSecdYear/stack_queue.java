package reviewSecdYear;

import java.net.Socket;
import java.util.Arrays;

public class stack_queue {
    public static void main(String[] args) throws Exception {
        // Stack<Integer> s = new Stack<>(10);
        // for (int i = 0; i < 10; i++) {
        // s.push(3 + i);
        // }
        // // s.push(1);
        // // for (int i = 0; i < 10; i++) {
        // // s.pop();
        // // }
        // // System.out.println(s);
        // Queue<Integer> q = new Queue<>(10);
        // for (int i = 0; i < 10; i++) {
        // q.enqueue(3 + i);
        // }
        // // for (int i = 0; i < 10; i++) {
        // // q.dequeue();
        // // }
        // System.out.println(q);
        // System.out.println(q.isEmpty());

        // Queue_stacks_1<Integer> q1 = new Queue_stacks_1<>(5);
        // Queue_stacks_2<Integer> q2 = new Queue_stacks_2<>(5);
        // for (int i = 0; i < 5; i++) {
        // q1.enqueue(i);
        // q2.enqueue(i);
        // }
        // for (int i = 0; i < 2; i++) {
        // q1.dequeue();
        // q2.dequeue();
        // }
        // q1.enqueue(4);
        // q2.enqueue(4);
        // System.out.println(q2);
        // System.out.println(q1);

        // Stack_queues_1<Integer> s1 = new Stack_queues_1<>(5);
        // Stack_queues_2<Integer> s2 = new Stack_queues_2<>(5);

        // for (int i = 0; i < 6; i++) {
        // s2.push(i);
        // }
        // s2.pop();
        // s2.push(5);
        // for (int i = 0; i < 6; i++) {
        // s2.pop();
        // }
        // System.out.println(s2);

        Stack<Integer> s = new Stack<>(10);
        for (int i = 0; i < 5; i++) {
            s.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(s.pop());
        }

    }
}

class Stack<E> {
    private int top;
    private Object[] data;

    public Stack(int len) {
        this.top = -1;
        this.data = new Object[len];
    }

    public void push(E value) throws Exception {
        if (top + 1 == data.length)
            throw new Exception("Overflow");
        data[++top] = value;
    }

    public Object pop() throws Exception {
        if (top < 0)
            throw new Exception("underflow");
        return data[top--];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i <= top; i++) {
            sb.append(data[i]).append('_');
        }
        sb.append(']');
        return sb.toString();
    }
}

class Queue<E> {
    private Object[] data;
    private int head;
    private int tail;

    public Queue(int len) {
        this.data = new Object[len + 1];
        head = tail = 0;
    }

    public void enqueue(E value) throws Exception {
        if ((tail + 1) % data.length == head)
            throw new Exception("Full");
        data[tail] = value;
        tail = (tail + 1) % data.length;
    }

    public Object dequeue() throws Exception {
        if (head == tail)
            throw new Exception("Empty");
        Object value = data[head];
        head = (head + 1) % data.length;
        return value;
    }

    public Boolean isEmpty() {
        return head == tail;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int idx = head;
        sb.append('[');
        while (idx != tail) {
            sb.append(data[idx]).append('_');
            idx = (idx + 1) % data.length;
        }
        sb.append(']');
        return sb.toString();
    }
}

class Queue_stacks_1<E> {
    private Stack<E> inbox;
    private Stack<E> outbox;

    public Queue_stacks_1(int len) {
        inbox = new Stack<>(len);
        outbox = new Stack<>(len);
    }

    public void enqueue(E value) throws Exception {
        inbox.push(value);
    }

    public Object dequeue() throws Exception {
        if (outbox.isEmpty()) {
            if (inbox.isEmpty())
                throw new Exception("Empty");
            while (!inbox.isEmpty()) {
                outbox.push((E) inbox.pop());
            }
        }
        return outbox.pop();
    }

    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    public String toString() {
        return inbox.toString() + outbox.toString();
    }
}

class Queue_stacks_2<E> {
    private Stack<E> in_outbox;
    private Stack<E> auxiliary_box;

    public Queue_stacks_2(int len) {
        in_outbox = new Stack<>(len);
        auxiliary_box = new Stack<>(len);
    }

    public void enqueue(E value) throws Exception {
        while (!in_outbox.isEmpty()) {
            auxiliary_box.push((E) in_outbox.pop());
        }
        in_outbox.push(value);
        while (!auxiliary_box.isEmpty()) {
            in_outbox.push((E) auxiliary_box.pop());
        }
    }

    public Object dequeue() throws Exception {
        return in_outbox.pop();
    }

    public boolean isEmpty() {
        return in_outbox.isEmpty();
    }

    public String toString() {
        return in_outbox.toString();
    }
}

class Stack_queues_1<E> {
    private Queue<E> q1;
    private Queue<E> q2;

    public Stack_queues_1(int len) {
        q1 = new Queue<>(len);
        q2 = new Queue<>(len);
    }

    public void push(E value) throws Exception {
        if (q2.isEmpty())
            q1.enqueue(value);
        else
            q2.enqueue(value);
    }

    public Object pop() throws Exception {
        Object element = null;
        Queue<E> q = q1.isEmpty() ? q2 : q1;
        if (q.isEmpty())
            throw new Exception("Underflow");
        while (!q.isEmpty()) {
            element = q1.dequeue();
            if (q1.isEmpty())
                break;
            q2.enqueue((E) element);
        }
        return element;
    }

    public String toString() {
        return q1.toString() + q2.toString();
    }
}

class Stack_queues_2<E> {
    private Queue<E> q1;
    private Queue<E> q2;

    public Stack_queues_2(int len) {
        q1 = new Queue<>(len);
        q2 = new Queue<>(len);
    }

    public void push(E value) throws Exception {
        while (!q1.isEmpty())
            q2.enqueue((E) q1.dequeue());
        q1.enqueue(value);
        while (!q2.isEmpty())
            q1.enqueue((E) q2.dequeue());
    }

    public Object pop() throws Exception {
        return q1.dequeue();
    }

    public String toString() {
        return q1.toString();
    }
}
