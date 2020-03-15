public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    public TrieNode()
    {
        isEndOfWord = false;
        for (int i = 0; i < children.length; i++)
            children[i] = null;
    }
}