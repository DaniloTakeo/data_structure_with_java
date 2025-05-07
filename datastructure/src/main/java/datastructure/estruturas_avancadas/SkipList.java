package datastructure.estruturas_avancadas;

import java.util.Random;

class SkipListNode {
    int value;
    SkipListNode[] forward;

    public SkipListNode(int value, int level) {
        this.value = value;
        this.forward = new SkipListNode[level + 1];
    }
}

public class SkipList {
    private static final int MAX_LEVEL = 4;
    private final SkipListNode head = new SkipListNode(-1, MAX_LEVEL);
    private int level = 0;
    private final Random random = new Random();

    private int randomLevel() {
        int lvl = 0;
        while (random.nextBoolean() && lvl < MAX_LEVEL) {
            lvl++;
        }
        return lvl;
    }

    public void insert(int value) {
        SkipListNode current = head;
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];

        if (current == null || current.value != value) {
            int newLevel = randomLevel();
            if (newLevel > level) {
                for (int i = level + 1; i <= newLevel; i++) {
                    update[i] = head;
                }
                level = newLevel;
            }

            SkipListNode newNode = new SkipListNode(value, newLevel);
            for (int i = 0; i <= newLevel; i++) {
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }
    }

    public boolean search(int value) {
        SkipListNode current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
        }
        current = current.forward[0];
        return current != null && current.value == value;
    }

    public void display() {
        System.out.println("Skip List:");
        for (int i = level; i >= 0; i--) {
            SkipListNode node = head.forward[i];
            System.out.print("Level " + i + ": ");
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.forward[i];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.insert(3);
        list.insert(6);
        list.insert(7);
        list.insert(9);
        list.insert(12);
        list.insert(19);

        list.display();

        System.out.println("Busca por 7: " + list.search(7));
        System.out.println("Busca por 4: " + list.search(4));
    }
}