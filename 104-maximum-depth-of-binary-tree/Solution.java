// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node.

// Time: 03:10.20

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public int maxDepth(TreeNode root)
    {
        return (root == null)
             ? 0
             : Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}
