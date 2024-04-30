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
    List<Integer> nodes = new ArrayList<>();
    int maxLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root, 1);
        return nodes;
    }
    public void traverse (TreeNode root, int level) {
        if(root == null)
            return;
        if(level > maxLevel) {
            maxLevel = level;
            nodes.add(root.val);
        }
        traverse(root.right, level+1);
        traverse(root.left, level+1);
    }
}