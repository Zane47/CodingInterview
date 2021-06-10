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

/**为什么要分奇偶？
 * 递归和迭代解法有一个共同之处就是随着代码的运行n在不断减小。
 * 递归分情况讨论也是为了让n变小，因为n越小越好计算，随着递归的深入n会越来越小直到0为止。
 * 而偶数的情况n直接可以减少一半。
 * 分奇偶不是重点，怎么让n合理变小才是重点，
 */

public class Q16Power {

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, 10));
        System.out.println(new Solution().myPow(2.1, 3));

        System.out.println(new Solution().myPow(0.00001, 2147483647));
    }


    /**
     * 快速幂：迭代
     * 首先处理一下n为负数的情况，把x取一下倒数并且把n变为正数即可
     *
     * 接下来以n = 18为例解释一下迭代的过程
     * 18 的二进制数为 0b10010
     * x^18 = x^16 * x^2 = x^0b10000 * x^0b10
     *
     * 令循环体为 x *= x，n >>= 1
     * 循环1次, 可以得到x ^ 2
     * 循环2次, n为奇数，把这个x ^ 2 乘到结果中
     * 循环4次, 得到x^16
     * 循环5次, n为奇数，把x^16乘到结果中
     * 也就是n的二进制数中有几个1就会乘几次，且乘数在循环中一次一次倍增
     *
     * 因为Java会溢出的问题，用一个long类型的变量b来代替n
     */

    static class Solution {
        public double myPow(double x, int n) {
            double result = 1.0;



            return result;
        }
    }

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
     *
     *
     * 递归几次就有多大的复杂度，
     * 最多递归次数是n为负数且n为奇数的时候，
     * 比n为正数且为偶数的情况多递归2次，
     * 常数级别的复杂度忽略不计；
     *
     * 主要就看n为偶数的时候，
     * 这时最多递归次数为n的二进制位数，
     * 也就是logn(底数为2)。时空复杂度差不多是这个水平
     *
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     *
     */
    static class Solution3 {
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
