package sorting_algorithms;

public class QuickSort {

    // Função para ordenar o array usando Quick Sort
    public static void ordenar(int[] arr, int baixo, int alto) {
        if (baixo < alto) {
            // Particiona o array e obtém o índice do pivô
            int indicePivo = particionar(arr, baixo, alto);

            // Ordena recursivamente as duas sublistas
            ordenar(arr, baixo, indicePivo - 1);
            ordenar(arr, indicePivo + 1, alto);
        }
    }

    // Função para particionar o array
    public static int particionar(int[] arr, int baixo, int alto) {
        int pivo = arr[alto];  // Considera o último elemento como pivô
        int i = (baixo - 1);  // Índice do menor elemento

        for (int j = baixo; j < alto; j++) {
            if (arr[j] <= pivo) {
                i++;
                // Troca arr[i] com arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Troca arr[i + 1] com arr[alto] (pivô)
        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        return i + 1;
    }

    // Função auxiliar para imprimir o vetor
    public static void imprimirVetor(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Função principal para testar o Quick Sort
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Vetor original:");
        imprimirVetor(arr);

        ordenar(arr, 0, arr.length - 1);

        System.out.println("Vetor ordenado:");
        imprimirVetor(arr);
    }
}