package algoritmos_de_busca;

public class BuscaLinear {
    
    public static int buscar(int[] arr, int chave) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == chave) {
                return i; // Retorna o índice onde a chave foi encontrada
            }
        }
        return -1; // Retorna -1 se não encontrou
    }

    public static void main(String[] args) {
        int[] numeros = {5, 3, 9, 1, 7};
        int chave = 9;

        int indice = buscar(numeros, chave);

        if (indice != -1) {
            System.out.println("Elemento encontrado no índice: " + indice);
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }
}