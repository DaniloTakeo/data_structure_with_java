package datastructure.arvores;

class NoTrie {
    NoTrie[] filhos = new NoTrie[26]; // Considerando apenas letras minúsculas (a-z)
    boolean fimPalavra; // Indica se esse nó representa o fim de uma palavra
}

public class Trie {
    private NoTrie raiz;

    public Trie() {
        raiz = new NoTrie();
    }

    public void inserir(String palavra) {
        NoTrie atual = raiz;
        for (char c : palavra.toCharArray()) {
            int index = c - 'a';
            if (atual.filhos[index] == null) {
                atual.filhos[index] = new NoTrie();
            }
            atual = atual.filhos[index];
        }
        atual.fimPalavra = true; 
    }

    public boolean buscar(String palavra) {
        NoTrie atual = raiz;
        for (char c : palavra.toCharArray()) {
            int index = c - 'a';
            if (atual.filhos[index] == null) {
                return false;
            }
            atual = atual.filhos[index];
        }
        return atual.fimPalavra;
    }

    public boolean comecaCom(String prefixo) {
        NoTrie atual = raiz;
        for (char c : prefixo.toCharArray()) {
            int index = c - 'a';
            if (atual.filhos[index] == null) {
                return false;
            }
            atual = atual.filhos[index];
        }
        return true;
    }

    public boolean remover(String palavra) {
        return removerRecursivo(raiz, palavra, 0);
    }

    private boolean removerRecursivo(NoTrie atual, String palavra, int depth) {
        if (atual == null) {
            return false;
        }

        if (depth == palavra.length()) {
            if (!atual.fimPalavra) {
                return false;
            }
            atual.fimPalavra = false;
            return !temFilhos(atual);
        }

        int index = palavra.charAt(depth) - 'a';
        if (removerRecursivo(atual.filhos[index], palavra, depth + 1)) {
            atual.filhos[index] = null;
            return !atual.fimPalavra && !temFilhos(atual);
        }
        return false;
    }

    private boolean temFilhos(NoTrie no) {
        for (NoTrie filho : no.filhos) {
            if (filho != null) {
                return true;
            }
        }
        return false;
    }

    public void listarPalavras() {
        listarPalavrasRec(raiz, "");
    }

    private void listarPalavrasRec(NoTrie atual, String palavra) {
        if (atual.fimPalavra) {
            System.out.println(palavra);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            int index = c - 'a';
            if (atual.filhos[index] != null) {
                listarPalavrasRec(atual.filhos[index], palavra + c);
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        
        trie.inserir("carro");
        trie.inserir("casa");
        trie.inserir("cadeira");
        trie.inserir("computador");

        System.out.println("Palavras na Trie:");
        trie.listarPalavras();

        System.out.println("\n🔍 Buscando palavras:");
        System.out.println("carro está na Trie? " + trie.buscar("carro")); // true
        System.out.println("casaco está na Trie? " + trie.buscar("casaco")); // false

        System.out.println("\n🔎 Verificando prefixos:");
        System.out.println("Prefixo 'ca' existe? " + trie.comecaCom("ca")); // true
        System.out.println("Prefixo 'xyz' existe? " + trie.comecaCom("xyz")); // false

        System.out.println("\n❌ Removendo palavra 'casa'...");
        trie.remover("casa");

        System.out.println("\n🔍 Buscando palavras novamente:");
        System.out.println("casa está na Trie? " + trie.buscar("casa")); // false
        System.out.println("carro ainda está na Trie? " + trie.buscar("carro")); // true
    }
}
