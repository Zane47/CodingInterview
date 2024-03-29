package CodingInterview;

/**
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 */

public class Q15NumberOf1InBinary {


    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11110011));
    }

    static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int result = 0;






            return result;
        }
    }




    /** n&1
     * 考察知识点：二进制和位运算
     * 这里把数字当成无符号数，无符号右移
     *
     * n & 1 == 0, 最右一位是0
     * n & 1 == 1, 最右一位是1
     * n >>>= 1， 右移
     *
     */

    static class Solution1 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int result = 0;
            while (n != 0) {
                result += n & 1;
                n >>>= 1;

                /*if ((n & 1) == 0) {

                }
                else () {

                }*/


            }
            return result;
        }
    }


}
