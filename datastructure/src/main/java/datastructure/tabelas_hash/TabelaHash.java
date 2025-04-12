package datastructure.tabelas_hash;

import java.util.LinkedList;

public class TabelaHash<K, V> {
    private static final int TAMANHO_INICIAL = 16;
    private LinkedList<Entrada<K, V>>[] tabela;

    public TabelaHash() {
        tabela = new LinkedList[TAMANHO_INICIAL];
        for (int i = 0; i < TAMANHO_INICIAL; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    static class Entrada<K, V> {
        K chave;
        V valor;

        Entrada(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    private int hash(K chave) {
        return Math.abs(chave.hashCode() % TAMANHO_INICIAL);
    }

    public void inserir(K chave, V valor) {
        int indice = hash(chave);
        for (Entrada<K, V> entrada : tabela[indice]) {
            if (entrada.chave.equals(chave)) {
                entrada.valor = valor;
                return;
            }
        }
        tabela[indice].add(new Entrada<>(chave, valor));
    }

    public V buscar(K chave) {
        int indice = hash(chave);
        for (Entrada<K, V> entrada : tabela[indice]) {
            if (entrada.chave.equals(chave)) {
                return entrada.valor;
            }
        }
        return null;
    }

    public void remover(K chave) {
        int indice = hash(chave);
        tabela[indice].removeIf(entrada -> entrada.chave.equals(chave));
    }

    public void imprimir() {
        for (int i = 0; i < tabela.length; i++) {
            System.out.print(i + ": ");
            for (Entrada<K, V> entrada : tabela[i]) {
                System.out.print("[" + entrada.chave + " -> " + entrada.valor + "] ");
            }
            System.out.println();
        }
    }
}