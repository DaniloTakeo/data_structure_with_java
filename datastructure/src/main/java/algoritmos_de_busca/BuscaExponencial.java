package algoritmos_de_busca;


public class BuscaExponencial {

    // Busca Binária auxiliar
    private static int buscaBinaria(int[] arr, int esquerda, int direita, int chave) {
        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (arr[meio] == chave) return meio;
            if (arr[meio] < chave) esquerda = meio + 1;
            else direita = meio - 1;
        }
        return -1;
    }

    // Busca Exponencial
    public static int buscaExponencial(int[] arr, int chave) {
        if (arr[0] == chave) return 0;

        int i = 1;
        while (i < arr.length && arr[i] <= chave) {
            i *= 2;
        }

        return buscaBinaria(arr, i / 2, Math.min(i, arr.length - 1), chave);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 15, 19, 25, 31, 47, 59, 61, 78, 90};
        int chave = 31;

        int resultado = buscaExponencial(arr, chave);
        if (resultado != -1)
            System.out.println("Elemento encontrado no índice: " + resultado);
        else
            System.out.println("Elemento não encontrado.");
    }
}