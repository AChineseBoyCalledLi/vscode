package reviewSecdYear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class review1 {
    public static void main(String[] args) {
        // double[] arr = new double[10];
        // Random r = new Random();
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = r.nextDouble(100);
        // }
        // // System.out.println(averageRec(arr, arr.length));
        // double[] a = { 6, 5, 4, 3, 2, 1, };
        // double[] b = { 1, 2, 3, 4, 5, 6 };
        // double[] c = { 0, -12, 31, -23, 12, 23, 9, -2 };
        // quicksort(a, 0, a.length - 1);
        // System.out.println(Arrays.toString(a));
        // quicksort(b, 0, b.length - 1);
        // System.out.println(Arrays.toString(b));
        // quicksort(c, 0, c.length - 1);
        // // System.out.println(Arrays.toString(c));
        // double[] d = { 0, -12, 31, -23, 12, 23, 9, -2 };
        // // bubble(d);
        // // selection(d);
        // insertion(d);
        // System.out.println(Arrays.toString(d));
        // int[] b = { 1, 9, 43, 0, 2, 4325, 234, 66, 9 };
        // counting_2(b);
        // System.out.println(Arrays.toString(b));
        int[] a = { 12, 22, 32, 43, 41, 04, 9, 34, 91 };
        radix_1(a);
        System.out.println(Arrays.toString(a));

    }

    static double averageRec(double[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        return (averageRec(a, n - 1) * (n - 1) + a[n - 1]) / n;
    }

    static double avg(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length;
    }

    static void MergeSort(double[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            MergeSort(a, p, q);
            MergeSort(a, q + 1, r);
            Merge(a, p, q, r);
        }
    }

    static void Merge(double[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        double[] a1 = new double[n1 + 1];
        double[] a2 = new double[n2 + 1];
        for (int i = 0; i < n1; i++) {
            a1[i] = a[p + i];
        }
        a1[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++) {
            a2[i] = a[p + i + n1];
        }
        a2[n2] = Integer.MAX_VALUE;

        double[] newA = new double[n1 + n2];
        int i = 0;
        int j = 0;
        for (int j2 = 0; j2 < newA.length; j2++) {
            if (a1[i] < a2[j])
                newA[j2] = a1[i++];
            else
                newA[j2] = a2[j++];
        }
        for (int j2 = 0; j2 < newA.length; j2++) {
            a[j2 + p] = newA[j2];
        }
    }

    static void quicksort(double[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quicksort(a, p, q - 1);
            quicksort(a, q + 1, r);
        }
    }

    static int partition(double[] a, int p, int r) {
        double x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] < x) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, r, i + 1);
        return i + 1;
    }

    static void swap(double[] a, int a1, int a2) {
        double t = a[a1];
        a[a1] = a[a2];
        a[a2] = t;
    }

    static void bubble(double[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    double t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    static void selection(double[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = 0; j < a.length; j++) {
                if (a[min] > a[j])
                    min = j;
            }
            if (min != i)
                swap(a, i, min);
            System.out.println(Arrays.toString(a));
        }
    }

    static void insertion(double[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            double key = a[i];
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                a[j--] = key;
            }
        }
    }

    static void counting(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        int[] c = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }
        int j = 0;
        for (int i = 0; i < c.length; i++) {
            while (c[i] > 0) {
                a[j++] = i;
                c[i]--;
            }
        }
    }

    static void counting_1(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        int[] c = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        int j = 0;
        if (c[0] > 0) {
            int len = c[0];
            while (len-- > 0) {
                a[j++] = 0;
            }
        }
        for (int i = 1; i < c.length; i++) {
            if (c[i] - c[i - 1] != 0) {
                int len = c[i] - c[i - 1];
                while (len-- > 0) {
                    a[j++] = i;
                }
            }
        }
    }

    static void counting_2(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        int[] c = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            b[--c[a[i]]] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    static void radix(int[] a) {
        int[] a1 = new int[a.length];
        int[] a0 = new int[a.length];
        int idx1 = 0;
        int idx0 = 0;
        for (int j = 0; j < 32; j++) {

            for (int i = 0; i < a.length; i++) {
                if (((a[i] >> j) & 1) == 1) {
                    a1[idx1++] = a[i];
                } else {
                    a0[idx0++] = a[i];
                }
            }
            for (int i = a.length - 1; i >= 0; i--) {
                if (idx1 > 0) {
                    a[i] = a1[--idx1];
                } else {
                    a[i] = a0[--idx0];
                }
            }
        }
    }

    static void radix_1(int[] a) {
        for (int i = 0; i < 32; i++) {
            List<Integer> a0 = new ArrayList<>();
            List<Integer> a1 = new ArrayList<>();
            for (Integer x : a) {
                if (((x >> i) & 1) == 1)
                    a1.add(x);
                else
                    a0.add(x);
            }
            int j = 0;
            for (int integer : a0) {
                a[j++] = integer;
            }
            for (int integer : a1) {
                a[j++] = integer;
            }
        }
    }
}
