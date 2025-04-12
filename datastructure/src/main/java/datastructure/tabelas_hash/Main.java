package datastructure.tabelas_hash;

public class Main {
    public static void main(String[] args) {
        TabelaHash<String, Integer> tabela = new TabelaHash<>();
        tabela.inserir("João", 25);
        tabela.inserir("Maria", 30);
        tabela.inserir("Pedro", 20);
        tabela.inserir("João", 27); // Atualiza valor

        tabela.imprimir();

        System.out.println("Idade de Maria: " + tabela.buscar("Maria"));
        tabela.remover("Pedro");
        tabela.imprimir();
    }
}