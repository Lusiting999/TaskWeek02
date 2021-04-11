package com.test.week02;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTraversal {

    /**
     * 二叉树三种遍历方式模板
     * @param root
     * @return
     */
     public List<Integer> traversal(TreeNode root) {
         List<Integer> res = new ArrayList<>();
         inorder(root, res);
         return res;
     }

     public void inorder(TreeNode root, List<Integer> res) {
         if (root == null) {
             return;
         }

         // 前序
         res.add(root.val);
         inorder(root.left, res);
         inorder(root.right, res);

         // 中序
         inorder(root.left, res);
         res.add(root.val);
         inorder(root.right, res);

         //后序
         inorder(root.left, res);
         inorder(root.right, res);
         res.add(root.val);
     }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
