package reviewSec_Again;

public class BinarySearchTree<E> {
    TreeNode<E> root;

    public void insert(E value) {
        if (root == null) {
            root = new TreeNode<>(value);
            return;
        }
        TreeNode<E> par = root;
        int com = 0;
        TreeNode<E> node = root;
        while (node != null) {
            com = Method.compare((Comparable) node.key, (Comparable) value);
            par = node;
            if (com > 0) {
                node = node.left;
            } else if (com < 0) {
                node = node.right;
            } else {
                return;
            }
        }
        TreeNode<E> nNode = new TreeNode<>(value);
        if (com > 0) {
            par.left = nNode;
        } else {
            par.right = nNode;
        }
        nNode.par = par;
    }

    public TreeNode<E> Search(E value) {
        TreeNode<E> node = root;
        int com = 0;
        while (node != null && node.key != value) {
            com = Method.compare((Comparable) node.key, (Comparable) value);
            if (com > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public TreeNode<E> Search_Re(E value) {
        return Search_Re(root, value);
    }

    public TreeNode<E> Search_Re(TreeNode<E> node, E value) {
        if (node == null || Method.compare((Comparable) node.key, (Comparable) value) == 0)
            return node;
        int com = Method.compare((Comparable) node.key, (Comparable) value);
        if (com > 0)
            return Search_Re(node.left, value);
        else
            return Search_Re(node.right, value);
    }

    public String toString() {
        return root + "";
    }

    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(TreeNode<E> node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.right), getHeight(node.left));

    }

    public TreeNode<E> Maximum() {
        return Maximum(root);
    }

    public TreeNode<E> Maximum(TreeNode<E> node) {
        TreeNode<E> par = node;
        while (node != null) {
            par = node;
            node = node.right;
        }
        return par;
    }

    public TreeNode<E> Minimum() {
        return Minimum(root);
    }

    public TreeNode<E> Minimum(TreeNode<E> node) {
        TreeNode<E> par = node;
        while (node != null) {
            par = node;
            node = node.left;
        }
        return par;
    }

    public TreeNode<E> Successor(E value) {
        TreeNode<E> node = Search(value);
        if (node.right != null)
            return Minimum(node.right);
        TreeNode<E> par = node.par;
        while (par != null && par.left != node) {
            node = par;
            par = par.par;
        }
        return par;
    }

    public TreeNode<E> Predecessor(E value) {
        TreeNode<E> node = Search(value);
        if (node.left != null)
            return Maximum(node.left);
        TreeNode<E> par = node.par;
        while (par != null && par.right != node) {
            node = par;
            par = par.par;
        }
        return par;
    }
}

class TreeNode<E> {
    E key;
    TreeNode<E> left;
    TreeNode<E> right;
    TreeNode<E> par;

    public TreeNode(E key) {
        this.key = key;
    }

    public String toString() {
        return key + "{left=" + left + ", right=" + right + "}";
    }
}
