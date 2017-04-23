package com.example.tetiana.randomversion2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static junit.framework.TestCase.assertTrue;
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
    public void doesNotCreateEmptyList() {
        assertTrue(randomSentence.getOptions().isEmpty());
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
        randomSentence.newList("washes dishes");
        assertEquals("John washes dishes", randomSentence.getSentence());
    }

    @Test
    public void returnsOptions(){
        randomSentence.addWord("Kate");
        randomSentence.addWord("John");
        randomSentence.newList("washes dishes");

        List<List<String>> options = asList(
                asList("Kate", "John"),
                singletonList("washes dishes")
        );

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