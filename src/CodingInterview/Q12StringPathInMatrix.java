package CodingInterview;


/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * A B C E
 * S F C S
 * A D E E
 *
 * 1 1 1 0
 * 0 0 1 0
 * 0 1 1 0
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
 * word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]],
 * word = "abcd"
 * 输出：false
 */

public class Q12StringPathInMatrix {

    public static void main(String[] args) {
        /*
        char[][] board = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        */

        char[][] board = new char[][] {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        String word = "AAB";

        System.out.println(new Solution().exist(board, word));
    }

    /**回溯
     * dfs
     * 例如ML中search状态，失败了则回溯
     * visited数组表示已经访问过的几点，或者直接着色成'\0'
     *
     * 重要！！！！！
     * 回溯法的回溯过程，还原现场
     */
    static class Solution {
        boolean result = false;
        int rows;
        int cols;

        public boolean exist(char[][] board, String word) {
            rows = board.length;
            cols = board[0].length;
            boolean[][] visited = new boolean[rows][cols];

            for (int i = 0 ; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        dfs(board, visited, i, j, 0, word);
                    }
                }
            }

            return result;
        }

        /**
         *
         * @param board
         * @param visited
         * @param i
         * @param j
         * @param temp
         * @param word
         */
        private void dfs(char[][] board, boolean[][] visited, int i, int j, int temp, String word) {
            if (result) {
                return;
            }
            else if (temp == word.length()) {
                result = true;
                return;
            }
            else if (i > -1 && i < rows && j > -1 && j < cols) {
                if (!visited[i][j] && board[i][j] == word.charAt(temp)) {
                    visited[i][j] = true;
                    dfs(board, visited, i, j + 1, temp + 1, word);
                    dfs(board, visited, i, j - 1, temp + 1, word);
                    dfs(board, visited, i - 1, j, temp + 1, word);
                    dfs(board, visited, i + 1, j, temp + 1, word);
                    // 重要！！
                    // 回溯法的回溯过程，还原现场
                    // 用来进行回溯的，如果当前的节点不满足路径要求，
                    // 需要撤回到上一个节点，然而上一个节点此时已经赋值为“/”，需要还原一下，继续探索
                    // 这里和岛屿问题不一样，岛屿问题的话，可以不用恢复，因为岛屿中我们不需要回溯
                    visited[i][j] = false;
                }



            }
            else {
                return;
            }



        }
    }
}
