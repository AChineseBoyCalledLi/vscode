package reviewSec_Again;

public class mergesort {
    public static void sort(Comparable[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) >> 1;
            sort(a, p, q);
            sort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    public static void merge(Comparable[] a, int p, int q, int r) {
        Comparable[] left = new Comparable[q - p + 2];
        Comparable[] right = new Comparable[r - q + 1];
        for (int i = p; i <= q; i++) {
            left[i - p] = a[i];
        }
        for (int i = q + 1; i <= r; i++) {
            right[i - q - 1] = a[i];
        }
        left[q - p + 1] = Integer.MAX_VALUE;
        right[r - q] = Integer.MAX_VALUE;
        int idxl = 0;
        int idxr = 0;
        for (int i = p; i <= r; i++) {
            if (Method.compare(left[idxl], right[idxr]) > 0) {
                a[i] = right[idxr++];
            } else {
                a[i] = left[idxl++];
            }
        }
    }
}
