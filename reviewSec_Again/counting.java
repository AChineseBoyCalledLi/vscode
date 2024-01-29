package reviewSec_Again;

public class counting {
    public static void sort(int[] a) {
        int max = find(a);
        int[] c = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            b[--c[a[i]]] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    public static int find(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
}
