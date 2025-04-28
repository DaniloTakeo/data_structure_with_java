package algoritmos_de_busca;

public class BuscaTernaria {

    // Busca ternária
    public static int buscaTernaria(int[] arr, int chave, int low, int high) {
        if (high >= low) {
            // Encontra os dois pontos de divisão
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            // Verifica se a chave está em algum dos pontos de divisão
            if (arr[mid1] == chave) {
                return mid1;
            } else if (arr[mid2] == chave) {
                return mid2;
            }

            // A chave pode estar na primeira, segunda ou terceira parte
            if (chave < arr[mid1]) {
                return buscaTernaria(arr, chave, low, mid1 - 1);  // Busca na primeira parte
            } else if (chave > arr[mid2]) {
                return buscaTernaria(arr, chave, mid2 + 1, high);  // Busca na terceira parte
            } else {
                return buscaTernaria(arr, chave, mid1 + 1, mid2 - 1);  // Busca na segunda parte
            }
        }

        return -1;  // Elemento não encontrado
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 12, 15, 18, 22, 25, 30, 35, 40, 45};
        int chave = 25;

        int resultado = buscaTernaria(arr, chave, 0, arr.length - 1);
        if (resultado != -1)
            System.out.println("Elemento encontrado no índice: " + resultado);
        else
            System.out.println("Elemento não encontrado.");
    }
}