package sorting_algorithms.bubble_sort;

public class BubbleSort {

    // Função que implementa o algoritmo Bubble Sort
    public static void ordenar(int[] arr) {
        int n = arr.length;

        // Passa pela lista
        for (int i = 0; i < n - 1; i++) {
            // Flag para verificar se houve troca
            boolean trocou = false;

            // Compara os elementos adjacentes
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos se estiverem na ordem errada
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Marca que houve uma troca
                    trocou = true;
                }
            }

            // Se não houve troca, significa que a lista já está ordenada
            if (!trocou) {
                break;
            }
        }
    }

    // Função auxiliar para imprimir o vetor
    public static void imprimirVetor(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Função principal para testar o Bubble Sort
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Vetor original:");
        imprimirVetor(arr);

        ordenar(arr);

        System.out.println("Vetor ordenado:");
        imprimirVetor(arr);
    }
}