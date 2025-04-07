package datastructure.grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Aresta {
    int destino;
    int peso;

    Aresta(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

public class CaminhoMinimoDjikstra {
    private int vertices;
    private List<List<Aresta>> listaAdj;

    CaminhoMinimoDjikstra(int vertices) {
        this.vertices = vertices;
        listaAdj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            listaAdj.add(new ArrayList<Aresta>());
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        listaAdj.get(origem).add(new Aresta(destino, peso));
        // Se for grafo não-direcionado, adicione também:
        // listaAdj.get(destino).add(new Aresta(origem, peso));
    }

    public void dijkstra(int origem) {
        int[] distancia = new int[vertices];
        boolean[] visitado = new boolean[vertices];

        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origem] = 0;

        PriorityQueue<int[]> fila = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        fila.add(new int[] { origem, 0 });

        while (!fila.isEmpty()) {
            int[] atual = fila.poll();
            int u = atual[0];

            if (visitado[u]) continue;
            visitado[u] = true;

            for (Aresta aresta : listaAdj.get(u)) {
                int v = aresta.destino;
                int peso = aresta.peso;

                if (!visitado[v] && distancia[u] + peso < distancia[v]) {
                    distancia[v] = distancia[u] + peso;
                    fila.add(new int[] { v, distancia[v] });
                }
            }
        }

        // Impressão do resultado
        System.out.println("Distâncias a partir do vértice " + origem + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("→ Para " + i + ": " + (distancia[i] == Integer.MAX_VALUE ? "infinito" : distancia[i]));
        }
    }

    public static void main(String[] args) {
    	CaminhoMinimoDjikstra grafo = new CaminhoMinimoDjikstra(6);

        grafo.adicionarAresta(0, 1, 4);
        grafo.adicionarAresta(0, 2, 2);
        grafo.adicionarAresta(1, 2, 5);
        grafo.adicionarAresta(1, 3, 10);
        grafo.adicionarAresta(2, 4, 3);
        grafo.adicionarAresta(4, 3, 4);
        grafo.adicionarAresta(3, 5, 11);

        grafo.dijkstra(0); // Caminhos a partir do vértice 0
    }
}