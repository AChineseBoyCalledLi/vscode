public class eor {
    public static void main(String[] args) {

        // swap的测试用例
        // int[] a = { 1, 5, 23, 0, -1 };
        // System.out.println(a[0]);
        // System.out.println(a[2]);
        // swap(a, 0, 2);
        // System.out.println(a[0]);
        // System.out.println(a[2]);

        // 找一个出现奇数次的数
        // int[] o = { 1, 4, 5, 8, 4, 5, 1, 8, 9, 9, 9, 1, 1, 4, 5, 5, 4 };
        // findOne(o);

        // 找两个出现奇数次的数
        // int[] e = { 1, 4, 5, 8, 4, 5, 1, 8, 9, 9, 9, 1, 4, 5, 5, 4 };
        // findTwo(e);

        // 某个数的二进制有多少个1
        // bit1counts(1024);
    }

    // 交换
    static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    // 找到一个出现奇数次的数
    static void findOne(int[] a) {
        int eor = 0;
        for (int i = 0; i < a.length; i++) {
            eor ^= a[i];
        }
        System.out.println(eor);
    }

    // 找到两个出现奇数次的数
    static void findTwo(int[] a) {
        int eor = 0;
        for (int i = 0; i < a.length; i++) {
            eor ^= a[i];
        }
        int rightOne = eor & (~eor + 1);
        int first = 0;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & rightOne) == 0) {
                first ^= a[i];
            }
        }
        System.out.println("the first one is " + first + ", the second one is " + (eor ^ first));
    }

    // 某个数的二进制有多少个1
    static void bit1counts(int n) {
        int count = 0;
        while (n != 0) {
            int one = n & (~n + 1);
            count++;
            n ^= one;
        }
        System.out.println(count);
    }
}
