package algoritmos_de_busca;

public class BuscaInterpolada {

    // Busca Interpolada
    public static int buscaInterpolada(int[] arr, int chave) {
        int esquerda = 0, direita = arr.length - 1;

        while (esquerda <= direita && chave >= arr[esquerda] && chave <= arr[direita]) {
            // Calculando o índice de acordo com a fórmula de interpolação
            int pos = esquerda + ((chave - arr[esquerda]) * (direita - esquerda)) / (arr[direita] - arr[esquerda]);

            // Verificando se encontramos o valor
            if (arr[pos] == chave) return pos;

            // Se a chave for menor, procuramos na parte esquerda
            if (arr[pos] > chave) direita = pos - 1;

            // Caso contrário, procuramos na parte direita
            else esquerda = pos + 1;
        }

        return -1; // Se não encontrar
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 35, 40, 45, 60, 75, 80, 85, 90};
        int chave = 60;

        int resultado = buscaInterpolada(arr, chave);
        if (resultado != -1)
            System.out.println("Elemento encontrado no índice: " + resultado);
        else
            System.out.println("Elemento não encontrado.");
    }
}