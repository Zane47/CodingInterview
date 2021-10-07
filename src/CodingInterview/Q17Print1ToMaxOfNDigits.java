package CodingInterview;

import java.util.Arrays;

/**剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 *
 */

public class Q17Print1ToMaxOfNDigits {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().printNumbers(3)));

    }

    /**全排列
     * 其实可以看到有n位，每一位的数字都是0-9
     * n位所有十进制就是n个从0到9的全排列
     * 但是要注意排在第一位的0不显示
     *
     * 1.为了避免数字开头出现0，先把首位first固定，first取值范围为1~9
     *
     * 2.用digit表示要生成的数字的位数，本题要从1位数一直生成到n位数，
     * 对每种数字的位数都生成一下首位，所以有个双重for循环
     *
     * 3.生成首位之后进入递归生成剩下的digit - 1位数，从0~9中取值
     *
     * 4.递归的中止条件为已经生成了digit位的数字，即index == digit，将此时的数num转为int加到结果res中
     *
     *
     */
    static class Solution {
        int[] result;
        int count = 0;

        public int[] printNumbers(int n) {
            // 从1开始
            result = new int[(int)Math.pow(10, n) - 1];

            for (int digit = 1; digit <= n; digit++) {
                for (char firstDigit = '1'; firstDigit <= '9'; firstDigit++) {

                    char[] nums = new char[digit];
                    nums[0] = firstDigit;
                    dfs(1, nums, digit);
                }
            }

            return result;
        }

        /**
         *
         * @param index
         * @param nums
         * @param digit
         */
        private void dfs(int index, char[] nums, int digit) {
            // 递归的中止条件为已经生成了digit位的数字，
            // 即index == digit，将此时的数num转为int加到结果res中
            if (index == digit) {
                // char转int
                result[count] = Integer.parseInt(String.valueOf(nums));
                count++;
                return;
            }

            for (char i = '0'; i <= '9'; i++) {
                nums[index] = i;
                dfs(index + 1, nums, digit);
            }

        }
    }



    /**
     * 1 - 10^n - 1
     * int: -2147483648 - 2147483647
     * n = 10, 超过INT_MAX就会越界，
     * 转成字符串处理，字符模拟数字加法
     *
     * ASCII: 0~9: [48, 57]
     *
     * 虽然这道题目最后返回的是int[]，每一位都是int，不会有越界问题，
     * 但是实际的过程中一定要考虑到大数为题，这是考点
     */
    static class Solution1 {
        int[] output;


        public int[] printNumbers(int n) {
            char[] v1 = new char[n];

            /*while () {

            }*/

            return null;
        }
    }



}
