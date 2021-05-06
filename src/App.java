public class App {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("apply");
        trie.insert("ab");
        trie.insert("aba");
        trie.insert("abacı");
        trie.insert("abacılık");
        trie.insert("abajur");
        trie.insert("abaküs");
        trie.insert("abalı");
        trie.insert("abana");

        System.out.println(trie.contains("app")); // true
        System.out.println(trie.contains("apple")); // true
        System.out.println(trie.contains("appe")); // false
        System.out.println(trie.contains("applic"));// true

        System.out.println(trie.find("app").text);
        System.out.println(trie.findPossibles("app"));
        System.out.println(trie.findPossibles("ab"));
        System.out.println(trie.findPossibles("abac"));
    }
}
