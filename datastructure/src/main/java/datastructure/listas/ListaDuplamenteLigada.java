package datastructure.listas;

class NoDuplo {
    int dado;
    NoDuplo anterior, proximo;

    public NoDuplo(int dado) {
        this.dado = dado;
        this.anterior = this.proximo = null;
    }
}

public class ListaDuplamenteLigada {
    private NoDuplo inicio;

    public void inserirNoFinal(int dado) {
        NoDuplo novoNo = new NoDuplo(dado);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            NoDuplo atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
            novoNo.anterior = atual;
        }
    }

    public void imprimirLista() {
        NoDuplo atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " <-> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
        lista.inserirNoFinal(1);
        lista.inserirNoFinal(2);
        lista.inserirNoFinal(3);
        lista.imprimirLista();
    }
}

