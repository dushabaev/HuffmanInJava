package Core;

/**
 * Created by Rustam Dushabaev on 20.01.2017.
 */

public class Decoder {
    private Node _root;

    public Decoder(Node root){
        _root = root;
    }

    public String decode(String data) {
        String res = "";
        Node currNode = _root;

        for (int i = 0; i < data.length(); i++) {
            boolean isLeftNode = ((data.charAt(i) - '0') == 0);
            currNode = isLeftNode ? currNode.left : currNode.right;

            if (currNode.symbol != '\0'){ // leaf nodes
                res += currNode.symbol;
                currNode = _root;
            }
        }
        return res;
    }
}
