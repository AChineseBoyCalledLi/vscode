package reviewSec_Again;

public class heap {
    public static void Heapify(Comparable[] a, int heapsize, int r) {
        int left = 2 * r + 1;
        int right = 2 * r + 2;
        int largest = r;
        if (left < heapsize && Method.compare(a[left], a[largest]) > 0) {
            largest = left;
        }
        if (right < heapsize && Method.compare(a[right], a[largest]) > 0) {
            largest = right;
        }
        if (largest != r) {
            Method.swap(a, r, largest);
            Heapify(a, heapsize, largest);
        }
    }

    public static void buildHeap(Comparable[] a) {
        int heapsize = a.length;
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            Heapify(a, heapsize, i);
        }
    }

    public static void sort(Comparable[] a) {
        buildHeap(a);
        int heapsize = a.length;
        for (int i = 0; i < a.length - 1; i++) {
            Method.swap(a, --heapsize, 0);
            Heapify(a, heapsize, 0);
        }
    }

    public static void max_increasing_key(Comparable a) {
        
    }
}
