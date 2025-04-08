package datastructure.grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArestaBF {
    int origem, destino, peso;

    ArestaBF(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
}

class CaminhoMinimoBellmanFord {
    int vertices;
    List<ArestaBF> arestas;

    CaminhoMinimoBellmanFord(int vertices) {
        this.vertices = vertices;
        this.arestas = new ArrayList<>();
    }

    void adicionarAresta(int origem, int destino, int peso) {
        arestas.add(new ArestaBF(origem, destino, peso));
    }

    void bellmanFord(int origem) {
        int[] distancia = new int[vertices];
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origem] = 0;

        // Passo 1: relaxar todas as arestas (V - 1) vezes
        for (int i = 1; i < vertices; i++) {
            for (ArestaBF aresta : arestas) {
                int u = aresta.origem;
                int v = aresta.destino;
                int peso = aresta.peso;

                if (distancia[u] != Integer.MAX_VALUE && distancia[u] + peso < distancia[v]) {
                    distancia[v] = distancia[u] + peso;
                }
            }
        }

        // Passo 2: verificar ciclos negativos
        for (ArestaBF aresta : arestas) {
            int u = aresta.origem;
            int v = aresta.destino;
            int peso = aresta.peso;

            if (distancia[u] != Integer.MAX_VALUE && distancia[u] + peso < distancia[v]) {
                System.out.println("Ciclo negativo detectado!");
                return;
            }
        }

        // Exibir resultado
        System.out.println("Distâncias mínimas a partir do vértice " + origem + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("→ Para " + i + ": " + (distancia[i] == Integer.MAX_VALUE ? "infinito" : distancia[i]));
        }
    }

    public static void main(String[] args) {
    	CaminhoMinimoBellmanFord grafo = new CaminhoMinimoBellmanFord(5);

        grafo.adicionarAresta(0, 1, -1);
        grafo.adicionarAresta(0, 2, 4);
        grafo.adicionarAresta(1, 2, 3);
        grafo.adicionarAresta(1, 3, 2);
        grafo.adicionarAresta(1, 4, 2);
        grafo.adicionarAresta(3, 2, 5);
        grafo.adicionarAresta(3, 1, 1);
        grafo.adicionarAresta(4, 3, -3);

        grafo.bellmanFord(0);
    }
}