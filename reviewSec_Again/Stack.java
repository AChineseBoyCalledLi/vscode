package reviewSec_Again;

import java.util.Arrays;

public class Stack<E> {
    Object[] data;
    int top;

    public Stack(int len) {
        data = new Object[len];
        top = -1;
    }

    public void push(E value) throws Exception {
        if (top == data.length - 1)
            throw new Exception("overflow");
        data[++top] = value;
    }

    public Object pop() throws Exception {
        if (top < 0)
            throw new Exception("underflow");
        return data[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= top; i++) {
            sb.append(data[i]).append('-');
        }
        return sb.toString();
    }
}
