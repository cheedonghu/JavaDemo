package algorithm.tree;

import algorithm.util.Util;

/**
 * 重建树： 设置根节点，设置左子树，设置右子树；递归(一次正确，次次正确！思维不用深入跟随递归！）；分治
 * https://www.hello-algo.com/chapter_divide_and_conquer/build_binary_tree_problem/#3
 *
 * @author: east
 * @date: 2023/12/1
 */
public class RebuildTree {

    /**
     * 根据前序（根左右）和中序（左根右）遍历结果重建树（默认前提：节点值不同）。 分治
     * |根|左|右|
     * i i+1 i+1+m-l   单个树的下标关系
     * |左|根|右|
     * l  m  r
     *
     * @param preorder 前序
     * @param inorder  中序
     */
    public void buildTree(int[] preorder, int[] inorder) {
//        TreeNode root = dfs(preorder, inorder, 0, Util.findIndex(inorder, preorder[0]), 0, inorder.length - 1);
        TreeNode root = dfs(preorder, inorder, 0, 0, inorder.length - 1);

        System.out.println("层序打印结果\n");
        root.printSimpleTree();
    }

    /**
     * @param preorder 前序遍历节点
     * @param inorder  中序遍历节点
     * @param i        根节点在前序遍历数组中下标
     * @param m        根节点在中序遍历数组中下标
     * @param l        左子树根在中序遍历数组中所在下标
     * @param r        右子树在中序遍历数组中所在下标
     * @return 当前根节点
     */
    public TreeNode dfs(int[] preorder, int[] inorder, int i, int m, int l, int r) {
//        // r 和 l 重合时就可以直接返回了
//        if (r - l <= 1) {
//            return new TreeNode(m);
//        }
        // 子树区间为空时终止
        if (r - l < 0) {
            return null;
        }

        // 初始化根节点
        TreeNode root = new TreeNode(preorder[i]);
        // 左子树 note：这里传入m时用到了i+1下标的元素，会导致数组越界。需要改为逻辑内获取而不是通过参数传入，因为当越界时l和m会提前阻断
        root.left = dfs(preorder, inorder, i + 1, Util.findIndex(inorder, preorder[i + 1]), l, m - 1);
        // 右子树
        root.right = dfs(preorder, inorder, i + 1 + m - l, Util.findIndex(inorder, preorder[i + 1 + m - l]), m + 1, r);
        return root;
    }

    /**
     * 深度遍历优化版，去掉参数 m：根节点在中序遍历数组中下标参数改为逻辑中计算
     * @param preorder  前序遍历节点
     * @param inorder   中序遍历节点
     * @param i        根节点在前序遍历数组中下标
     * @param l        左子树根在中序遍历数组中所在下标
     * @param r        右子树在中序遍历数组中所在下标
     * @return 当前根节点
     */
    public TreeNode dfs(int[] preorder, int[] inorder, int i, int l, int r) {
        // 子树区间为空时终止
        if (r - l < 0) {
            return null;
        }

        // 初始化根节点
        TreeNode root = new TreeNode(preorder[i]);

        // 获取根节点在中序遍历数组中的下标从而确定左子树，右子树长度
        int m = Util.findIndex(inorder, preorder[i]);

        // 左子树
        root.left = dfs(preorder, inorder, i + 1, l, m - 1);
        // 右子树
        root.right = dfs(preorder, inorder, i + 1 + m - l, m + 1, r);
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 2, 1, 7};
        int[] inorder = {9, 3, 1, 2, 7};

        RebuildTree rebuildTree = new RebuildTree();
        rebuildTree.buildTree(preorder, inorder);
    }
}
