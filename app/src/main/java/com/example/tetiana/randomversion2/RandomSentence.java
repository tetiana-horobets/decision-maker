package com.example.tetiana.randomversion2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomSentence implements Parcelable {//Для передачи объектов из одной активности в другую
    private final List<List<String>> lists;// те що передаєм
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

    void newList(String str) {
        lists.add(new ArrayList<String>());
        addWord(str);
    }

    @Override
    public int describeContents() {//описывает различного рода специальные объекты, описывающие интерфейс
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {// упаковывает объект для передачи
        dest.writeSerializable(new ArrayList<>(lists));
    }

    public static final Creator<RandomSentence> CREATOR = new Creator<RandomSentence>() {//поле которое генерирует объект класса-передатчика.
        @Override
        public RandomSentence createFromParcel(Parcel in) {
            return new RandomSentence(in);
        }

        @Override
        public RandomSentence[] newArray(int size) {
            return new RandomSentence[size];
        }
    };

    List<List<String>> getOptions() {
        return lists;
    }
}
