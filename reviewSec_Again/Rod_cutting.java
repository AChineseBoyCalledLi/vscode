package reviewSec_Again;

public class Rod_cutting {
    public static int Recursion(int[] a, int n) {
        if (n == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i] + Recursion(a, n - 1 - i));
        }
        return max;
    }

    public static int Top_down(int[] a, int n) {
        int[] mem = new int[n];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = Integer.MIN_VALUE;
        }
        return mem(a, n, mem);
    }

    public static int mem(int[] a, int n, int[] mem) {
        if (n == 0)
            return 0;
        if (mem[n - 1] >= 0)
            return mem[n - 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i] + mem(a, n - 1 - i, mem));
        }
        mem[n - 1] = max;
        return max;
    }

    public static int DP(int[] a) {
        int[] dp = new int[a.length + 1];
        dp[1] = a[0];
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + a[i - 1 - j]);
            }
        }
        return dp[a.length];
    }
}
