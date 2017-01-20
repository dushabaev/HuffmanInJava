package Core;

/**
 * Created by Rustam Dushabaev on 20.01.2017.
 */

public class Encoder {
    private Node _root;

    public Encoder(Node root){
        _root = root;
    }

    public Node get_root() {
        return _root;
    }

    public void set_root(Node _root) {
        this._root = _root;
    }

    public String encode(String data) {
        String res = "";
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            res += encode(ch);
        }
        return res;
    }

    private String encode(char symbol) {
        return encode(_root, symbol, "");
    }

    private String encode(Node node, char symbol, String code){
        String res;
        if (node.symbol == '\0'){
            res = encode(node.left, symbol, code + '0');
            if (res.length() == 0)
                res = encode(node.right, symbol, code + '1');
            return res;
        }
        else return node.symbol == symbol ? code : "";
    }
}
