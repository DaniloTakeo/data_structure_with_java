package datastructure.arvores;

class NoRB {
    int valor;
    NoRB esquerda, direita, pai;
    boolean cor; // true = vermelho, false = preto

    public NoRB(int valor) {
        this.valor = valor;
        this.cor = true; // Novos nós são sempre vermelhos por padrão
    }
}

public class ArvoreRB {
    private NoRB raiz;
    private final NoRB NULL = new NoRB(-1); // Nó nulo (preto)

    public ArvoreRB() {
        raiz = NULL;
    }

    // Rotação à esquerda
    private void rotacaoEsquerda(NoRB x) {
        NoRB y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != NULL) {
            y.esquerda.pai = x;
        }
        y.pai = x.pai;
        if (x.pai == NULL) {
            raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }
        y.esquerda = x;
        x.pai = y;
    }

    // Rotação à direita
    private void rotacaoDireita(NoRB y) {
        NoRB x = y.esquerda;
        y.esquerda = x.direita;
        if (x.direita != NULL) {
            x.direita.pai = y;
        }
        x.pai = y.pai;
        if (y.pai == NULL) {
            raiz = x;
        } else if (y == y.pai.direita) {
            y.pai.direita = x;
        } else {
            y.pai.esquerda = x;
        }
        x.direita = y;
        y.pai = x;
    }

    // Inserção
    public void inserir(int valor) {
        NoRB novoNo = new NoRB(valor);
        novoNo.esquerda = NULL;
        novoNo.direita = NULL;

        NoRB pai = null;
        NoRB atual = raiz;

        while (atual != NULL) {
            pai = atual;
            if (valor < atual.valor) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }

        novoNo.pai = pai;
        if (pai == null) {
            raiz = novoNo;
        } else if (valor < pai.valor) {
            pai.esquerda = novoNo;
        } else {
            pai.direita = novoNo;
        }

        novoNo.cor = true; // Sempre insere como vermelho
        balancearInsercao(novoNo);
    }

    // Balanceamento após inserção
    private void balancearInsercao(NoRB no) {
        while (no.pai != null && no.pai.cor == true) {
            NoRB avo = no.pai.pai;
            if (no.pai == avo.esquerda) { // Pai está na esquerda do avô
                NoRB tio = avo.direita;
                if (tio.cor == true) { // Caso 1: Tio é vermelho (recoloração)
                    avo.cor = true;
                    no.pai.cor = false;
                    tio.cor = false;
                    no = avo;
                } else { // Caso 2 ou 3: Tio é preto (rotação)
                    if (no == no.pai.direita) { // Caso 2: Nó está à direita (rotação esquerda)
                        no = no.pai;
                        rotacaoEsquerda(no);
                    }
                    // Caso 3: Rotação direita no avô
                    no.pai.cor = false;
                    avo.cor = true;
                    rotacaoDireita(avo);
                }
            } else { // Pai está na direita do avô (espelhado)
                NoRB tio = avo.esquerda;
                if (tio.cor == true) { // Caso 1: Tio é vermelho (recoloração)
                    avo.cor = true;
                    no.pai.cor = false;
                    tio.cor = false;
                    no = avo;
                } else { // Caso 2 ou 3: Tio é preto (rotação)
                    if (no == no.pai.esquerda) { // Caso 2: Nó está à esquerda (rotação direita)
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    // Caso 3: Rotação esquerda no avô
                    no.pai.cor = false;
                    avo.cor = true;
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.cor = false; // Garante que a raiz sempre seja preta
    }

    // Percurso em ordem
    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(NoRB no) {
        if (no != NULL) {
            emOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdemRec(no.direita);
        }
    }

    public static void main(String[] args) {
        ArvoreRB rb = new ArvoreRB();
        rb.inserir(20);
        rb.inserir(15);
        rb.inserir(30);
        rb.inserir(10);
        rb.inserir(25);
        rb.inserir(35);

        System.out.println("Árvore Red-Black em ordem:");
        rb.emOrdem(); // Saída esperada: 10 15 20 25 30 35
    }
}
