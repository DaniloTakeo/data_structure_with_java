package datastructure.pilhasefilas.pilha;

public class Pilha {
    private int[] elementos;
    private int topo;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1;
    }

    public void push(int dado) {
        if (topo == capacidade - 1) {
            System.out.println("Pilha cheia!");
            return;
        }
        elementos[++topo] = dado;
    }

    public int pop() {
        if (topo == -1) {
            System.out.println("Pilha vazia!");
            return -1;
        }
        return elementos[topo--];
    }

    public int peek() {
        if (topo == -1) {
            System.out.println("Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public void imprimirPilha() {
        System.out.print("Pilha: ");
        for (int i = topo; i >= 0; i--) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}