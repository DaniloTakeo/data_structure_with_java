package datastructure.listas;

class NoCircular {
    int dado;
    NoCircular proximo;

    public NoCircular(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

public class ListaCircular {
    private NoCircular ultimo;

    public void inserir(int dado) {
        NoCircular novoNo = new NoCircular(dado);
        if (ultimo == null) {
            ultimo = novoNo;
            ultimo.proximo = ultimo; // Aponta para si mesmo
        } else {
            novoNo.proximo = ultimo.proximo;
            ultimo.proximo = novoNo;
            ultimo = novoNo;
        }
    }

    public void imprimirLista() {
        if (ultimo == null) {
            System.out.println("Lista vazia");
            return;
        }
        NoCircular atual = ultimo.proximo;
        do {
            System.out.print(atual.dado + " -> ");
            atual = atual.proximo;
        } while (atual != ultimo.proximo);
        System.out.println("(volta ao início)");
    }
    
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.imprimirLista();
    }
}

