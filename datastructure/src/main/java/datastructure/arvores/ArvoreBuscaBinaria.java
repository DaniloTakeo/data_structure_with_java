package datastructure.arvores;

class No {
    int valor;
    No esquerda, direita;

    public No(int item) {
        this.valor = item;
        this.esquerda = this.direita = null;
    }
}

public class ArvoreBuscaBinaria {
    private No raiz;

    public ArvoreBuscaBinaria() {
        this.raiz = null;
    }

    // Inserção na BST
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRec(raiz.direita, valor);
        }

        return raiz;
    }

    // Busca na BST
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No raiz, int valor) {
        if (raiz == null) {
            return false;
        }
        if (raiz.valor == valor) {
            return true;
        }
        return valor < raiz.valor ? buscarRec(raiz.esquerda, valor) : buscarRec(raiz.direita, valor);
    }

    // Remover um nó da BST
    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private No removerRec(No raiz, int valor) {
        if (raiz == null) {
            return null;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = removerRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = removerRec(raiz.direita, valor);
        } else {
            // Caso 1: Nó sem filhos
            if (raiz.esquerda == null && raiz.direita == null) {
                return null;
            }
            // Caso 2: Apenas um filho
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }
            // Caso 3: Dois filhos (pegar o menor valor da subárvore direita)
            raiz.valor = valorMinimo(raiz.direita);
            raiz.direita = removerRec(raiz.direita, raiz.valor);
        }

        return raiz;
    }

    private int valorMinimo(No raiz) {
        int minValor = raiz.valor;
        while (raiz.esquerda != null) {
            minValor = raiz.esquerda.valor;
            raiz = raiz.esquerda;
        }
        return minValor;
    }

    // Percurso em ordem (Esquerda, Raiz, Direita)
    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(No raiz) {
        if (raiz != null) {
            emOrdemRec(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdemRec(raiz.direita);
        }
    }

    // Percurso pré-ordem (Raiz, Esquerda, Direita)
    public void preOrdem() {
        preOrdemRec(raiz);
        System.out.println();
    }

    private void preOrdemRec(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdemRec(raiz.esquerda);
            preOrdemRec(raiz.direita);
        }
    }

    // Percurso pós-ordem (Esquerda, Direita, Raiz)
    public void posOrdem() {
        posOrdemRec(raiz);
        System.out.println();
    }

    private void posOrdemRec(No raiz) {
        if (raiz != null) {
            posOrdemRec(raiz.esquerda);
            posOrdemRec(raiz.direita);
            System.out.print(raiz.valor + " ");
        }
    }

    public static void main(String[] args) {
    	ArvoreBuscaBinaria bst = new ArvoreBuscaBinaria();

        // Inserindo elementos
        bst.inserir(50);
        bst.inserir(30);
        bst.inserir(70);
        bst.inserir(20);
        bst.inserir(40);
        bst.inserir(60);
        bst.inserir(80);

        System.out.println("Árvore em ordem:");
        bst.emOrdem(); // 20 30 40 50 60 70 80

        System.out.println("Árvore em pré-ordem:");
        bst.preOrdem(); // 50 30 20 40 70 60 80

        System.out.println("Árvore em pós-ordem:");
        bst.posOrdem(); // 20 40 30 60 80 70 50

        // Testando busca
        System.out.println("Busca pelo valor 40: " + bst.buscar(40)); // true
        System.out.println("Busca pelo valor 90: " + bst.buscar(90)); // false

        // Removendo um nó
        bst.remover(50);
        System.out.println("Árvore após remover 50:");
        bst.emOrdem(); // 20 30 40 60 70 80
    }
}
