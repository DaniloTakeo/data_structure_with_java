package datastructure.grafos;

import java.util.ArrayList;
import java.util.List;

public class ListaAdjacencia {
    private List<List<Integer>> lista;
    private int vertices;

    public ListaAdjacencia(int vertices) {
        this.vertices = vertices;
        lista = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            lista.add(new ArrayList<Integer>()); // Inicializa listas vazias para cada vértice
        }
    }

    //Adiciona uma aresta (grafo não-direcionado)
    public void adicionarAresta(int u, int v) {
        lista.get(u).add(v);
        lista.get(v).add(u); // Para grafos direcionados, remova essa linha
    }

    //Exibir a Lista de Adjacência
    public void mostrarLista() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int vizinho : lista.get(i)) {
                System.out.print(vizinho + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListaAdjacencia grafo = new ListaAdjacencia(5);
        
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 4);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(1, 4);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);

        System.out.println("Lista de Adjacência:");
        grafo.mostrarLista();
    }
}