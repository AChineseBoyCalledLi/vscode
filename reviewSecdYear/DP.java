package reviewSecdYear;

import java.util.ArrayList;

public class DP {
    public static void main(String[] args) {
        // int[] a = { 100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79,
        // 94, 90, 97 };
        // System.out.println(Max_subarray_1(a));
        // System.out.println(Max_subarray_2(a));
        // int[] b = new int[a.length];
        // for (int i = 1; i < b.length; i++) {
        // b[i] = a[i] - a[i - 1];
        // }
        // System.out.println(Max_subarray_3(b, 0, a.length - 1));

        // Climb_stairs(41);

        // Unique_paths(3, 3);
        // int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        // System.out.println(uniquePathsWithObstacles(obstacleGrid));
        // int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
        // Dungeon_Game(dungeon);

        // int[] p = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

        // System.out.println(rod_cutting_re(p, 10));
        // System.out.println(rod_cutting_mem(p, p.length - 2));
        // System.out.println(rod_cutting_downtop(p, 9));

        // System.out.println(Combination(new StringBuffer("abdde"), new StringBuffer("
        // "), 0));
        // System.out.println();

        System.out.println(coins(new int[] { 1, 2, 5 }, new ArrayList<>(), 18));
    }

    public static int Max_subarray_1(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] - a[i] > max) {
                    max = a[j] - a[i];
                }
            }
        }
        return max;
    }

    public static int Max_subarray_2(int[] a) {
        if (a.length == 1)
            return 0;
        int[] dp = new int[a.length];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1], a[i] - min);
            min = Math.min(min, a[i]);
        }
        return dp[a.length - 1];
    }

    public static Max_subarray Max_subarray_3(int[] a, int low, int high) {
        if (high == low) {
            return new Max_subarray(a[low], low, high);
        }
        int mid = (low + high) >> 1;
        Max_subarray left = Max_subarray_3(a, low, mid);
        Max_subarray right = Max_subarray_3(a, mid + 1, high);
        Max_subarray middle = crossing(a, low, mid, high);
        if (left.sum >= right.sum && left.sum >= middle.sum) {
            return left;
        } else if (right.sum >= left.sum && right.sum >= middle.sum) {
            return right;
        } else {
            return middle;
        }
    }

    public static Max_subarray crossing(int[] a, int low, int mid, int high) {
        int left = Integer.MIN_VALUE;
        int sum = 0;
        int leftidx = mid;
        for (int i = mid; i > 0; i--) {
            sum += a[i];
            if (sum > left) {
                left = sum;
                leftidx = i;
            }
        }
        int right = Integer.MIN_VALUE;
        sum = 0;
        int rightidx = mid;
        for (int i = mid + 1; i <= high; i++) {
            sum += a[i];
            if (sum > right) {
                right = sum;
                rightidx = i;
            }
        }
        return new Max_subarray(left + right, leftidx, rightidx);
    }

    public static void Climb_stairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }

    public static void Unique_paths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            return 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0)
                obstacleGrid[i][0] = 1;
            else {
                while (i < obstacleGrid.length) {
                    obstacleGrid[i++][0] = 0;
                }
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0)
                obstacleGrid[0][i] = 1;
            else {
                while (i < obstacleGrid[0].length) {
                    obstacleGrid[0][i++] = 0;
                }
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static int Dungeon_Game(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j] - dungeon[i][j], dp[i][j + 1] - dungeon[i][j]);
                dp[i][j] = Math.max(dp[i][j], 1);
            }
        }
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }
        return dp[0][0];
    }

    public static int rod_cutting_re(int[] p, int n) {
        if (n == 0)
            return 0;
        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            q = Math.max(q, p[i] + rod_cutting_re(p, n - 1 - i));
        }
        return q;
    }

    public static int rod_cutting_mem(int[] p, int n) {
        int[] mem = new int[n];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = Integer.MIN_VALUE;
        }
        return rod_cutting_topdown(p, n, mem);
    }

    public static int rod_cutting_topdown(int[] p, int n, int[] mem) {
        if (n == 0)
            return 0;
        if (mem[n - 1] >= 0)
            return mem[n - 1];

        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            q = Math.max(q, p[i] + rod_cutting_topdown(p, n - 1 - i, mem));
        }
        return q;
    }

    public static int rod_cutting_downtop(int[] p, int n) {
        int[] dp = new int[p.length + 1];
        dp[1] = p[0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], p[i - j - 1] + dp[j]);
            }
        }
        return dp[n];
    }

    public static int permutation(StringBuffer orig, StringBuffer dest, int pos) {
        if (pos == dest.length()) {
            System.out.println(dest);
            return 1;
        }
        int ret = 0;
        for (int i = 0; i < orig.length(); i++) {
            dest.setCharAt(pos, orig.charAt(i));
            orig.deleteCharAt(i);
            ret += permutation(orig, dest, pos + 1);
            orig.insert(i, dest.charAt(pos));
        }
        return ret;
    }

    public static int Combination(StringBuffer orig, StringBuffer dest, int pos) {
        if (pos == dest.length()) {
            System.out.println(dest);
            return 1;
        }
        int ret = 0;
        while (orig.length() != 0) {
            dest.setCharAt(pos, orig.charAt(0));
            orig.deleteCharAt(0);
            ret += Combination(new StringBuffer(orig), dest, pos + 1);
        }
        return ret;
    }

    public static int coins(int[] option, ArrayList<Integer> solution, int total) {
        if (total == 0) {
            System.out.println(solution);
            return 1;
        }
        if (total < 0)
            return 0;
        int ret = 0;
        for (int i = 0; i < option.length; i++) {
            if (!solution.isEmpty() && solution.get(solution.size() - 1) > option[i])
                continue;
            solution.add(option[i]);
            ret += coins(option, new ArrayList<>(solution), total - option[i]);
            solution.remove(solution.size() - 1);
        }
        return ret;
    }
}

class Max_subarray {
    int sum;
    int low;
    int high;

    public Max_subarray(int sum, int low, int high) {
        this.sum = sum;
        this.low = low;
        this.high = high;
    }

    public String toString() {
        return sum + " " + low + "->" + high;
    }
}