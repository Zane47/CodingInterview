package CodingInterview;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 *
 */


public class Q05ReplaceSpace {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // String input = "We are happy";
        String input = "     ";
        System.out.println(solution.replaceSpace(input));
    }


    /**试用与可以直接修改String的做法
     * 这里我们String转array再转回去
     * 双指针
     * 先遍历一次字符串，统计字符串中空格的数量，从而计算出新字符串总长度
     * p1指向原始字符串的末尾，p2指向替换之后的字符串的末尾
     * p1先往前移动，把逐个字符复制到p2指向的位置，p2也向前移动，直到碰到空格，
     * 碰到空格后，p1向前移动一个，在p2之前插入"%20"，p2向前移动3格
     * 直到p1，p2会和
     * O(n)
     *
     * 在Java中，String是不可以被修改的，但是c中可以
     * 所以我们新建一个数组来做
     *
     */
    static class Solution {
        public String replaceSpace(String s) {
            char[] array = s.toCharArray();

            int numberOfBlank = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    numberOfBlank++;
                }
            }
            int newLength = numberOfBlank * (3 - 1) + s.length();

            char[] newArray = new char[newLength];
            for (int i = 0; i < s.length(); i++) {
                newArray[i] = array[i];
            }

            int p1 = s.length() - 1;
            int p2 = newLength - 1;
            while (p1 >= 0) {
                if (newArray[p1] != ' ') {
                    newArray[p2--] = newArray[p1];
                }
                else {
                    // 倒过来
                    newArray[p2--] = '0';
                    newArray[p2--] = '2';
                    newArray[p2--] = '%';
                }
                p1--;
            }


            return new String(newArray);
        }
    }

    /** replace(String, String)
     */
    static class Solution2 {
        public String replaceSpace(String s) {
            return s.replace(" ", "%20");
        }
    }



    /**
     * 空格替换成%20
     * 长度为1的空格，替换成长度为3的"%20"
     * 直接新建一个长度为三倍的新数组，遍历原来的inputString，然后替换
     * 数组转String的时候使用String(char value[], int offset, int count)的构造函数
     */
    static class Solution1 {
        public String replaceSpace(String s) {
            char[] resultArray = new char[s.length() * 3];
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                if (' ' == s.charAt(i)) {
                    resultArray[j] = '%';
                    resultArray[++j] = '2';
                    resultArray[++j] = '0';
                    j++;
                }
                else {
                    resultArray[j++] = s.charAt(i);
                }
            }
            return new String(resultArray, 0, j);
        }
    }


}
