package reviewSec_Again;

public class Method {
    public static void swap(Comparable[] a, int a1, int a2) {
        Comparable t = a[a1];
        a[a1] = a[a2];
        a[a2] = t;
    }

    public static int compare(Comparable a, Comparable b) {
        return a.compareTo(b);
    }
}
