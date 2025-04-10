package datastructure.grafos.arvore_geradora_minima;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    static class Aresta {
        int destino, peso;

        Aresta(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    static class No implements Comparable<No> {
        int vertice, peso;

        No(int vertice, int peso) {
            this.vertice = vertice;
            this.peso = peso;
        }

        public int compareTo(No outro) {
            return this.peso - outro.peso;
        }
    }

    public void prim(List<List<Aresta>> grafo, int inicio) {
        int V = grafo.size();
        boolean[] visitado = new boolean[V];
        PriorityQueue<No> fila = new PriorityQueue<>();
        int custoTotal = 0;

        fila.add(new No(inicio, 0));

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            if (visitado[atual.vertice]) continue;

            visitado[atual.vertice] = true;
            custoTotal += atual.peso;

            for (Aresta vizinho : grafo.get(atual.vertice)) {
                if (!visitado[vizinho.destino]) {
                    fila.add(new No(vizinho.destino, vizinho.peso));
                }
            }
        }

        System.out.println("Custo total da Árvore Geradora Mínima (Prim): " + custoTotal);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Aresta>> grafo = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            grafo.add(new ArrayList<>());
        }

        // Adiciona as arestas (grafo não direcionado)
        grafo.get(0).add(new Aresta(1, 2));
        grafo.get(1).add(new Aresta(0, 2));

        grafo.get(0).add(new Aresta(3, 6));
        grafo.get(3).add(new Aresta(0, 6));

        grafo.get(1).add(new Aresta(2, 3));
        grafo.get(2).add(new Aresta(1, 3));

        grafo.get(1).add(new Aresta(3, 8));
        grafo.get(3).add(new Aresta(1, 8));

        grafo.get(1).add(new Aresta(4, 5));
        grafo.get(4).add(new Aresta(1, 5));

        grafo.get(2).add(new Aresta(4, 7));
        grafo.get(4).add(new Aresta(2, 7));

        new Prim().prim(grafo, 0);
    }
}