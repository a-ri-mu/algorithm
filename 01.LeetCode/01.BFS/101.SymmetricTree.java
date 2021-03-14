/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {

        boolean answer;
        //1. recursive
        answer = isSym(root.left, root.right);

        //2. iterative
        answer = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left); q.add(root.right);

        while(!q.isEmpty()){
            TreeNode left = q.poll(); TreeNode right = q.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            q.add(left.left); q.add(right.right);
            q.add(left.right); q.add(right.left);
        }

        return answer;
    }

    public boolean isSym(TreeNode left, TreeNode right){

        if(left == null || right == null) return left == right;
        if(left.val != right.val) return false;
        boolean a = isSym(left.left, right.right);
        boolean b = isSym(left.right, right.left);
        return a && b;
    }
}