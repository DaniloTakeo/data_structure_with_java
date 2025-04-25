package algoritmos_de_busca;

public class BuscaPorSalto {

    // Busca por salto
    public static int buscaPorSalto(int[] arr, int chave) {
        int n = arr.length;
        int passo = (int) Math.sqrt(n);  // Tamanho do salto

        // Encontrar o intervalo onde a chave pode estar
        int esquerda = 0;
        int direita = Math.min(passo, n) - 1;

        while (arr[direita] < chave) {
            esquerda = direita;
            direita = Math.min(direita + passo, n) - 1;
            if (arr[esquerda] > chave) return -1;
        }

        // Realiza uma busca linear dentro do intervalo encontrado
        for (int i = esquerda; i <= direita; i++) {
            if (arr[i] == chave) {
                return i;  // Retorna o índice
            }
        }

        return -1;  // Se não encontrado
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 12, 15, 18, 22, 25, 30, 35, 40, 45};
        int chave = 25;

        int resultado = buscaPorSalto(arr, chave);
        if (resultado != -1)
            System.out.println("Elemento encontrado no índice: " + resultado);
        else
            System.out.println("Elemento não encontrado.");
    }
}