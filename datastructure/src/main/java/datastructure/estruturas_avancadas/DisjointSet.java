package datastructure.estruturas_avancadas;

public class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i; // cada elemento é seu próprio conjunto
            rank[i] = 0;   // altura inicial é 0
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return; // já estão no mesmo conjunto

        // union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public void printSets() {
        System.out.print("Representantes: ");
        for (int i = 0; i < parent.length; i++) {
            System.out.print(find(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(10);

        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);
        ds.union(4, 5);

        System.out.println("0 e 2 conectados? " + ds.connected(0, 2));
        System.out.println("2 e 3 conectados? " + ds.connected(2, 3));

        ds.union(2, 4);
        System.out.println("2 e 5 conectados? " + ds.connected(2, 5));

        ds.printSets();
    }
}