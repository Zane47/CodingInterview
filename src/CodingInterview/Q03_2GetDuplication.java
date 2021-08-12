package CodingInterview;

/**
 * 不修改数组找出重复的数字
 *
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7},那么对应的输出是重复的数字2或者3。
 *
 * 略过使用容器和排序的方法
 */


public class Q03_2GetDuplication {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(solution.getDuplication(nums, nums.length));
    }


    /**
     * 避免使用多余的空间，时间换空间
     * 数字范围1-n，数组大小n+1，所以至少有一个数字重复出现
     * 1 ~ m, m+1 ~ n
     * 如果1 ~ m的数字数量大于m，则一定有重复
     * 否则m+1 ~ n中一定有重复
     * 继续分割，一直到找到重复数字
     * 类比二分查找，只是多了统计数量
     *
     * 但是有一个问题，可能会找不全的问题。当然这里题目只需要返回任意一个重复的数字
     * e.g.:[2, 3, 5, 4, 3, 2, 6, 7]，8个数字在1~7的范围内，
     * 1~4这4个数字在数组中出现了5次，5~7这三个数字在数组中出现了3次，关注1~4
     * 1~4分成1~2和3~4，
     * 其中1~2这两个数字在数组中出现了2次（实际上是有重复的，但是这个方法查不出来）
     * 3~4这两个数字出现了3次，再分别统计数字3和数字4在数组中出现的数量，返回重复的数字即可
     */
    static class Solution {
        public int getDuplication(int[] nums, int length) {
            // 数字的范围1~length-1
            // left和right是数字不是位置
            int left = 1;
            int right = length - 1;

            while (left <= right) {
                int mid = (right - left) / 2 + left;
                // 数组中在数字left到right范围内的数字数量
                int count = countNumber(nums, length, left, mid);
                if (left == right) {
                    // count大于一表示left这个数在数组中重复(不止一个)
                    if (count > 1) {
                        return left;
                    }
                    else {
                        break;
                    }
                }
                if (count > (mid - left) + 1) {
                    //当count大于n的中间数时,说明在1到n/2中间有重复数，将right=mid
                    right = mid;
                } else {
                    //当count小于n的中间数时，说明在(n/2) + 1到n中间有重复数
                    left = mid + 1;
                }
            }
            return 0;
        }

        /**返回在left和right范围内的数字在数组中的数量
         *
         * @param nums
         * @param length
         * @param left
         * @param mid
         * @return
         */
        public int countNumber(int[] nums, int length, int left, int mid) {
            int count = 0;
            for(int i = 0; i < length; i++) {
                if(nums[i] >= left && nums[i] <= mid) {
                    count++;
                }
            }
            return count;
        }

    }


    /**
     * 不能修改本身的数组，那么就创建一个新的n+1数组
     * 和Q3的方法类似，取出来的数字i放在对应的第i位上
     * (i) 如果第i位上没有数字，就放上去
     * (ii)如果第i为上有数字，return重复
     */
    static class Solution1 {
        public int getDuplication(int[] nums) {
            int[] newNums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (0 != newNums[nums[i]]) {
                    return nums[i];
                }
                else {
                    newNums[nums[i]] = nums[i];
                }
            }
            return 0;
        }

    }




}
