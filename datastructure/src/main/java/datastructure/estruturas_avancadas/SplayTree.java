package datastructure.estruturas_avancadas;

class SplayTreeNode {
    int key;
    SplayTreeNode left, right;

    public SplayTreeNode(int key) {
        this.key = key;
    }
}

public class SplayTree {
    private SplayTreeNode root;

    private SplayTreeNode rightRotate(SplayTreeNode x) {
        SplayTreeNode y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    private SplayTreeNode leftRotate(SplayTreeNode x) {
        SplayTreeNode y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private SplayTreeNode splay(SplayTreeNode root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key) {
            if (root.left == null) return root;

            if (key < root.left.key) {
                // Zig-Zig (Left Left)
                root.left.left = splay(root.left.left, key);
                root = rightRotate(root);
            } else if (key > root.left.key) {
                // Zig-Zag (Left Right)
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null)
                    root.left = leftRotate(root.left);
            }

            return (root.left == null) ? root : rightRotate(root);

        } else {
            if (root.right == null) return root;

            if (key > root.right.key) {
                // Zag-Zag (Right Right)
                root.right.right = splay(root.right.right, key);
                root = leftRotate(root);
            } else if (key < root.right.key) {
                // Zag-Zig (Right Left)
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null)
                    root.right = rightRotate(root.right);
            }

            return (root.right == null) ? root : leftRotate(root);
        }
    }

    public void insert(int key) {
        if (root == null) {
            root = new SplayTreeNode(key);
            return;
        }

        root = splay(root, key);

        if (root.key == key) return;

        SplayTreeNode newNode = new SplayTreeNode(key);
        if (key < root.key) {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }
        root = newNode;
    }

    public boolean search(int key) {
        root = splay(root, key);
        return root != null && root.key == key;
    }

    public void inorderTraversal(SplayTreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.key + " ");
            inorderTraversal(node.right);
        }
    }

    public void display() {
        System.out.print("Inorder: ");
        inorderTraversal(root);
        System.out.println();
    }

    public static void main(String[] args) {
        SplayTree tree = new SplayTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        tree.display();  // Deve mostrar em ordem

        System.out.println("Busca 30: " + tree.search(30));  // Traz 30 para a raiz
        tree.display();  // Raiz agora é 30
    }
}