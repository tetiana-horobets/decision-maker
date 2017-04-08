package com.example.tetiana.randomversion2;

import java.util.ArrayList;
import java.util.List;

public class RandomSentence {
    List<List<String>> lists = new ArrayList<>();

    RandomSentence() {
        lists.add(new ArrayList<String>());
    }

    public void addWord(String word) {
        int size = lists.size();
        List<String> lastList = lists.get(size - 1);
        lastList.add(word);
    }

    public String getSentence() {
        String sentence = "";
        for (int i = 0; i < lists.size(); i++) {
            List<String> options = lists.get(i);
            sentence += options.get(0);
            sentence += " ";
        }
        return sentence.trim();
    }

    public void newList() {
        lists.add(new ArrayList<String>());
    }
}
