package c4_sort;
import java.util.Arrays;
import java.util.Random;

public class mergesort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        mergesort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int sumPre(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }

    public static void mergesort1(int[] arr, int L, int R) {
        if (L < R) {
            int mid = L + ((R - L) >> 1);
            mergesort1(arr, L, mid);
            mergesort1(arr, mid + 1, R);
            merge(arr, L, mid, R);
        }
    }

    public static void mergesort2(int[] arr) {
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int mid = L + mergeSize - 1;
                if (mid >= N)
                    break;
                int R = Math.min(N - 1, mid + mergeSize);
                merge(arr, L, mid, R);
                L = R + 1;
            }
            if (mergeSize > (N >> 1))
                break;
            mergeSize <<= 1;
        }
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] aux = new int[R - L + 1];
        int i = 0;
        int i1 = L;
        int i2 = mid + 1;
        boolean flag = true;
        while (i1 <= mid && i2 <= R) {
            if (flag) {
                int a2 = mid + 1;
                while (a2 <= R && arr[i1] > arr[a2])
                    System.out.println(arr[i1] + " " + arr[a2++]);
            }
            if (arr[i1] <= arr[i2]) {
                aux[i++] = arr[i1++];
                flag = true;
            } else {
                aux[i++] = arr[i2++];
                flag = false;
            }
        }
        while (i1 <= mid) {
            aux[i++] = arr[i1++];
        }
        while (i2 <= R) {
            aux[i++] = arr[i2++];
        }
        for (int j = 0; j < aux.length; j++) {
            arr[j + L] = aux[j];
        }
    }

    static boolean compare() {
        int[] arr = new int[10];
        int size = 500000;
        while (size-- >= 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new Random().nextInt(500) - new Random().nextInt(500);
            }
            int[] cpy = Arrays.copyOf(arr, arr.length);
            Arrays.sort(cpy);
            mergesort2(arr);
            for (int i = 0; i < cpy.length; i++) {
                if (cpy[i] != arr[i]) {
                    System.out.println(Arrays.toString(cpy));
                    System.out.println(Arrays.toString(arr));
                    return false;
                }
            }
        }
        return true;
    }
}
