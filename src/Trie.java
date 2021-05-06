import java.util.ArrayList;
import java.util.List;

public class Trie {
    
    List<Node> nodes;

    public Trie() {
        nodes = new ArrayList<>();
    }

    public List<String> findPossibles(String text) {
        List<String> wordList = new ArrayList<>();
        Node node = find(text);

        if (node != null) {
            getWords(wordList, node.children);
        }

        return wordList;
    }

    public void getWords(List<String> wordList, List<Node> nodeList) {
        if(nodeList.isEmpty()) {
            return;
        }

        nodeList.forEach(node -> {if (node.isWord) wordList.add(node.text);});

        nodeList.forEach(node -> getWords(wordList, node.children));
    }

    public Node find(String text) {
        List<Node> compareNodes = nodes;
        for (int i = 0; i < text.length(); i++) {
            String slice = text.substring(0, i+1);
            
            int index = compareNodes.indexOf(new Node(slice));
            if(index > -1) {
                if(slice.length() == text.length()) {
                    return compareNodes.get(index);
                }
                compareNodes = compareNodes.get(index).children;
            }
        }

        return null;
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
            boolean isWord = slice.length() == text.length();
            Node newNode = new Node(slice);
            newNode.isWord = isWord;
            int index = compareNodes.indexOf(newNode);
            if(index < 0) {
                compareNodes.add(newNode);
                compareNodes = newNode.children;
            } else {
                Node existingNode = compareNodes.get(index);
                existingNode.isWord = existingNode.isWord || isWord;
                compareNodes = compareNodes.get(index).children;
            }
        }
    }
}
