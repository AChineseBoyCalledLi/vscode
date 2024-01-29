package reviewSecdYear;

import java.util.Arrays;

public class review2 {
    public static void main(String[] args) throws Exception {
        int[] a = { 1, -231, 4, 234, 44, -3, 0 };
        buildMinHeap(a);
        System.out.println(Arrays.toString(a));
        max_increase_key(a, 3, 200);
        System.out.println(Arrays.toString(a));

    }

    static void maxHeapify(int[] A, int heapsize, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < heapsize && A[left] > A[largest])
            largest = left;
        if (right < heapsize && A[right] > A[largest])
            largest = right;
        if (largest != i) {
            swap(A, i, largest);
            maxHeapify(A, heapsize, largest);
        }
    }

    static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    static void buildMinHeap(int[] A) {
        int heapsize = A.length;
        for (int i = heapsize / 2 - 1; i > -1; i--) {
            maxHeapify(A, heapsize, i);
        }
    }

    static void heapsort(int[] A) {
        buildMinHeap(A);
        int heapsize = A.length;
        for (int i = heapsize; i > 1; i--) {
            swap(A, --heapsize, 0);
            maxHeapify(A, heapsize, 0);
        }
    }

    static void max_increase_key(int[] A, int i, int key) throws Exception {
        if (A[i] > key) {
            throw new Exception("Key should be greater than Heap[i]");
        }
        A[i] = key;
        while (i > 0 && A[i] > A[parent(i)]) {
            swap(A, i, parent(i));
            i = parent(i);
        }
    }

    static int parent(int i) {
        return (i - 1) / 2;
    }
}
