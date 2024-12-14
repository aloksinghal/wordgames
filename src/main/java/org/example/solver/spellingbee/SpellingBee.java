package org.example.solver.spellingbee;

import org.example.solver.Words;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SpellingBee {

    public List<String> getWords(SpellingBeeRequest spellingBeeRequest) {
        List<String> candidateSet = Words.getWordsGreaterThan(3);
        Set<Character> otherLetters =  new HashSet<>(spellingBeeRequest.getOtherLetters());
        return candidateSet.stream().filter(word -> isValidWord(word, spellingBeeRequest.getCentreLetter(), otherLetters)).collect(Collectors.toList());
    }

    public boolean isValidWord(String word, Character centreLetter, Set<Character> otherLetters) {
        char[] charArrayFromWord = word.toCharArray();
        boolean containsCentreLetter = false;
        boolean madeOnlyFromAvailLetters = true;
        for (char c: charArrayFromWord) {
            if (c == centreLetter) {
                containsCentreLetter = true;
            } else {
                if (!otherLetters.contains(c)) {
                    madeOnlyFromAvailLetters = false;
                }
            }
        }
        return containsCentreLetter && madeOnlyFromAvailLetters;
    }

}
