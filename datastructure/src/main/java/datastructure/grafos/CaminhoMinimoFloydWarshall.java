package datastructure.grafos;

public class CaminhoMinimoFloydWarshall {
    static final int INF = 1000000; // Um valor suficientemente grande para representar infinito

    void floydWarshall(int[][] grafo) {
        int V = grafo.length;
        int[][] dist = new int[V][V];

        // Inicializa matriz de distâncias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = grafo[i][j];
            }
        }

        // Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Exibir matriz final
        System.out.println("Matriz de menores distâncias entre todos os pares:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grafo = {
            {0,   3,   INF, 5},
            {2,   0,   INF, 4},
            {INF, 1,   0,   INF},
            {INF, INF, 2,   0}
        };

        new CaminhoMinimoFloydWarshall().floydWarshall(grafo);
    }
}