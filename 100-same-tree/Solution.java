// Given two binary trees, write a function to check if they are equal or not.

// Two binary trees are considered equal if they are structurally identical and
// the nodes have the same value.

// Time: 09:18.07

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
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        // Nullity check. Two null nodes are identical.
        if (p == null && q == null)
        {
            return true;
        }

        // Null equality check. If only one node is null, they are not equal.
        if ((p == null && q != null) || (p != null && q == null))
        {
            return false;
        }

        // At this point, we've established that both nodes are non-null.
        // Compare their values, as well as their structural equality.
        // Note that short circuiting means that the value equality (which is
        // O(1)) happens and must hold true before structural equality (which
        // is O(lg(n)) is checked for.
        return (p.val == q.val
            && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)));
    }
}
