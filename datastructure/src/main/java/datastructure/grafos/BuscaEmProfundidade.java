package datastructure.grafos;

import java.util.ArrayList;
import java.util.List;

public class BuscaEmProfundidade {
    private List<List<Integer>> listaAdjacencia;
    private int vertices;

    public BuscaEmProfundidade(int vertices) {
        this.vertices = vertices;
        listaAdjacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            listaAdjacencia.add(new ArrayList<Integer>());
        }
    }

    // Adiciona uma aresta (grafo não-direcionado)
    public void adicionarAresta(int u, int v) {
        listaAdjacencia.get(u).add(v);
        listaAdjacencia.get(v).add(u);
    }

    // DFS Recursiva
    public void buscaEmProfundidade(int inicio) {
        boolean[] visitado = new boolean[vertices];
        System.out.println("Busca em Profundidade (DFS) a partir do vértice " + inicio + ":");
        dfsRecursiva(inicio, visitado);
        System.out.println();
    }

    private void dfsRecursiva(int vertice, boolean[] visitado) {
        visitado[vertice] = true;
        System.out.print(vertice + " ");

        for (int vizinho : listaAdjacencia.get(vertice)) {
            if (!visitado[vizinho]) {
                dfsRecursiva(vizinho, visitado);
            }
        }
    }

    public static void main(String[] args) {
    	BuscaEmProfundidade grafo = new BuscaEmProfundidade(6);

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(1, 4);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(3, 5);
        grafo.adicionarAresta(4, 5);

        grafo.buscaEmProfundidade(0); // Inicia a DFS a partir do vértice 0
    }
}