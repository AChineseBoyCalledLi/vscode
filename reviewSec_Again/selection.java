package reviewSec_Again;

public class selection {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (Method.compare(a[j], a[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                Method.swap(a, i, min);
            }
        }
    }
}
