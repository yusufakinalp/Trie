import java.util.ArrayList;
import java.util.List;

public class Trie {
    
    List<Node> nodes;

    public Trie() {
        nodes = new ArrayList<>();
    }

    public boolean contains(String text) {
        List<Node> compareNodes = nodes;
        for (int i = 0; i < text.length(); i++) {
            String slice = text.substring(0, i+1);
            
            int index = compareNodes.indexOf(new Node(slice));
            if(index > -1) {
                compareNodes = compareNodes.get(index).children;
            } else {
                return false;
            }
        }

        return true;
    }

    public void insert(String text) {
        List<Node> compareNodes = nodes;
        for (int i = 0; i < text.length(); i++) {
            String slice = text.substring(0, i+1);
            Node newNode = new Node(slice);
            int index = compareNodes.indexOf(newNode);
            if(index < 0) {
                compareNodes.add(newNode);
                compareNodes = newNode.children;
            } else {
                compareNodes = compareNodes.get(index).children;
            }
        }
    }
}
