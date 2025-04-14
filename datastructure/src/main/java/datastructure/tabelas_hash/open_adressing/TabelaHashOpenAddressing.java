package datastructure.tabelas_hash.open_adressing;

public class TabelaHashOpenAddressing<K, V> {
    private static final int TAMANHO = 16;

    static class Entrada<K, V> {
        K chave;
        V valor;
        boolean removido;

        Entrada(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
            this.removido = false;
        }
    }

    private Entrada<K, V>[] tabela;

    public TabelaHashOpenAddressing() {
        tabela = new Entrada[TAMANHO];
    }

    private int hash(K chave) {
        return Math.abs(chave.hashCode() % TAMANHO);
    }

    public void inserir(K chave, V valor) {
        int indice = hash(chave);
        int tentativa = 0;

        while (tentativa < TAMANHO) {
            int pos = (indice + tentativa) % TAMANHO;

            if (tabela[pos] == null || tabela[pos].removido || tabela[pos].chave.equals(chave)) {
                tabela[pos] = new Entrada<>(chave, valor);
                return;
            }
            tentativa++;
        }
        System.out.println("Tabela cheia, não foi possível inserir " + chave);
    }

    public V buscar(K chave) {
        int indice = hash(chave);
        int tentativa = 0;

        while (tentativa < TAMANHO) {
            int pos = (indice + tentativa) % TAMANHO;

            Entrada<K, V> entrada = tabela[pos];
            if (entrada == null) return null;
            if (!entrada.removido && entrada.chave.equals(chave)) return entrada.valor;

            tentativa++;
        }

        return null;
    }

    public void remover(K chave) {
        int indice = hash(chave);
        int tentativa = 0;

        while (tentativa < TAMANHO) {
            int pos = (indice + tentativa) % TAMANHO;

            Entrada<K, V> entrada = tabela[pos];
            if (entrada == null) return;
            if (!entrada.removido && entrada.chave.equals(chave)) {
                entrada.removido = true;
                return;
            }

            tentativa++;
        }
    }

    public void imprimir() {
        for (int i = 0; i < TAMANHO; i++) {
            Entrada<K, V> entrada = tabela[i];
            if (entrada == null || entrada.removido) {
                System.out.println(i + ": vazio");
            } else {
                System.out.println(i + ": " + entrada.chave + " -> " + entrada.valor);
            }
        }
    }
}