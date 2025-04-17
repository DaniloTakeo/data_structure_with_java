package sorting_algorithms;

public class SelectionSort {

    // Função que implementa o Selection Sort
    public static void ordenar(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Assume que o menor elemento está na posição atual
            int indiceMenor = i;

            // Procura o menor elemento no restante do array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            // Troca o menor elemento com o elemento da posição atual
            if (indiceMenor != i) {
                int temp = arr[i];
                arr[i] = arr[indiceMenor];
                arr[indiceMenor] = temp;
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

    // Função principal para testar o Selection Sort
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Vetor original:");
        imprimirVetor(arr);

        ordenar(arr);

        System.out.println("Vetor ordenado:");
        imprimirVetor(arr);
    }
}
