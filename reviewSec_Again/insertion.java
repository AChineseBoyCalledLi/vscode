package reviewSec_Again;

public class insertion {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int idx = i - 1;
            Comparable key = a[i];
            while (idx > -1 && Method.compare(key, a[idx]) < 0) {
                a[idx + 1] = a[idx];
                a[idx--] = key;
            }
        }
    }
}
