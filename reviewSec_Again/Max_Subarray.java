package reviewSec_Again;

public class Max_Subarray {
    public static int Brutal(int[] a) {
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

    public static ret DC(int[] b, int left, int right) {
        if (left == right)
            return new ret(b[left], left, right);
        int mid = (left + right) >> 1;
        ret SubLeft = DC(b, left, mid);
        ret SubRight = DC(b, mid + 1, right);
        ret SubMid = crossing(b, left, mid, right);
        if (SubLeft.sum > SubRight.sum && SubLeft.sum > SubMid.sum)
            return SubLeft;
        else if (SubRight.sum > SubLeft.sum && SubRight.sum > SubMid.sum)
            return SubMid;
        return SubMid;
    }

    public static ret crossing(int[] b, int left, int mid, int right) {
        int leftsum = Integer.MIN_VALUE;
        int sum = 0;
        int leftidx = mid;
        for (int i = mid; i >= left; i--) {
            sum += b[i];
            if (sum > leftsum) {
                leftsum = sum;
                leftidx = i;
            }
        }
        int rightsum = Integer.MIN_VALUE;
        sum = 0;
        int rightidx = mid;
        for (int i = mid + 1; i <= right; i++) {
            sum += b[i];
            if (sum > rightsum) {
                rightsum = sum;
                rightidx = i;
            }
        }
        return new ret(rightsum + leftsum, leftidx, rightidx);
    }

    public static int DP(int[] a) {
        int min = a[0];
        int[] dp = new int[a.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], a[i] - min);
            min = Math.min(min, a[i]);
        }
        return dp[a.length - 1];
    }

}

class ret {
    int sum;
    int left;
    int right;

    public ret(int sum, int left, int right) {
        this.sum = sum;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return sum + " idx:" + left + "->" + right;
    }
}