package com.example.tetiana.randomversion2;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomSentenceTest {

    @Test
    public void singleList() {
        RandomSentence randomSentence = new RandomSentence();
        randomSentence.addWord("Kate");
        assertEquals("Kate", randomSentence.getSentence());
    }

    @Test
    public void twoLists(){
        RandomSentence randomSentence = new RandomSentence();
        randomSentence.addWord("Kate");
        randomSentence.addWord("John");
        randomSentence.newList();
        randomSentence.addWord("washes dishes");
        assertEquals("Kate washes dishes", randomSentence.getSentence());
    }
}