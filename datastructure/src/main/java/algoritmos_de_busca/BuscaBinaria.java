package algoritmos_de_busca;

public class BuscaBinaria {

    // Função para realizar a busca binária
    public static int buscar(int[] arr, int chave) {
        int baixo = 0;
        int alto = arr.length - 1;

        while (baixo <= alto) {
            int meio = baixo + (alto - baixo) / 2;  // Evita overflow

            // Caso o elemento seja encontrado
            if (arr[meio] == chave) {
                return meio;
            }

            // Se a chave for menor que o valor no meio, a busca vai para a metade inferior
            if (arr[meio] > chave) {
                alto = meio - 1;
            }
            // Se a chave for maior que o valor no meio, a busca vai para a metade superior
            else {
                baixo = meio + 1;
            }
        }

        return -1;  // Retorna -1 se o elemento não for encontrado
    }

    // Função auxiliar para imprimir o vetor
    public static void imprimirVetor(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Função principal para testar a Busca Binária
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};

        System.out.println("Vetor:");
        imprimirVetor(arr);

        int chave = 7;
        int indice = buscar(arr, chave);

        if (indice != -1) {
            System.out.println("Elemento " + chave + " encontrado no índice: " + indice);
        } else {
            System.out.println("Elemento " + chave + " não encontrado.");
        }
    }
}