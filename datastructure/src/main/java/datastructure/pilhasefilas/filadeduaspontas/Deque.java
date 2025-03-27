package datastructure.pilhasefilas.filadeduaspontas;

class Deque {
    private int[] elementos;
    private int frente, tras, tamanho, capacidade;

    public Deque(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.frente = 0;
        this.tras = capacidade - 1;
        this.tamanho = 0;
    }

    public void addFront(int dado) {
        if (tamanho == capacidade) {
            System.out.println("Deque cheio!");
            return;
        }
        if (frente == 0) {
            frente = capacidade - 1;
        } else {
            frente--;
        }
        elementos[frente] = dado;
        tamanho++;
    }

    public void addRear(int dado) {
        if (tamanho == capacidade) {
            System.out.println("Deque cheio!");
            return;
        }
        if (tras == capacidade - 1) {
            tras = -1;
        }
        tras++;
        elementos[tras] = dado;
        tamanho++;
    }

    public int removeFront() {
        if (tamanho == 0) {
            System.out.println("Deque vazio!");
            return -1;
        }
        int removido = elementos[frente];
        if (frente == capacidade - 1) {
            frente = 0;
        } else {
            frente++;
        }
        tamanho--;
        return removido;
    }

    public int removeRear() {
        if (tamanho == 0) {
            System.out.println("Deque vazio!");
            return -1;
        }
        int removido = elementos[tras];
        if (tras == 0) {
            tras = capacidade - 1;
        } else {
            tras--;
        }
        tamanho--;
        return removido;
    }

    public void imprimirDeque() {
        System.out.print("Deque: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[(frente + i) % capacidade] + " ");
        }
        System.out.println();
    }
}