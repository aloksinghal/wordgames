package org.example.solver.spellingbee;

import java.util.List;

public class SpellingBeeRequest {
    private Character centreLetter;

    private List<Character> otherLetters;

    public SpellingBeeRequest(Character centreLetter, List<Character> otherLetters) {
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
