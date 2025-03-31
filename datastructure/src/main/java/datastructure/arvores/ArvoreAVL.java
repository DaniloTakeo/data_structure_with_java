package datastructure.arvores;

class NoAVL {
    int valor, altura;
    NoAVL esquerda, direita;

    public NoAVL(int valor) {
        this.valor = valor;
        this.altura = 1; // Altura inicial do nó
    }
}

public class ArvoreAVL {
    private NoAVL raiz;

    // Retorna a altura de um nó
    private int altura(NoAVL no) {
        return (no == null) ? 0 : no.altura;
    }

    // Calcula o fator de balanceamento
    private int fatorBalanceamento(NoAVL no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    // Rotação simples à direita (RR)
    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        // Realiza a rotação
        x.direita = y;
        y.esquerda = T2;

        // Atualiza alturas
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    // Rotação simples à esquerda (LL)
    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        // Realiza a rotação
        y.esquerda = x;
        x.direita = T2;

        // Atualiza alturas
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    // Inserção na AVL
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private NoAVL inserirRec(NoAVL no, int valor) {
        if (no == null) {
            return new NoAVL(valor);
        }

        // Inserção normal de BST
        if (valor < no.valor) {
            no.esquerda = inserirRec(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRec(no.direita, valor);
        } else {
            return no; // Não permite valores duplicados
        }

        // Atualiza altura do nó atual
        no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;

        // Obtém o fator de balanceamento
        int fb = fatorBalanceamento(no);

        // Caso LL (Rotação Direita)
        if (fb > 1 && valor < no.esquerda.valor) {
            return rotacaoDireita(no);
        }

        // Caso RR (Rotação Esquerda)
        if (fb < -1 && valor > no.direita.valor) {
            return rotacaoEsquerda(no);
        }

        // Caso LR (Rotação Esquerda-Direita)
        if (fb > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        // Caso RL (Rotação Direita-Esquerda)
        if (fb < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    // Percurso em ordem (Esquerda, Raiz, Direita)
    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(NoAVL no) {
        if (no != null) {
            emOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdemRec(no.direita);
        }
    }

    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();

        // Inserindo elementos
        avl.inserir(30);
        avl.inserir(20);
        avl.inserir(40);
        avl.inserir(10);
        avl.inserir(25);
        avl.inserir(35);
        avl.inserir(50);

        System.out.println("Árvore AVL em ordem:");
        avl.emOrdem(); // 10 20 25 30 35 40 50
    }
}
