package algoritmos_de_busca;

public class BuscaFibonacci {

    // Busca Fibonacci
    public static int buscaFibonacci(int[] arr, int chave) {
        int n = arr.length;

        // Inicializar os números de Fibonacci
        int fibM2 = 0;  // (m-2)º Fibonacci
        int fibM1 = 1;  // (m-1)º Fibonacci
        int fibM = fibM1 + fibM2;  // mº Fibonacci

        // fibM é o menor Fibonacci >= n
        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM1 + fibM2;
        }

        // Marca o início da janela de pesquisa
        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibM2, n - 1);

            if (arr[i] < chave) {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            } else if (arr[i] > chave) {
                fibM = fibM2;
                fibM1 = fibM1 - fibM2;
                fibM2 = fibM - fibM1;
            } else {
                return i;  // Elemento encontrado
            }
        }

        // Verifica o último possível elemento
        if (fibM1 == 1 && offset + 1 < n && arr[offset + 1] == chave) {
            return offset + 1;
        }

        // Elemento não encontrado
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 12, 15, 18, 22, 25, 30, 35, 40, 45};
        int chave = 25;

        int resultado = buscaFibonacci(arr, chave);
        if (resultado != -1)
            System.out.println("Elemento encontrado no índice: " + resultado);
        else
            System.out.println("Elemento não encontrado.");
    }
}