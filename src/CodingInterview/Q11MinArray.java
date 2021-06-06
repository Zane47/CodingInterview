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
        System.out.println(new Solution().minArray(new int[] {3, 4, 5, 1, 2}));
    }

    /**如何利用“旋转数组”的特性：
     * “最开始的若干元素”放到末尾，本身又是“递增排序的数组”
     * 说明：如果后一个元素比前一个元素小，那就是最小的元素
     * 数组根据这个分界点，分成了前后两个递增数组
     * O(logn)
     *
     * 用left和mid的值进行比较是否可以？
     * 举例：[3, 4, 5, 1, 2] 与 [1, 2, 3, 4, 5] ，
     * 此时，中间位置的值都比左边大，但最小值一个在后面，一个在前面，
     * 因此这种做法不能有效地减治。
     *
     * 用right和mi 的值进行比较是否可以？
     * 举例：[1, 2, 3, 4, 5]、[3, 4, 5, 1, 2]、[2, 3, 4, 5 ,1]，
     * 用右边位置和中间位置的元素比较，可以进一步缩小搜索的范围。
     *
     * 遇到 nums[mid] == nums[right] 的时候，
     * 不能草率地下定结论最小数字在哪一边，但是可以确定的是，把 right 舍弃掉，并不影响结果。
     *
     *
     * 重要！！！
     * 为什么一个是right = mid，一个left = mid + 1？
     * mid处的值大于high的，它肯定不是最小值，所以可以放心大胆地mid+1；
     * mid处的值小于high的，它有可能就是最小值，不能轻易地把它给排除，需要继续观察。
     *
     */
    static class Solution {
        public int minArray(int[] numbers) {
            if (numbers.length == 0) {
                return 0;
            }
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (numbers[right] == numbers[mid]) {
                    // 更新为[left, right - 1]
                    // 由于重复元素的存在，无论[right]是不是元素，都有替代[mid]
                    right--;
                } else if (numbers[mid] < numbers[right]) {
                    // mid的右边一定不是最小数字，更新为[left, mid]
                    // numbers[mid]是最小值右侧的元素，
                    // 因此我们可以忽略二分查找区间的右半部分。
                    right = mid;
                } else {
                    // numbers[mid] > numbers[right]
                    // mid以及mid的左边一定不是最小数字，更新为[mid+1, right]
                    // 这说明numbers[mid]是最小值左侧的元素，
                    // 因此我们可以忽略二分查找区间的左半部分。
                    left = mid + 1;
                }
            }

            return numbers[left];
        }
    }

    /**
     * O(n)全遍历
     */
    static class Solution1 {
        public int minArray(int[] numbers) {
            int min = numbers[0];
            for (int i = 0; i < numbers.length; i++) {
                if (min > numbers[i]) {
                    min = numbers[i];
                }
            }

            return min;


        }
    }


}
