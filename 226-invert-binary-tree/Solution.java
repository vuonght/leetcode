// Invert a binary tree.
//
//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
//
// to
//
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1

// Time: 07:06.34

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
    public TreeNode invertTree(TreeNode root)
    {
        // Do nothing for a null node.
        if (root != null)
        {
            // Invert this node and its immediate children.
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            // Recursively invert this node's children.
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}

/*

(root == null):
- return null

(root != null):
- move root.left to root.right
- move root.right to root.left
- call invertTree(root.left)  // This is OK because TreeNode is pass by ref.
- call invertTree(root.right) // This is OK because TreeNode is pass by ref.

*/
