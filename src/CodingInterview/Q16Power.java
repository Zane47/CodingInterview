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
        System.out.println(new Solution().myPow(2.1, 3));
    }

    static class Solution {
        public double myPow(double x, int n) {

        }
    }


    /**
     *
     */
    static class WrongSolution {
        public double myPow(double x, int n) {
            double result = 0.0;

            for (int i = 0; i < n; i++) {
                result *= x;
            }
            return result;




            return result;
        }
    }
}
