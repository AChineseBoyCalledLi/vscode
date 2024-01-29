package reviewSec_Again;

public class Queue<E> {
    Object[] data;
    int head;
    int tail;

    public Queue(int len) {
        data = new Object[len + 1];
        head = tail = 0;
    }

    public void enqueue(Object value) throws Exception {
        if ((tail + 1) % data.length == head) {
            throw new Exception("FUll");
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
    }

    public Object dequeue() throws Exception {
        if (head == tail)
            throw new Exception("Empty");
        Object e = data[head];
        head = (head + 1) % data.length;
        return e;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = head; i < tail; i++) {
            sb.append(data[i]).append('-');
        }
        return sb.toString();
    }
}
