package CodingInterview;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */

public class Q03FindRepeatNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {2, 3, 1, 0, 2, 5, 3};
        System.out.println(solution.findRepeatNumber(nums));
    }

    /**
     * 重点是这句：
     * “在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内”
     * 说明了如果数组中没有重复元素，那么数字i就会在第i个位置上！！！！
     * 因此，我们遍历数组，有以下几种情况：
     * (1) 第i位上的数字就是i(i == nums[i])，比较下一位
     * (2) 第i位上的数字就m (nums[i])，那么去找第m位数字，分两个情况：
     *     (i)  如果第i位上的数字和第m位上的数字相等，那么就return 重复的数字即可
     *     (ii) 如果不相等，那么就swap这两个位置上的数字(让数字m到他应该在的位置)，然后重复这次比较。
     * 空间复杂度：O(1)
     * 时间复杂度：
     */
    static class Solution {
        public int findRepeatNumber(int[] nums) {
            // 如果不重复并且有序，那么第i个位置上就是数字i，[0,n-1]
            // 所以这里我们做比较和交换
            // 第i个数，和这个数字m，如果相等，下一轮
            // 如果不相等，那么查看第i个数和第m个是否相等
            // 如果还不相等，那么就交换把第i个数交换到第m个位置上（因为数字就是m，理应在第m位上），然后下一轮
            for (int i = 0; i < nums.length; i++) {
                // 注意这里是while，一直等到i找到自己的位置
                while (i != nums[i]) {
                    // 不相等
                    if (nums[i] == nums[nums[i]]) {
                        return nums[i];
                    }
                    else {
                        swap(nums, i , nums[i]);
                    }
                }
            }
            // 未找到
            return -1;
        }
        private void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }



    /**
     * 将数组排序，然后如果前后位置有一样的数字，那么就说明了
     * 时间复杂度：对于一般的数组，排序要花nlogn的时间。
     */
    static class Solution2 {
        public int findRepeatNumber(int[] nums) {
            Arrays.sort(nums);

            // i 与 i+1比较，防止越界
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return nums[i];
                }
            }

            return 0;
        }
    }


    /**
     * 使用数据结构，HashSet,HashMap，遍历一遍数组
     * 每扫描到一个数字的时候就与容器中是否已经包含了该数字
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    static class Solution1 {
        public int findRepeatNumber(int[] nums) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int v1 : nums) {
                if (hashSet.contains(v1)) {
                    return v1;
                }
                else {
                    hashSet.add(v1);
                }
            }
            return 0;
        }


    }

}

