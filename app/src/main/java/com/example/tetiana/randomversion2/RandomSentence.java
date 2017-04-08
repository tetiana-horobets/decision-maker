package com.example.tetiana.randomversion2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomSentence implements Parcelable {
    private final List<List<String>> lists;
    private final Random random;

    RandomSentence(Random random) {
        this.random = random;
        this.lists = new ArrayList<>();

        this.lists.add(new ArrayList<String>());
    }

    private RandomSentence(Parcel in) {
        lists = (List<List<String>>) in.readSerializable();
        this.random = new Random();
    }


    void addWord(String word) {
        int size = lists.size();
        List<String> lastList = lists.get(size - 1);
        lastList.add(word);
    }

    String getSentence() {
        String sentence = "";
        for (int i = 0; i < lists.size(); i++) {
            List<String> options = lists.get(i);
            int randomNumber = random.nextInt(options.size());
            sentence += options.get(randomNumber);
            sentence += " ";
        }
        return sentence.trim();
    }

    void newList() {
        lists.add(new ArrayList<String>());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(new ArrayList<>(lists));
    }

    public static final Creator<RandomSentence> CREATOR = new Creator<RandomSentence>() {
        @Override
        public RandomSentence createFromParcel(Parcel in) {
            return new RandomSentence(in);
        }

        @Override
        public RandomSentence[] newArray(int size) {
            return new RandomSentence[size];
        }
    };
}
