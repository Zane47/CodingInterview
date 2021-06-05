package CodingInterview;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */

public class Q11MinArray {
    public static void main(String[] args) {

    }

    /**如何利用“旋转数组”的特性：
     * “最开始的若干元素”放到末尾，本身又是“递增排序的数组”
     * 说明：如果后一个元素比前一个元素小，那就是最小的元素
     * 数组根据这个分界点，分成了前后两个递增数组
     *
     */
    static class Solution {
        public int minArray(int[] numbers) {




            return 0;
        }
    }


}
