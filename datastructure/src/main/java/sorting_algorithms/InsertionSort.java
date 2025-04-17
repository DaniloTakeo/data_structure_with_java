package sorting_algorithms;

public class InsertionSort {

    // Função que implementa o Insertion Sort
    public static void ordenar(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int chave = arr[i];
            int j = i - 1;

            // Move os elementos maiores que a chave uma posição à frente
            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insere a chave na posição correta
            arr[j + 1] = chave;
        }
    }

    // Função auxiliar para imprimir o vetor
    public static void imprimirVetor(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Função principal para testar o algoritmo
    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 13};

        System.out.println("Vetor original:");
        imprimirVetor(arr);

        ordenar(arr);

        System.out.println("Vetor ordenado:");
        imprimirVetor(arr);
    }
}