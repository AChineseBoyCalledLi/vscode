package reviewSecdYear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sort {
    public static void main(String[] args) {

    }

    // o(n^2)级别的：冒泡，选择，插入
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

    // o(nlog(n))级别的：快速、归并、堆
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

    static void maxHeapify(int[] A, int heapsize, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < heapsize && A[left] > A[largest])
            largest = left;
        if (right < heapsize && A[right] > A[largest])
            largest = right;
        if (largest != i) {
            swap(A, i, largest);
            maxHeapify(A, heapsize, largest);
        }
    }

    static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    static void buildMinHeap(int[] A) {
        int heapsize = A.length;
        for (int i = heapsize / 2 - 1; i > -1; i--) {
            maxHeapify(A, heapsize, i);
        }
    }

    static void heapsort(int[] A) {
        buildMinHeap(A);
        int heapsize = A.length;
        for (int i = heapsize; i > 1; i--) {
            swap(A, --heapsize, 0);
            maxHeapify(A, heapsize, 0);
        }
    }

    // o(n)级别：计数、基数
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
