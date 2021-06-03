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
        String input = "We are happy";
        System.out.println(solution.replaceSpace(input));
    }


    /**
     *
     */
    static class Solution {
        public String replaceSpace(String s) {

            return null;
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
