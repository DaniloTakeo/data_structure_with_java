package algoritmos_de_compressao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZWCompressor {

    public static List<Integer> compress(String input) {
        int dictSize = 256;
        Map<String, Integer> dictionary = new HashMap<>();

        // Inicializa o dicionário com caracteres ASCII
        for (int i = 0; i < dictSize; i++) {
            dictionary.put("" + (char) i, i);
        }

        String current = "";
        List<Integer> result = new ArrayList<>();

        for (char c : input.toCharArray()) {
            String next = current + c;
            if (dictionary.containsKey(next)) {
                current = next;
            } else {
                result.add(dictionary.get(current));
                dictionary.put(next, dictSize++);
                current = "" + c;
            }
        }

        if (!current.equals("")) {
            result.add(dictionary.get(current));
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "ABABABA";
        List<Integer> compressed = compress(input);
        System.out.println("Texto original: " + input);
        System.out.println("Comprimido (códigos): " + compressed);
    }
}