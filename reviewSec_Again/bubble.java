package reviewSec_Again;

public class bubble {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (Method.compare(a[j], a[j + 1]) > 0) {
                    Method.swap(a, j + 1, j);
                }
            }
        }
    }
}
