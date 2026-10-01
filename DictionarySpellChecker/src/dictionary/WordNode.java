package dictionary;

public class WordNode {

    String word;
    WordNode left;
    WordNode right;

    public WordNode(String word) {
        this.word = word;
        left = null;
        right = null;
    }
}