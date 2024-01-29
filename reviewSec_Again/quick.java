package reviewSec_Again;

import reviewSecdYear.sort;

public class quick {
    public static void sort(Comparable[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            sort(a, p, q - 1);
            sort(a, q + 1, r);
        }
    }

    public static int partition(Comparable[] a, int p, int r) {
        Comparable x = a[r];
        int idx = p - 1;
        for (int i = p; i < r; i++) {
            if (Method.compare(x, a[i]) > 0) {
                Method.swap(a, ++idx, i);
            }
        }
        Method.swap(a, r, idx + 1);
        return idx + 1;
    }
}
