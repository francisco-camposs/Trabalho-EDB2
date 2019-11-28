package br.com.francisco;


import java.util.HashMap;

public class TrieNode{

    private boolean endOfWord;
    private HashMap<Character, TrieNode> childrem;


    public TrieNode() {
        this.childrem = new HashMap<>();
        endOfWord = false;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public HashMap<Character, TrieNode> getChildrem() {
        return childrem;
    }

}
