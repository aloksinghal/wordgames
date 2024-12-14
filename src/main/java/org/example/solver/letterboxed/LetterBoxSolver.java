package org.example.solver.letterboxed;

import org.example.solver.Words;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterBoxSolver {

    public List<List<String>> solveInNWords(int n, LetterBoxRequest letterBoxRequest) {
        List<String> candidates = Words.getWordsGreaterThan(3);
        List<String> filteredCandidates = candidates.stream().filter(word -> isWordAcceptable(word, letterBoxRequest)).collect(Collectors.toList());
        Map<Character, List<String>> startingCharMap = new HashMap<>();
        List<List<String>> solutions = new ArrayList<>();
        for (String word: filteredCandidates) {
            List<String> wordList = startingCharMap.getOrDefault(word.charAt(0), new ArrayList<>());
            wordList.add(word);
            startingCharMap.put(word.charAt(0), wordList);
        }
        if (n==2) {
            for (String word : filteredCandidates) {
                List<String> secondCandidates = startingCharMap.getOrDefault(word.charAt(word.length() - 1), new ArrayList<String>());
                for (String secondWord : secondCandidates) {
                    if (coversAllLetters(Stream.of(word, secondWord).collect(Collectors.toList()), letterBoxRequest)) {
                        solutions.add(Stream.of(word, secondWord).collect(Collectors.toList()));
                    }
                }
            }
        }
        if (n==3) {
            for (String word : filteredCandidates) {
                List<String> secondCandidates = startingCharMap.getOrDefault(word.charAt(word.length() - 1), new ArrayList<String>());
                for (String secondWord : secondCandidates) {
                    List<String> thirdCandidates = startingCharMap.getOrDefault(secondWord.charAt(secondWord.length() - 1), new ArrayList<String>());
                    for (String thirdWord : thirdCandidates) {
                        if (coversAllLetters(Stream.of(word, secondWord, thirdWord).collect(Collectors.toList()), letterBoxRequest)) {
                            solutions.add(Stream.of(word, secondWord, thirdWord).collect(Collectors.toList()));
                        }
                    }
                }
            }
        }

        do {
            int a  = 1;
            n--;
        } while (n >3);
        return solutions;
    }

    public boolean isWordAcceptable(String word, LetterBoxRequest letterBoxRequest) {
        int initialIndex = -2;
        for (char c: word.toCharArray()) {
            int setIndex = letterBoxRequest.getSetForLetter(c);
            if (setIndex== -1) {
                return false;
            }
            if (setIndex== initialIndex) {
                return false;
            }
            initialIndex = setIndex;
        }
        return true;
    }

    public boolean coversAllLetters(List<String> words, LetterBoxRequest letterBoxRequest) {
        Set<Character> coveredLetters = new HashSet<>();
        for (String word: words) {
            for (char c: word.toCharArray()) {
                coveredLetters.add(c);
            }
        }
        return coveredLetters.containsAll(letterBoxRequest.allCharacters);
    }

}
