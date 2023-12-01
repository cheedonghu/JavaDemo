package algorithm.tree;

import model.special.exception.BaseException;

/**
 * 重建树：
 *
 * @author: east
 * @date: 2023/12/1
 */
public class RebuildTree {

    /**
     * 根据前序（根左右）和中序（左根右）遍历结果重建树。 分治
     * |根|左|右|
     * i i+1 i+1+m-l   单个树的下标关系
     * |左|根|右|
     * l  m  r
     *
     * @param preorder 前序
     * @param inorder  中序
     */
    public void buildTree(int[] preorder, int[] inorder) {


    }

    /**
     * @param preorder
     * @param inorder
     * @param i        根节点在前序遍历数组中下标
     * @param m        根节点在中序遍历数组中下标
     * @param l
     * @param r
     * @return
     */
    public TreeNode dfs(int[] preorder, int[] inorder, int i, int m, int l, int r) {
        if (r - l < 2) {
            return new TreeNode(m);
        }

        // 初始化根节点
        TreeNode root = new TreeNode(preorder[i]);
        root.left = dfs(preorder, inorder, i + 1, getIndex(inorder, preorder[i]), l, m - 1);
        root.right = dfs(preorder, inorder, i + 1 + m - l, getIndex(inorder, ));
    }

    public static Integer getIndex(int[] array, Integer value) {
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        throw new BaseException();
    }
}
