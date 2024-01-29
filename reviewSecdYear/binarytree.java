package reviewSecdYear;

public class binarytree {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(2);
        BST<Integer> bst = new BST<>(root);
        for (int i = 0; i < 8; i++) {
            bst.add(i - 3);
        }
        // System.out.println(bst.Search(3));
        // System.out.println(bst.Search_Ir(3));
        // System.out.println(bst.Minimum());
        // System.out.println(bst.MinRe());
        // System.out.println(bst.Search(1));
        // bst.postOrder();
        System.out.println(bst.Search(0));
        System.out.println(bst.height());
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
        return key + " from " + par;
    }
}

class BST<E> {
    TreeNode<E> root;

    public BST(TreeNode<E> root) {
        this.root = root;
    }

    // 在下面实现功能
    @SuppressWarnings("unchecked")
    public int compare(E e1, E e2) {
        return ((Comparable<E>) e1).compareTo(e2);
    }

    public void add(E value) {
        TreeNode<E> node = root;
        TreeNode<E> par = root;
        int com = 0;
        while (node != null) {
            par = node;
            com = compare(node.key, value);
            if (com > 0) {
                node = node.left;
            } else if (com < 0) {
                node = node.right;
            } else
                return;
        }
        TreeNode<E> newNode = new TreeNode<>(value);
        if (com > 0) {
            par.left = newNode;
        } else {
            par.right = newNode;
        }
        newNode.par = par;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<E> node) {
        if (node == null)
            return;
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode<E> node) {
        if (node == null)
            return;
        preOrder(node.left);
        System.out.println(node.key);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode<E> node) {
        if (node == null)
            return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.key);
    }

    public TreeNode<E> Search(E value) {
        return Search(root, value);
    }

    private TreeNode<E> Search(TreeNode<E> node, E value) {
        if (node == null || compare(node.key, value) == 0) {
            return node;
        }
        int com = compare(node.key, value);
        if (com < 0) {
            return Search(node.right, value);
        } else {
            return Search(node.left, value);
        }
    }

    public TreeNode<E> Search_Ir(E value) {
        TreeNode<E> node = root;
        while (node != null) {
            int com = compare(node.key, value);
            if (com < 0) {
                node = node.right;
            } else if (com > 0) {
                node = node.left;
            } else {
                break;
            }
        }
        return node;
    }

    public TreeNode<E> Minimum() {
        TreeNode<E> node = root;
        while (node.left != null)
            node = node.left;
        return node;
    }

    public TreeNode<E> Maximum() {
        TreeNode<E> node = root;
        while (node.right != null)
            node = node.right;
        return node;
    }

    public TreeNode<E> MaxRe() {
        return MaxRe(root);
    }

    private TreeNode<E> MaxRe(TreeNode<E> node) {
        if (node.right == null)
            return node;
        return MaxRe(node.right);
    }

    public TreeNode<E> MinRe() {
        return MinRe(root);
    }

    private TreeNode<E> MinRe(TreeNode<E> node) {
        if (node.left == null)
            return node;
        return MinRe(node.left);
    }

    public TreeNode<E> successor(E value) {
        TreeNode<E> node = Search(value);
        return successor(node);
    }

    public TreeNode<E> successor(TreeNode<E> node) {
        if (node.left != null) {
            // node = node.left;
            // while (node.right != null) {
            // node = node.right;
            // }
            // return node;
            return MaxRe(node.left);
        }
        TreeNode<E> par = node.par;
        while (par != null && par.right != node) {
            node = par;
            par = (par.par);
        }
        return par;
    }

    public TreeNode<E> predecessor(E value) {
        TreeNode<E> node = Search(value);
        return predecessor(node);
    }

    public TreeNode<E> predecessor(TreeNode<E> node) {
        if (node.right != null) {
            // node = node.right;
            // while (node.left != null) {
            // node = node.left;
            // }
            // return node;
            return MinRe(node.right);
        }
        TreeNode<E> par = node.par;
        while (par != null && par.left != node) {
            node = par;
            par = (par.par);
        }
        return par;
    }

    public int height() {
        return height(root);
    }

    public int height(TreeNode<E> node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.right), height(node.left));
    }
}