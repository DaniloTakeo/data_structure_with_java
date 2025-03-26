package datastructure.listas;

class No {
    int dado;
    No proximo;

    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

public class ListaSimplesmenteLigada {
    private No inicio;

    public void inserirNoFinal(int dado) {
        No novoNo = new No(dado);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public void imprimirLista() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        ListaSimplesmenteLigada lista = new ListaSimplesmenteLigada();
        lista.inserirNoFinal(1);
        lista.inserirNoFinal(2);
        lista.inserirNoFinal(3);
        lista.imprimirLista();
    }
}