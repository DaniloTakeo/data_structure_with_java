package datastructure.grafos.arvore_geradora_minima;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    static class Aresta implements Comparable<Aresta> {
        int origem, destino, peso;

        Aresta(int origem, int destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }

        public int compareTo(Aresta outra) {
            return this.peso - outra.peso;
        }
    }

    static class Subconjunto {
        int pai, rank;
    }

    // Encontra o representante do subconjunto
    int find(Subconjunto[] subconjuntos, int i) {
        if (subconjuntos[i].pai != i)
            subconjuntos[i].pai = find(subconjuntos, subconjuntos[i].pai);
        return subconjuntos[i].pai;
    }

    // Une dois subconjuntos
    void union(Subconjunto[] subconjuntos, int x, int y) {
        int raizX = find(subconjuntos, x);
        int raizY = find(subconjuntos, y);

        if (subconjuntos[raizX].rank < subconjuntos[raizY].rank) {
            subconjuntos[raizX].pai = raizY;
        } else if (subconjuntos[raizX].rank > subconjuntos[raizY].rank) {
            subconjuntos[raizY].pai = raizX;
        } else {
            subconjuntos[raizY].pai = raizX;
            subconjuntos[raizX].rank++;
        }
    }

    public void kruskal(int V, List<Aresta> arestas) {
        Collections.sort(arestas); // Ordena por peso

        Subconjunto[] subconjuntos = new Subconjunto[V];
        for (int v = 0; v < V; v++) {
            subconjuntos[v] = new Subconjunto();
            subconjuntos[v].pai = v;
            subconjuntos[v].rank = 0;
        }

        List<Aresta> resultado = new ArrayList<>();
        int i = 0;

        while (resultado.size() < V - 1) {
            Aresta proxAresta = arestas.get(i++);

            int x = find(subconjuntos, proxAresta.origem);
            int y = find(subconjuntos, proxAresta.destino);

            if (x != y) {
                resultado.add(proxAresta);
                union(subconjuntos, x, y);
            }
        }

        int custoTotal = resultado.stream().mapToInt(a -> a.peso).sum();
        System.out.println("Custo total da MST (Kruskal): " + custoTotal);
        for (Aresta a : resultado) {
            System.out.println(a.origem + " - " + a.destino + " : " + a.peso);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<Aresta> arestas = new ArrayList<>();
        
        arestas.add(new Aresta(0, 1, 2));
        arestas.add(new Aresta(0, 3, 6));
        arestas.add(new Aresta(1, 2, 3));
        arestas.add(new Aresta(1, 3, 8));
        arestas.add(new Aresta(1, 4, 5));
        arestas.add(new Aresta(2, 4, 7));

        new Kruskal().kruskal(V, arestas);
    }
}