package algorithm.backtrace;


import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一颗二叉树，搜索值为7的目标节点，保存根节点到目标节点的路径，且排除值为3的元素
 * <p>
 * 关键点：回溯，剪枝
 *
 * @author: east
 * @date: 2023/12/25
 */
public class TreeTrace {
    /**
     * 使用前序遍历寻找树中为7的节点。
     *
     * @param root    root
     * @param path    当前路径
     * @param pathRes 路径结果
     */
    public void findTrace(TreeNode root, List<TreeNode> path, List<List<TreeNode>> pathRes) {
        // null：回溯； 9：剪枝
        if (root == null || root.value == 9) {
            return;
        }

        path.add(root);
        if (root.value == 7) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>(path);
            pathRes.add(treeNodes);
        }

        findTrace(root.left, path, pathRes);
        findTrace(root.right, path, pathRes);

        // 回退
        // 去掉当前路径
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree();
        TreeTrace treeTrace = new TreeTrace();
        List<TreeNode> path = new ArrayList<>();
        ArrayList<List<TreeNode>> pathRes = new ArrayList<>();
        treeTrace.findTrace(root, path, pathRes);
        System.out.println("split");
    }
}
