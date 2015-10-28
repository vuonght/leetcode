// Given a binary search tree (BST), find the lowest common ancestor (LCA) of
// two given nodes in the BST.
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor
// is defined between two nodes v and w as the lowest node in T that has both v
// and w as descendants (where we allow a node to be a descendant of itself).”
//
//        _______6______
//       /              \
//    ___2__          ___8__
//   /      \        /      \
//   0      _4       7       9
//         /  \
//         3   5
//
// For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another
// example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of
// itself according to the LCA definition.

// Time: 28:28.45

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (p.val == q.val)
        {
            return p;
        }
        if ((root == null) ||
            (root.val == p.val || root.val == q.val) ||
            (root.val < p.val && root.val > q.val) ||
            (root.val > p.val && root.val < q.val))
        {
            return root;
        }
        if (p.val < root.val && q.val < root.val && root.left != null)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val && root.right != null)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}

/*

Determine the path to each node. Go through them, find all matches, and then
truncate.

4 = [6, 2, 4]
5 = [6, 2, 4, 5]
           ^

findPath(root, target, path)

!root?: []
root == target: path + [root]
root != target:
    root.left? or root.right?:
        root.left?:
            leftPath = findPath(root.left, target, path + [root])
        root.right?:
            rightPath = findPath(root.right, target, path + [root])
        leftPath if rightPath == [] else rightPath
    _: []
*/
