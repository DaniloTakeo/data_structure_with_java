package datastructure.pilhasefilas.filasimples;

public class Main {
    public static void main(String[] args) {
        FilaSimples fila = new FilaSimples(5);
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        fila.imprimirFila();
        
        System.out.println("Frente da fila: " + fila.peek());
        fila.dequeue();
        fila.imprimirFila();
    }
}