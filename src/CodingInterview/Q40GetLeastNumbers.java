package CodingInterview;

// 40，最小的k个数

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 */
public class Q40GetLeastNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {3, 2, 1};
        solution.getLeastNumbers(nums, 2);
    }

    // 3. 快排变形，（平均）时间复杂度 O(n)
    // 有一个经典的 quick select（快速选择）算法。
    // 这个名字和 quick sort（快速排序）看起来很像，算法的思想也和快速排序类似，都是分治法的思想。
    // 快速排序的思路。快速排序中有一步很重要的操作是 partition（划分），从数组中随机选取一个枢纽元素 v，然后原地移动数组中的元素，使得比 v 小的元素在 v 的左边，比 v 大的元素在 v 的右边

    static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            else if (arr.length <= k) {
                return arr;
            }
            // 原地不断划分数组
            partitionArray(arr, 0, arr.length - 1, k);

            // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
        }

        private void partitionArray(int[] arr, int lo, int hi, int k) {
            // 做一次 partition 操作
            int m = partition(arr, lo, hi);
            // 此时数组前 m 个数，就是最小的 m 个数
            if (k == m) {
                // 正好找到最小的 k(m) 个数
                return;
            } else if (k < m) {
                // 最小的 k 个数一定在前 m 个数中，递归划分
                partitionArray(arr, lo, m-1, k);
            } else {
                // 在右侧数组中寻找最小的 k-m 个数
                partitionArray(arr, m+1, hi, k);
            }
        }

        // partition 函数和快速排序中相同，具体可参考快速排序相关的资料
        // 代码参考 Sedgewick 的《算法4》
        int partition(int[] a, int lo, int hi) {
            int i = lo;
            int j = hi + 1;
            int v = a[lo];
            while (true) {
                while (a[++i] < v) {
                    if (i == hi) {
                        break;
                    }
                }
                while (a[--j] > v) {
                    if (j == lo) {
                        break;
                    }
                }

                if (i >= j) {
                    break;
                }
                swap(a, i, j);
            }
            swap(a, lo, j);

            // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
            return j;
        }

        void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }




    // 2. 堆，这里求最小的数字，用大顶堆 O(nlogk)
    // 将数组中的元素依次入堆，当堆的大小超过 k 时，便将多出的元素从堆顶弹出
    // 因为是maxHeap，所以堆顶一顶是最大的，
    // 那么我们就遍历所有元素，当有比堆顶小的元素的时候，就入堆，
    // 新的堆顶就会是这些最小值中的最大的数字，
    // 遍历完成之后这个maxHeap中就会是那些最小值
    // 这样，把数组中的元素全部入堆之后，堆中剩下的 k 个元素就是最大的 k 个数了。

    // 由于使用了一个大小为 k 的堆，空间复杂度为 O(k)
    // 入堆和出堆操作的时间复杂度均为 O(logk)，每个元素都需要进行一次入堆操作，
    // 故算法的时间复杂度为 O(nlogk)。
    static class Solution2 {
        public int[] getLeastNumbers(int[] arr, int k) {
            // 大根堆
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int index : arr) {
                if (maxHeap.isEmpty() ||
                        maxHeap.size() < k ||
                        index < maxHeap.peek()) {
                    maxHeap.add(index);
                }
                // 超过容量k的时候，就删除
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }

            int[] result = new int[maxHeap.size()];
            int v1 = 0;
            for (int i : maxHeap) {
                result[v1++] = i;
            }
            return result;
        }
    }





    // 1. 排序，快排/自带Arrays.sort，然后取前k个最小的
    static class Solution1 {
        public int[] getLeastNumbers(int[] arr, int k) {
            int left = 0;
            int right = arr.length - 1;
            quickSort(arr, left, right);

            return null;
        }

        private void quickSort(int[] arr, int left, int right) {
        }
    }




}
