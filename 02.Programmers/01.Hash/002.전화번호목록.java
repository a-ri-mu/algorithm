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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        //recursive
        int answer = findDepth(root, 1);
        return answer;
    }

    public int findDepth(TreeNode tree, int cnt){
        if(tree.left ==null && tree.right ==null) return cnt;
        ++cnt;
        if(tree.left == null) return findDepth(tree.right,cnt);
        if(tree.right == null) return findDepth(tree.left,cnt);
        return Math.min(findDepth(tree.left,cnt), findDepth(tree.right,cnt));
    }
}