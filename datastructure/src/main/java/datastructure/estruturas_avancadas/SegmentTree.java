package datastructure.estruturas_avancadas;

public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        this.n = arr.length;
        int size = 4 * n; // Tamanho máximo seguro para a árvore
        tree = new int[size];
        build(arr, 0, 0, n - 1);
    }

    private void build(int[] arr, int node, int left, int right) {
        if (left == right) {
            tree[node] = arr[left];
        } else {
            int mid = (left + right) / 2;
            build(arr, 2 * node + 1, left, mid);
            build(arr, 2 * node + 2, mid + 1, right);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private int query(int node, int left, int right, int l, int r) {
        if (r < left || right < l) {
            return 0; // fora do intervalo
        }
        if (l <= left && right <= r) {
            return tree[node]; // intervalo completamente dentro
        }

        int mid = (left + right) / 2;
        int leftSum = query(2 * node + 1, left, mid, l, r);
        int rightSum = query(2 * node + 2, mid + 1, right, l, r);
        return leftSum + rightSum;
    }

    public void update(int index, int newValue) {
        update(0, 0, n - 1, index, newValue);
    }

    private void update(int node, int left, int right, int index, int newValue) {
        if (left == right) {
            tree[node] = newValue;
        } else {
            int mid = (left + right) / 2;
            if (index <= mid) {
                update(2 * node + 1, left, mid, index, newValue);
            } else {
                update(2 * node + 2, mid + 1, right, index, newValue);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public void printTree() {
        System.out.print("Segment Tree (resumo): ");
        for (int i = 0; i < 2 * n; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 8, 9};
        SegmentTree st = new SegmentTree(arr);

        st.printTree();
        System.out.println("Soma [0, 2]: " + st.query(0, 2));
        System.out.println("Soma [2, 5]: " + st.query(2, 5));

        st.update(3, 10); // arr[3] = 10
        System.out.println("Soma [2, 5] após update: " + st.query(2, 5));
    }
}