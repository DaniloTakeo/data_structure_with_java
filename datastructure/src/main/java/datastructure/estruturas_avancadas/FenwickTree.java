package datastructure.estruturas_avancadas;

public class FenwickTree {
    private int[] tree;

    public FenwickTree(int size) {
        tree = new int[size + 1]; // Índice 0 é ignorado
    }

    // Soma do prefixo [1, index]
    public int sum(int index) {
        int result = 0;
        while (index > 0) {
            result += tree[index];
            index -= index & -index; // move para o pai
        }
        return result;
    }

    // Soma no intervalo [left, right]
    public int rangeSum(int left, int right) {
        return sum(right) - sum(left - 1);
    }

    // Adiciona valor ao índice
    public void add(int index, int value) {
        while (index < tree.length) {
            tree[index] += value;
            index += index & -index; // move para o próximo responsável
        }
    }

    // Atualiza posição específica (para tornar = newValue)
    public void update(int index, int newValue) {
        int currentValue = rangeSum(index, index);
        add(index, newValue - currentValue);
    }

    // Exibir a árvore para debug
    public void printTree() {
        System.out.print("Fenwick Tree: ");
        for (int i = 1; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    // Exemplo de uso
    public static void main(String[] args) {
        FenwickTree ft = new FenwickTree(10);
        ft.add(1, 5);
        ft.add(2, 3);
        ft.add(3, 7);
        ft.add(4, 6);
        ft.add(5, 2);

        ft.printTree(); // Para visualizar a estrutura

        System.out.println("Soma [1, 3]: " + ft.rangeSum(1, 3));
        System.out.println("Soma [2, 5]: " + ft.rangeSum(2, 5));

        ft.update(3, 10); // Atualiza índice 3 para o valor 10

        System.out.println("Soma [1, 3] após update: " + ft.rangeSum(1, 3));
    }
}