package CodingInterview;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2:
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 */

public class Q10_2NumWays {

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(7));
    }

    /**
     * 如果有一级台阶，就一种跳法
     * 如果有两级台阶，有两种跳法
     * 如果有三级台阶，有两种可能：从第二级台阶跳一格跳上来，或者从第一级台阶跳两格跳上来
     * f(3) = f(2) + (1)
     *
     * 类推下来f(n) = f(n-1) + f(n-2)
     * f(0) = 1
     * f(1) = 1
     * f(2) = 2
     */
    static class Solution {
        public int numWays(int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1 || n == 2) {
                return n;
            }
            int fN = 0;
            int fMinusOne = 2;
            int fMinusTwo = 1;

            for (int i = 3; i <= n; i++) {
                fN = (fMinusOne + fMinusTwo) % 1000000007;

                fMinusTwo = fMinusOne;
                fMinusOne = fN;

            }


            return fN;
        }
    }


}
