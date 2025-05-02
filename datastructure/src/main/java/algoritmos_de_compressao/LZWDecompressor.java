package algoritmos_de_compressao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZWDecompressor {

    public static String decompress(List<Integer> compressed) {
        int dictSize = 256;
        Map<Integer, String> dictionary = new HashMap<>();

        for (int i = 0; i < dictSize; i++) {
            dictionary.put(i, "" + (char) i);
        }

        String w = "" + (char) (int) compressed.remove(0);
        StringBuilder result = new StringBuilder(w);

        for (int k : compressed) {
            String entry;
            if (dictionary.containsKey(k)) {
                entry = dictionary.get(k);
            } else if (k == dictSize) {
                entry = w + w.charAt(0);
            } else {
                throw new IllegalArgumentException("Código inválido: " + k);
            }

            result.append(entry);
            dictionary.put(dictSize++, w + entry.charAt(0));
            w = entry;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        List<Integer> compressed = Arrays.asList(65, 66, 256, 258, 65);
        String decompressed = decompress(compressed);
        System.out.println("Descomprimido: " + decompressed);
    }
}