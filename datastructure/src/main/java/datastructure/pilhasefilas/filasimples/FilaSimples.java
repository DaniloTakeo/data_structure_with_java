package datastructure.pilhasefilas.filasimples;

public class FilaSimples {
	private int[] elementos;
    private int frente, tras, capacidade, tamanho;

    public FilaSimples(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.frente = 0;
        this.tras = -1;
        this.tamanho = 0;
    }

    public void enqueue(int dado) {
        if (tamanho == capacidade) {
            System.out.println("Fila cheia!");
            return;
        }
        tras = (tras + 1) % capacidade;
        elementos[tras] = dado;
        tamanho++;
    }

    public int dequeue() {
        if (tamanho == 0) {
            System.out.println("Fila vazia!");
            return -1;
        }
        int removido = elementos[frente];
        frente = (frente + 1) % capacidade;
        tamanho--;
        return removido;
    }

    public int peek() {
        if (tamanho == 0) {
            System.out.println("Fila vazia!");
            return -1;
        }
        return elementos[frente];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void imprimirFila() {
        System.out.print("Fila: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[(frente + i) % capacidade] + " ");
        }
        System.out.println();
    }
}
