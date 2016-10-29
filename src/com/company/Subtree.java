package com.company;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xuanwang on 10/21/16.
 */
public class Subtree {
    public static void main(String[] args){
        TreeNode root = deserialize("15,12,20,10,13,18,31");
        int ans = getSize(root, 10, 30);
        System.out.println("Hello World");
    }

    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("#,");
                continue;
            }
            res.append(node.val + ",");
            q.add(node.left);
            q.add(node.right);
        }

        String r = res.toString();
        return r.substring(0, r.length()-1);
    }

    public static int getSubTreeSize(TreeNode root, int min, int max){
        if(root == null) return 0;
        if(root.left == null && root.right == null && root.val <= max && root.val >= min) return 1;
        if(isValid(root, min, max))return countNodes(root);
        return Math.max(getSubTreeSize(root.left, min, max), getSubTreeSize(root.right, min, max));
    }

    private static boolean isValid(TreeNode root, int min, int max){
        if(root == null) return true;
        if(min > root.val) return false;
        if(max < root.val) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    private static int countNodes(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static int helper(int[] ans, TreeNode root, int min, int max){
        if(root == null) return 0;
        int left_num = helper(ans, root.left, min, max);
        int right_num = helper(ans, root.right, min,max);
        int res = 0;
        if(min <= root.val && root.val <= max){
            res = 1 + left_num + right_num;
        }

        ans[0] = Math.max(ans[0], res);
        return res;
    }

    public static int getSize(TreeNode tree, int min, int max){
        return getSizeHelper(tree, min, max).size;

    }

    public static Result getSizeHelper(TreeNode root, int min, int max){
        if(root == null) {
            return new Result(0, true);
        }
        /*if(root.left == null && root.right == null && min <= root.val &&root.val <= max){
            return new Result(1, true);
        }*/
        Result left = getSizeHelper(root.left, min, max);
        Result right = getSizeHelper(root.right, min, max);

        if(left.valid && right.valid && min <= root.val && root.val <= max ){
            return new Result(1 + left.size + right.size, true);
        }
        if(left.valid){
            return new Result(left.size, false);
        }
        if(right.valid){
            return new Result(right.size, false);
        }
        return new Result(Math.max(left.size, right.size), false);
    }

    static class Result{
        int size;
        boolean valid;
        public Result(int size, boolean valid){
            this.size = size;
            this.valid = valid;
        }
    }
}
