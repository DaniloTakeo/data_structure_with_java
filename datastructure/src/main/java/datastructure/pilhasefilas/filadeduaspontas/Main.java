package datastructure.pilhasefilas.filadeduaspontas;

public class Main {
    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.addRear(10);
        deque.addRear(20);
        deque.addFront(30);
        deque.imprimirDeque();

        System.out.println("Removido do front: " + deque.removeFront());
        deque.imprimirDeque();

        System.out.println("Removido do rear: " + deque.removeRear());
        deque.imprimirDeque();
    }
}