package dictionary;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {

    private WordNode root;

    public Dictionary() {
        root = null;
    }

    public void insertWordNode(String word) {

        WordNode newNode = new WordNode(word);

        if (root == null) {
            root = newNode;
            return;
        }

        WordNode current = root;

        while (true) {

            int compare = word.compareTo(current.word);

            if (compare == 0) {
                return;
            }

            if (compare < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }

                current = current.left;

            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }

                current = current.right;
            }
        }
    }
    public boolean spellCheck(String word) {

        WordNode current = root;

        while (current != null) {

            int compare = word.compareTo(current.word);

            if (compare == 0) {
                return true;
            }

            if (compare < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }
    public void printWords() {
        printInOrder(root);
    }

    private void printInOrder(WordNode node) {

        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.word);
            printInOrder(node.right);
        }
    }
    public boolean isValidBST() {
        return checkBST(root, null, null);
    }

    private boolean checkBST(WordNode node, String min, String max) {

        if (node == null) {
            return true;
        }

        if (min != null && node.word.compareTo(min) <= 0) {
            return false;
        }

        if (max != null && node.word.compareTo(max) >= 0) {
            return false;
        }

        return checkBST(node.left, min, node.word)
                && checkBST(node.right, node.word, max);
    }
    public boolean hasNoCycles() {
        Set<WordNode> visited = new HashSet<>();
        return checkForCycles(root, visited);
    }

    private boolean checkForCycles(WordNode node, Set<WordNode> visited) {

        if (node == null) {
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        return checkForCycles(node.left, visited)
                && checkForCycles(node.right, visited);
    }
    public void removeWord(String word) {
        root = removeNode(root, word);
    }

    private WordNode removeNode(WordNode node, String word) {

        if (node == null) {
            return null;
        }

        int compare = word.compareTo(node.word);

        if (compare < 0) {
            node.left = removeNode(node.left, word);
        } else if (compare > 0) {
            node.right = removeNode(node.right, word);
        } else {

            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            WordNode smallest = node.right;

            while (smallest.left != null) {
                smallest = smallest.left;
            }

            node.word = smallest.word;
            node.right = removeNode(node.right, smallest.word);
        }

        return node;
    }
}