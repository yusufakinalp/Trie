import java.util.ArrayList;
import java.util.List;

public class Node {
    
    List<Node> children;

    String text;
    boolean isWord;

    public Node() {
        children = new ArrayList<>();
    }

    public Node(String text) {
        children = new ArrayList<>();
        this.text = text;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        return true;
    }
    
}
