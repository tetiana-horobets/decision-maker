package com.example.tetiana.randomversion2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doAnswer;

public class RandomSentenceTest {

    private RandomSentence randomSentence;

    @Before
    public void setUp() throws Exception {
        Random random = createRandom();
        randomSentence = new RandomSentence(random);
    }

    @Test
    public void singleList() {
        randomSentence.addWord("Kate");
        assertEquals("Kate", randomSentence.getSentence());
    }

    @Test
    public void twoLists(){
        randomSentence.addWord("Kate");
        randomSentence.addWord("John");
        randomSentence.newList();
        randomSentence.addWord("washes dishes");
        assertEquals("John washes dishes", randomSentence.getSentence());
    }

    @Test
    public void returnsOptions(){
        randomSentence.addWord("Kate");
        randomSentence.addWord("John");
        randomSentence.newList();
        randomSentence.addWord("washes dishes");

        List<String> options = new ArrayList<>();
        options.add("Kate\nJohn\n");
        options.add("washes dishes\n");
        assertEquals(options, randomSentence.getOptions());
    }

    private Random createRandom() {
        Random random = Mockito.mock(Random.class);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return ((int) invocation.getArguments()[0]) - 1;
            }
        }).when(random).nextInt(anyInt());

        return random;
    }
}