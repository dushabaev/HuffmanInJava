package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rustam Dushabaev on 20.01.2017.
 */

public class Tree {
    public static Node build (String data) {
        HashMap<Character, Integer> frequencies = calculateFrequencies(data);
        List<Node> nodeList = new ArrayList<>(frequencies.size());

        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            Character symbol = entry.getKey();
            Integer frequency = entry.getValue();

            nodeList.add(new Node(symbol, frequency));
        }

        while (nodeList.size() > 1) {
            Node left = popNodeWithMinFreq(nodeList);
            Node right = popNodeWithMinFreq(nodeList);

            nodeList.add(new Node(left, right));
        }

        return nodeList.get(0);
    }

    private static Node popNodeWithMinFreq(List<Node> list) {
        Node min = list.get(0);
        for (Node node : list)
            if (node.frequency < min.frequency)
                min = node;
        list.remove(min);
        return min;
    }

    private static HashMap<Character, Integer> calculateFrequencies(String data) {
        HashMap<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (res.containsKey(c))
                res.put(c, res.get(c) + 1);
            else
                res.put(c, 1);
        }
        return res;
    }
}