public class App {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("application");
        trie.insert("apply");

        System.out.println(trie.contains("app"));   //true
        System.out.println(trie.contains("apple")); //true
        System.out.println(trie.contains("appe"));  //false
        System.out.println(trie.contains("applic"));//true
    }
}
