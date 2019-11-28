package br.com.francisco.test;

import br.com.francisco.Trie;
import org.junit.Before;

import static org.junit.Assert.*;

public class TrieTest {

    Trie tree;

    @Before
    public void initit(){
        tree = new Trie("words.txt");
    }

    @org.junit.Test
    public void delete() {
    }

    @org.junit.Test
    public void search() {
    }

    @org.junit.Test
    public void sugestions() {
    }

    @org.junit.Test
    public void testSugestions() {
    }

    @org.junit.Test
    public void showAll() {
    }
}