package org.example.generator.spellingbee;

import java.util.List;

import org.example.pojo.spellingbee.SpellingBee;
import org.example.utilities.Words;

public class SpellingBeeGenerator {

    public SpellingBee generateSpellingBee() {
        
        List<String> sevenLetterWords = Words.getWordsWithNUniqueLetters(7);

        String randomWord = sevenLetterWords.get((int) (Math.random() * sevenLetterWords.size()));
        Character centreLetter = randomWord.charAt((int) (Math.random() * 7));
        List<Character> otherLetters = randomWord.chars()
                .filter(c -> c != centreLetter)
                .mapToObj(c -> (char) c)
                .toList();
        return new SpellingBee(centreLetter, otherLetters);
    }
}
