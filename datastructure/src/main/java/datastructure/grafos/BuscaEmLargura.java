package datastructure.grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuscaEmLargura {
    private List<List<Integer>> listaAdjacencia;
    private int vertices;

    public BuscaEmLargura(int vertices) {
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

    // Implementação da Busca em Largura (BFS)
    public void buscaEmLargura(int inicio) {
        boolean[] visitado = new boolean[vertices]; // Para marcar os vértices visitados
        Queue<Integer> fila = new LinkedList<>(); // Fila para armazenar os vértices a serem explorados
        
        // Começa do nó inicial
        visitado[inicio] = true;
        fila.add(inicio);

        System.out.println("Busca em Largura (BFS) a partir do vértice " + inicio + ":");

        while (!fila.isEmpty()) {
            int verticeAtual = fila.poll();
            System.out.print(verticeAtual + " ");

            // Percorre os vizinhos do vértice atual
            for (int vizinho : listaAdjacencia.get(verticeAtual)) {
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila.add(vizinho);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
    	BuscaEmLargura grafo = new BuscaEmLargura(6);

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(1, 4);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(3, 5);
        grafo.adicionarAresta(4, 5);

        grafo.buscaEmLargura(0); // Inicia a BFS a partir do vértice 0
    }
}