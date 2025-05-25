package org.example.pojo.spellingbee;

import java.util.List;

public class SpellingBee {
    private Character centreLetter;

    private List<Character> otherLetters;

    public SpellingBee(Character centreLetter, List<Character> otherLetters) {
        this.centreLetter  = centreLetter;
        this.otherLetters = otherLetters;
    }

    public Character getCentreLetter() {
        return centreLetter;
    }

    public List<Character> getOtherLetters() {
        return otherLetters;
    }
}
