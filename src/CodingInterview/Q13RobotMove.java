package CodingInterview;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */

public class Q13RobotMove {

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2, 3, 1));
    }

    /**https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/ji-qi-ren-de-yun-dong-fan-wei-by-leetcode-solution/
     * 一点优化，剪枝，只有向右向下
     * 我们将行坐标和列坐标数位之和大于 k 的格子看作障碍物，那么这道题就是一道很传统的搜索题目，
     * 隐藏的优化：我们在搜索的过程中搜索方向可以缩减为向右和向下，而不必再向上和向左进行搜索。
     * 如下图，我们展示了 16 * 16 的地图随着限制条件 k 的放大，可行方格的变化趋势，
     * 每个格子里的值为行坐标和列坐标的数位之和，蓝色方格代表非障碍方格，
     * 即其值小于等于当前的限制条件 k。
     * 我们可以发现随着限制条件 k 的增大，
     * (0, 0) 所在的蓝色方格区域内新加入的非障碍方格都可以由上方或左方的格子移动一步得到。
     * 而其他不连通的蓝色方格区域会随着 k 的增大而连通，
     * 且连通的时候也是由上方或左方的格子移动一步得到，
     * 因此我们可以将我们的搜索方向缩减为向右或向下。
     *
     */
    static class Solution {
        public int movingCount(int m, int n, int k) {

            return 0;
        }


        /**
         * 数字的数位之和
         * @param number
         * @return
         */
        private int getDigitSum(int number) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum;
        }


    }



    /**
     * dfs
     */
    static class Solution1 {
        int result = 0;
        public int movingCount(int m, int n, int k) {
            boolean visited[][] = new boolean[m][n];
            dfs(visited, 0, 0, m, n, k);
            return result;
        }

        /**dfs
         *
         * @param visited
         * @param x
         * @param y
         * @param m
         * @param n
         * @param k
         */
        private void dfs(boolean[][] visited, int x, int y, int m, int n, int k) {
            if (x < 0 || x > m - 1 || y < 0 || y > n - 1 ||
                    getDigitSum(x) + getDigitSum(y) > k) {
                return;
            }
            if (!visited[x][y]) {
                result++;
                visited[x][y] = true;
                dfs(visited, x - 1, y, m, n ,k);
                dfs(visited, x + 1, y, m, n, k);
                dfs(visited, x, y - 1, m, n, k);
                dfs(visited, x, y + 1, m, n, k);
            }
        }

        /**
         * 数字的数位之和
         * @param number
         * @return
         */
        private int getDigitSum(int number) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum;
        }

    }


}
