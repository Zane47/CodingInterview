package CodingInterview;


/**
 *写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,  F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 */


public class Q10Fib {

    public static void main(String[] args) {
        System.out.println(new Solution().fib(45));
    }

    /**
     * 从下往上计算
     * 从f(0), f(1)计算到f(n)
     *
     * f(n-1), f(n-2),f(n)
     * 将每次前两数之和存起来，便于下次直接使用
     * 变为单纯的数学加法
     */
    static class Solution {
        public int fib(int n) {
            if (n == 0 || n == 1) {
                return n;
            }

            int fibNMinusOne = 1;
            int fibNMinusTwo = 0;
            int fibN = 0;

            for (int i = 0; i <= n; i++) {
                fibN = (fibNMinusOne + fibNMinusTwo) % 1000000007;

                // 做更新，为下一次循环更新
                // f(2) = f(1) + f(0)
                // f(3) = f(2) + f(1)
                fibNMinusTwo = fibNMinusOne;
                fibNMinusOne = fibN;
            }

            return fibN;
        }
    }

    /**
     * 重复计算了很多节点
     * 将计算过的几点保存能下来，仅计算未计算过的节点
     *
     */
    static class Solution2 {
        int[] dp = new int[1000];
        public int fib(int n) {

            if (n == 0 || n == 1) {
                return n;
            }

            if (dp[n] != 0) {
                return dp[n];
            }

            dp[n] = (fib(n - 1) + fib(n - 2)) % 1000000007;

            return dp[n];
        }
    }


    /**
     * 递归写法，效率低
     */
    static class Solution1 {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return (fib(n - 1) + fib(n - 2)) % 1000000007;
        }
    }



}
