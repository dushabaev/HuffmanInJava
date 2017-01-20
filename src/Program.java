import Core.Decoder;
import Core.Encoder;
import Core.Node;
import Core.Tree;

import java.util.Scanner;

/**
 * Created by Rustam Dushabaev on 20.01.2017.
 */
public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter string to encode: ");
        String data = scanner.nextLine();
        Node root = Tree.build(data);
        Encoder encoder = new Encoder(root);
        Decoder decoder = new Decoder(root);

        String encodedData = encoder.encode(data);
        System.out.println("Encoded: " + encodedData);
        System.out.println("Decoded: " + decoder.decode(encodedData));
    }
}
