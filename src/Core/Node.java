package Core;

/**
 * Created by Rustam Dushabaev on 20.01.2017.
 */
public class Node {
    Node left;
    Node right;
    int frequency;
    char symbol;

    Node(Node left, Node right){
        this('\0', left.frequency + right.frequency, left, right);
    }

    Node(char symbol, int frequency){
        this(symbol, frequency, null, null);
    }

    private Node(Character symbol, int frequency, Node left, Node right){
        this.left = left;
        this.right = right;
        this.frequency = frequency;
        this.symbol = symbol;
    }
}
