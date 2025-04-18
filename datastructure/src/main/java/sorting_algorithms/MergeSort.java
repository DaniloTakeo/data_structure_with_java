package sorting_algorithms;

public class MergeSort {

    // Função principal para ordenar
    public static void ordenar(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // Divide o array em duas metades
        int meio = arr.length / 2;
        int[] esquerda = new int[meio];
        int[] direita = new int[arr.length - meio];

        // Copia os elementos para as sublistas esquerda e direita
        System.arraycopy(arr, 0, esquerda, 0, meio);
        System.arraycopy(arr, meio, direita, 0, arr.length - meio);

        // Ordena as duas metades
        ordenar(esquerda);
        ordenar(direita);

        // Mescla as duas metades ordenadas
        mesclar(arr, esquerda, direita);
    }

    // Função para mesclar duas sublistas ordenadas
    public static void mesclar(int[] arr, int[] esquerda, int[] direita) {
        int i = 0, j = 0, k = 0;

        // Mescla as duas listas
        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
                arr[k++] = esquerda[i++];
            } else {
                arr[k++] = direita[j++];
            }
        }

        // Copia os elementos restantes de esquerda, se houver
        while (i < esquerda.length) {
            arr[k++] = esquerda[i++];
        }

        // Copia os elementos restantes de direita, se houver
        while (j < direita.length) {
            arr[k++] = direita[j++];
        }
    }

    // Função auxiliar para imprimir o vetor
    public static void imprimirVetor(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Função principal para testar o Merge Sort
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Vetor original:");
        imprimirVetor(arr);

        ordenar(arr);

        System.out.println("Vetor ordenado:");
        imprimirVetor(arr);
    }
}
