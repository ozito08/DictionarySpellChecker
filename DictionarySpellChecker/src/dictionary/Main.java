package dictionary;

public class Main {

    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();

        String paragraph = "the cat likes to read a book at school";

        String[] words = paragraph.split(" ");

        for (String word : words) {
            dictionary.insertWordNode(word);
        }

        System.out.println("Dictionary in sorted order:");
        dictionary.printWords();

        System.out.println();

        String sentence = "the cat likes to reed a book";

        String[] checkWords = sentence.split(" ");

        System.out.println("Spell check:");

        for (String word : checkWords) {
            if (dictionary.spellCheck(word)) {
                System.out.println(word + " - correct");
            } else {
                System.out.println(word + " - misspelled");
            }
        }
    }
}