package algorithm.backtrace;

/**
 * 背包问题
 *
 * @author: east
 * @date: 2024/1/11
 */
public class Package {

    /**
     * 01背包问题
     * 给定 $n$ 个物品，第 $i$ 个物品的重量为 $wgt[i-1]$、价值为 $val[i-1]$ ，
     * * 和一个容量为 $cap$ 的背包。每个物品只能选择一次，问在限定背包容量下能放入物品的最大价值。
     * *
     * * 由最大，和穷举推断大概率可以用动态规划。由于每个物品只能选一次，且可选可不选，所以第i个物品最大价值为：
     * DP[i,w]代表考虑前i件物品，放入一个容量为w的背包可以获得的最大价值。
     * DP[i,w] = max(DP[i-1,w], DP[i-1,w-W[i]]+V[i]) :w<=cap, w-W[i]>=0
     * DP[i-1,w] :w<=cap, w-W[i]<0
     * DP[i-1,w] :w>cap  这种不会存在，w含义是占用的背包容量
     * <p>
     * REF：https://www.cnblogs.com/aiguona/p/7274222.html
     */
    public int package01(int n, int[] weight, int[] value, int cap) {
        int[][] dp = new int[n + 1][cap + 1];

        // 边界赋值: i为0时都是0, 或j为0时都是0


        for (int i = 1; i <= n; i++) {
            for (int j = cap; j > -1; j--) {
                // 0.因为j<cap所以 DP[i-1,w] :w>=cap情况不用判断
                // 1.判断是否可以添加第i个物品
                if (j - weight[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        return dp[n][cap];
    }

    /**
     * 完全背包问题：
     * 给定 $n$ 个物品，第 $i$ 个物品的重量为 $wgt[i-1]$、价值为 $val[i-1]$ ，
     * 和一个容量为 $cap$ 的背包。**每个物品可以重复选取**，问在限定背包容量下能放入物品的最大价值。
     */
    public void packageFull() {

    }


    public static void main(String[] args) {
        Package aPackage = new Package();
        int n = 4;
        int cap = 8;
        int[] weight = {0, 2, 3, 4, 5};
        int[] value = {0, 3, 4, 5, 6};

        int count = aPackage.package01(n, weight, value, cap);
        System.out.println("最大价值为：" + count);
    }

}
