package CodingInterview;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */


public class Q07BuildTree {
    public static void main(String[] args) {
        int[] preOrder = new int[] {3, 9, 20, 15, 7};
        int[] inOrder = new int[] {9, 3, 15, 20, 7};
        Solution solution = new Solution();
        solution.buildTree(preOrder, inOrder);
    }

    /**
     * 前序遍历：根左右，前序遍历的第一个元素就是根节点
     * 中序遍历：左根右，中序遍历可以根据根节点分成左子树和右子树
     * e.g.:
     * preOrder: 1 2 4 7 3 5 6 8
     * inOrder: 4 7 2 1 5 3 8 6
     * 从preOrder中可以看出根节点是1，那么inorder中按照根节点坐在的位置可以知道左右子树的序列
     * inOrder: 左子树： 4 7 2； 根节点： 1； 右子树：5 3 8 6
     * 同样看左子树序列，也可以通过preOrder来计算该左子树的根节点是2，然后再计算左子树的左子树和右子树
     * 递归构建
     *
     * 1.preorder第一个元素就是root
     * 2.计算root在inorder中的index，划分左子树和右子树
     * 3.递归调用，左子树的preorder和右子树的preorder
     * 这里写一个数组切片函数即可，按照习惯，左闭右开
     *
     *
     */
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }

            int root = preorder[0];

            // 查找root在inorder序列中的位置
            int indexOfRootOfInorder = 0;
            for (; indexOfRootOfInorder < inorder.length; indexOfRootOfInorder++) {
                if (inorder[indexOfRootOfInorder] == root) {
                    break;
                }
            }

            TreeNode treeNode = new TreeNode(root);
            treeNode.left = buildTree(
                    slice(preorder, 1, indexOfRootOfInorder + 1),
                    slice(inorder, 0, indexOfRootOfInorder));
            treeNode.right = buildTree(
                    slice(preorder, indexOfRootOfInorder + 1, preorder.length),
                    slice(inorder, indexOfRootOfInorder + 1, inorder.length));

            return treeNode;
        }

        /**
         * 数组切片
         * 左闭右开
         *
         * @param array
         * @param left
         * @param right
         */
        private int[] slice(int[] array, int left, int right) {
            int[] result = Arrays.copyOfRange(array, left, right);;
            return result;
        }


    }

}




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int root = preorder[0];

        // // indexInInorder为中序遍历中根节点的位置
        int indexInInorder = 0;
        for (; indexInInorder < inorder.length; indexInInorder++) {
            if (root == inorder[indexInInorder]) {
                break;
            }
        }

        TreeNode treeNode = new TreeNode(root);
        // pre: 1   2 4 7   3 5 6 8
        // in: 4 7 2   1   5 3 8 6

        // slice 前闭后开
        treeNode.left =
                buildTree(slice(preorder, 1, indexInInorder + 1),
                        slice(inorder, 0, indexInInorder));

        treeNode.right =
                buildTree(slice(preorder, indexInInorder + 1, inorder.length),
                        slice(inorder, indexInInorder + 1, inorder.length));

        return treeNode;
    }


    private static int[] slice(int[] origin, int x, int y) {
        // 前闭后开
        int[] temp = new int[y-x];
        System.arraycopy(origin, x, temp, 0, y - x);
        return temp;
    }
}*/