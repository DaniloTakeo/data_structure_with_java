package algoritmos_de_compressao;

public class RunLengthEncoding {

    // Codifica a string usando RLE
    public static String encode(String input) {
        StringBuilder output = new StringBuilder();

        int i = 0;
        while (i < input.length()) {
            char currentChar = input.charAt(i);
            int count = 1;

            // Conta quantas vezes o mesmo caractere se repete em sequência
            while (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                i++;
                count++;
            }

            output.append(count).append(currentChar);
            i++;
        }

        return output.toString();
    }

    // Decodifica a string comprimida
    public static String decode(String encoded) {
        StringBuilder output = new StringBuilder();
        int i = 0;

        while (i < encoded.length()) {
            StringBuilder countStr = new StringBuilder();

            // Extrai o número de repetições (que pode ter mais de um dígito)
            while (Character.isDigit(encoded.charAt(i))) {
                countStr.append(encoded.charAt(i));
                i++;
            }

            int count = Integer.parseInt(countStr.toString());
            char character = encoded.charAt(i);

            for (int j = 0; j < count; j++) {
                output.append(character);
            }
            i++;
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String original = "AAAAABBBCCDAA";
        String encoded = encode(original);
        String decoded = decode(encoded);

        System.out.println("Original: " + original);
        System.out.println("Codificado: " + encoded);
        System.out.println("Decodificado: " + decoded);
    }
}