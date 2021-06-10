package CodingInterview;

/**剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = 1/2^2 = 1/4 = 0.25
 *
 */


public class Q16Power {

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, 10));
        System.out.println(new Solution().myPow(2.1, 3));

        System.out.println(new Solution().myPow(0.00001, 2147483647));
    }


    /**
     * 快速幂：迭代
     */

    /**快速幂: 递归
     * 例：如果我们要计算一个数的32次方，我们已经计算了16次方，直接平方。以此类推，这样子32次方只需要5次乘法
     * 先平方，然后求4次方，然后求8次方，然后求16次方，然后求32次方
     * 如果n == 0, 返回1 （0^0 = 1）
     * 如果n < 0, 返回1 / x^(-n)，这里需要注意！！！
     * 如果n为偶数, x^n = (x^2)^(n/2) = (x * x)^(n/2)
     * 如果n为奇数, x^n = x * (x^n-1)
     *
     *
     * 注意！！：
     *
     * Java中因为n的最小值可以取到Integer.MIN_VALUE，
     * 如果直接取它的相反数的话还是它自己，会导致堆栈溢出，因此提一个x出来，具体看代码
     *
     */
    static class Solution {
        public double myPow(double x, int n) {

            if (n == 0) {
                return 1.0;
            }
            else if (n < 0) {
                // stackOverflow: 1.000000, -2147483648
                // return 1 / myPow(x, -n);
                // -n = 2147483648，超过了int的上限
                // int : -2147483648 ~ 2147483647
                return 1 / (x * myPow(x, - n - 1));
            }
            // 位运算快于取模
            else if (n % 2 == 1) {
                // 奇数: x^n = x * (x^n-1)
                return x * myPow(x, n - 1);
            }
            else {
                // 偶数: x^n = (x^2)^(n/2)
                return myPow(x * x, n >> 1);
            }
        }
    }


    /**
     * i) n为负数的时候，先求n的绝对值，然后求x^n，最后取倒数
     * ii) 0^0这个特殊值的处理
     * 超时
     */
    static class Solution2 {
        public double myPow(double x, int n) {
            double result = 1.0;
            int absN = Math.abs(n);
            for (int i = 1; i <= absN; i++) {
                result *= x;
            }

            if (n == 0 && (Math.abs(x - 0.0) < 1e-6)) {
                return 1;
            }

            return n > 0 ? result : (1 / result);
        }
    }


    /**错误的解答，没有考虑情况，以为是x,n简单的正整数
     * 如果n为负数？
     */
    static class WrongSolution {
        public double myPow(double x, int n) {
            double result = 1.0;

            for (int i = 1; i <= n; i++) {
                result *= x;
            }
            return result;
        }
    }
}
