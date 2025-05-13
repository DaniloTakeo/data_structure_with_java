package datastructure.estruturas_avancadas;

import java.util.Random;

class TreapNode {
    int key, priority;
    TreapNode left, right;

    TreapNode(int key) {
        this.key = key;
        this.priority = new Random().nextInt(100);
    }
}

public class Treap {
    private TreapNode root;

    private TreapNode rotateRight(TreapNode y) {
        TreapNode x = y.left;
        TreapNode T2 = x.right;

        x.right = y;
        y.left = T2;
        return x;
    }

    private TreapNode rotateLeft(TreapNode x) {
        TreapNode y = x.right;
        TreapNode T2 = y.left;

        y.left = x;
        x.right = T2;
        return y;
    }

    private TreapNode insert(TreapNode node, int key) {
        if (node == null) return new TreapNode(key);

        if (key < node.key) {
            node.left = insert(node.left, key);

            if (node.left.priority > node.priority)
                node = rotateRight(node);
        } else if (key > node.key) {
            node.right = insert(node.right, key);

            if (node.right.priority > node.priority)
                node = rotateLeft(node);
        }
        return node;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private void inorder(TreapNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println("Key: " + node.key + " | Priority: " + node.priority);
            inorder(node.right);
        }
    }

    public void display() {
        System.out.println("Treap (inorder):");
        inorder(root);
    }

    public static void main(String[] args) {
        Treap treap = new Treap();
        treap.insert(50);
        treap.insert(30);
        treap.insert(20);
        treap.insert(40);
        treap.insert(70);
        treap.insert(60);
        treap.insert(80);

        treap.display();
    }
}