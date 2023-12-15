package reviewSecdYear;

import java.util.Arrays;
import java.util.Random;

public class review1 {
    public static void main(String[] args) {
        double[] arr = new double[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextDouble(100);
        }
        System.out.println(averageRec(arr, arr.length));
        System.out.println(Arrays.toString(arr));
        MergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
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
            a1[i] = a[i];
        }
        a1[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++) {
            a2[i] = a[i + n1];
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
        for (int j2 = p; j2 < newA.length; j2++) {
            a[j2] = newA[j2];
        }
    }
}
