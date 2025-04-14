package datastructure.tabelas_hash.open_adressing;

public class Main {
    public static void main(String[] args) {
        TabelaHashOpenAddressing<String, Integer> tabela = new TabelaHashOpenAddressing<>();

        tabela.inserir("A", 1);
        tabela.inserir("B", 2);
        tabela.inserir("C", 3);
        tabela.inserir("D", 4);

        tabela.imprimir();

        System.out.println("Valor da chave B: " + tabela.buscar("B"));

        tabela.remover("B");
        tabela.imprimir();

        System.out.println("Busca após remoção (B): " + tabela.buscar("B"));
    }
}