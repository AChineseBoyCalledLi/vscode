package reviewSec_Again;

public class Unique_Path {
    public static int PathI(int m, int n) {
        int[][] dp = new int[m][n];
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
        return dp[m - 1][n - 1];
    }

    public static int PathII(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                obstacleGrid[i][0] = 1;
            else {
                while (i < m) {
                    obstacleGrid[i++][0] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0)
                obstacleGrid[0][i] = 1;
            else {
                while (i < n) {
                    obstacleGrid[0][i++] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
