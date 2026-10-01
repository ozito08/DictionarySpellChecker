package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dictionary.Dictionary;

public class DictionaryTest {

    @Test
    public void testInsertAndSpellCheck() {
        Dictionary dictionary = new Dictionary();

        dictionary.insertWordNode("cat");
        dictionary.insertWordNode("dog");
        dictionary.insertWordNode("apple");

        assertTrue(dictionary.spellCheck("cat"));
        assertTrue(dictionary.spellCheck("dog"));
        assertTrue(dictionary.spellCheck("apple"));
    }

    @Test
    public void testMisspelledWord() {
        Dictionary dictionary = new Dictionary();

        dictionary.insertWordNode("book");
        dictionary.insertWordNode("school");

        assertFalse(dictionary.spellCheck("bok"));
        assertFalse(dictionary.spellCheck("skool"));
    }

    @Test
    public void testEmptyDictionary() {
        Dictionary dictionary = new Dictionary();

        assertFalse(dictionary.spellCheck("cat"));
    }

    @Test
    public void testDuplicateWord() {
        Dictionary dictionary = new Dictionary();

        dictionary.insertWordNode("cat");
        dictionary.insertWordNode("cat");

        assertTrue(dictionary.spellCheck("cat"));
    }
    @Test
    public void testBSTStructure() {
        Dictionary dictionary = new Dictionary();

        dictionary.insertWordNode("mango");
        dictionary.insertWordNode("apple");
        dictionary.insertWordNode("orange");
        dictionary.insertWordNode("banana");
        dictionary.insertWordNode("grape");

        assertTrue(dictionary.isValidBST());
    }
    @Test
    public void testNoCycles() {
        Dictionary dictionary = new Dictionary();

        dictionary.insertWordNode("mango");
        dictionary.insertWordNode("apple");
        dictionary.insertWordNode("orange");
        dictionary.insertWordNode("banana");
        dictionary.insertWordNode("grape");

        assertTrue(dictionary.hasNoCycles());
    }
    @Test
    public void testRemoveLeafNode() {
        Dictionary dictionary = new Dictionary();

        dictionary.insertWordNode("mango");
        dictionary.insertWordNode("apple");
        dictionary.insertWordNode("orange");

        dictionary.removeWord("apple");

        assertFalse(dictionary.spellCheck("apple"));
        assertTrue(dictionary.isValidBST());
    }

    @Test
    public void testRemoveNodeWithOneChild() {
        Dictionary dictionary = new Dictionary();

        dictionary.insertWordNode("mango");
        dictionary.insertWordNode("apple");
        dictionary.insertWordNode("banana");

        dictionary.removeWord("apple");

        assertFalse(dictionary.spellCheck("apple"));
        assertTrue(dictionary.spellCheck("banana"));
        assertTrue(dictionary.isValidBST());
    }

    @Test
    public void testRemoveNodeWithTwoChildren() {
        Dictionary dictionary = new Dictionary();

        dictionary.insertWordNode("mango");
        dictionary.insertWordNode("apple");
        dictionary.insertWordNode("orange");
        dictionary.insertWordNode("banana");
        dictionary.insertWordNode("grape");

        dictionary.removeWord("apple");

        assertFalse(dictionary.spellCheck("apple"));
        assertTrue(dictionary.spellCheck("banana"));
        assertTrue(dictionary.spellCheck("grape"));
        assertTrue(dictionary.isValidBST());
    }

    @Test
    public void testRemoveWordNotFound() {
        Dictionary dictionary = new Dictionary();

        dictionary.insertWordNode("cat");
        dictionary.insertWordNode("dog");

        dictionary.removeWord("apple");

        assertTrue(dictionary.spellCheck("cat"));
        assertTrue(dictionary.spellCheck("dog"));
        assertTrue(dictionary.isValidBST());
    }
}