package algoritmos_de_compressao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    // Comparator para ordenar a fila de prioridade
    static class NodeComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode a, HuffmanNode b) {
            return a.frequency - b.frequency;
        }
    }

    // Gera o mapa de códigos a partir da árvore
    private static void buildCodeMap(HuffmanNode root, String code, Map<Character, String> codeMap) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            codeMap.put(root.character, code);
        }

        buildCodeMap(root.left, code + "0", codeMap);
        buildCodeMap(root.right, code + "1", codeMap);
    }

    public static Map<Character, String> buildHuffmanCodes(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new NodeComparator());

        for (var entry : frequencyMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode merged = new HuffmanNode('\0', left.frequency + right.frequency);
            merged.left = left;
            merged.right = right;

            pq.add(merged);
        }

        HuffmanNode root = pq.poll();
        Map<Character, String> codeMap = new HashMap<>();
        buildCodeMap(root, "", codeMap);
        return codeMap;
    }

    public static String encode(String input, Map<Character, String> codeMap) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : input.toCharArray()) {
            encoded.append(codeMap.get(ch));
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        String text = "ABRACADABRA";

        Map<Character, String> huffmanCodes = buildHuffmanCodes(text);
        System.out.println("Códigos de Huffman:");
        for (var entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String encoded = encode(text, huffmanCodes);
        System.out.println("Texto original: " + text);
        System.out.println("Texto codificado: " + encoded);
    }
}