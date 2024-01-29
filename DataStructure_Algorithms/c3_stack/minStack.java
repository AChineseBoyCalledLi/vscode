package c3_stack;

import java.util.Random;

public class minStack {
    public static void main(String[] args) {
        Stack s = new Stack(5);
        for (int i = 0; i < 5; i++) {
            int t = new Random().nextInt(500);
            s.push(t);
            System.out.println(t);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(s.getMin());
            s.pop();
        }
    }
}

class Stack {
    int[] data;
    int[] min;
    int top;

    public Stack(int size) {
        data = new int[size];
        min = new int[size];
        top = -1;
    }

    public int pop() {
        return data[top--];
    }

    public void push(int value) {
        data[++top] = value;
        if (top != 0) {
            min[top] = value > min[top - 1] ? min[top - 1] : value;
        } else
            min[top] = value;
    }

    public int getMin() {
        return min[top];
    }
}
