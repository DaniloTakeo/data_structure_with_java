package datastructure.grafos;

import java.util.Arrays;

public class MatrizAdjacencia {
    private int[][] matriz;
    private int vertices;

    public MatrizAdjacencia(int vertices) {
        this.vertices = vertices;
        matriz = new int[vertices][vertices]; // Inicialmente tudo é 0 (sem arestas)
    }

    //Adiciona uma aresta (grafo não-direcionado)
    public void adicionarAresta(int u, int v) {
        matriz[u][v] = 1;
        matriz[v][u] = 1; // Para grafos direcionados, remova essa linha
    }

    //Exibir a matriz
    public void mostrarMatriz() {
        for (int[] linha : matriz) {
            System.out.println(Arrays.toString(linha));
        }
    }

    public static void main(String[] args) {
        MatrizAdjacencia grafo = new MatrizAdjacencia(5);
        
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 4);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(1, 4);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);

        System.out.println("Matriz de Adjacência:");
        grafo.mostrarMatriz();
    }
}