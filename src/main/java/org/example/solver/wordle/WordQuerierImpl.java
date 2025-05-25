package org.example.solver.wordle;

import java.util.*;
import java.util.stream.Collectors;

import org.example.utilities.Words;

public class WordQuerierImpl implements WordQuerier {
    public WordQuerierImpl() {
        this.validWords = new HashMap<>();
        this.gameState = new HashMap<>();
    }
    private Map<String,List<String>> validWords;

    private Map<String, List<LetterInfo>> gameState;

    public String initGame() {
        String gameId = UUID.randomUUID().toString();
        validWords.put(gameId, Words.getFiveLetterWords());
        gameState.put(gameId, new ArrayList<>());
        return gameId;
    }

    @Override
    public List<String> getNextSetOfValidGuesses(String gameId) {
        List<String> currentvalidWords = validWords.get(gameId);
        List<LetterInfo> currentInfo = gameState.get(gameId);
        currentvalidWords =  currentvalidWords.stream().filter(word -> isValidGuess(word, currentInfo)).collect(Collectors.toList());
        validWords.put(gameId, currentvalidWords);
        return currentvalidWords;
    }

    @Override
    public void addState(String gameId, List<LetterInfo> letterInfos) {
        List<LetterInfo> currentLetters = gameState.get(gameId);
        currentLetters.addAll(letterInfos);
    }

    private boolean isValidGuess(String guess, List<LetterInfo> currentState) {
        boolean result = false;
        for (int i =0; i < currentState.size(); i++) {
            if (!matchesState(guess, currentState.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean matchesState(String guess, LetterInfo currentStatePart) {
        for (int i =0; i < guess.length(); i++) {
            boolean isValidChar = doesCharMatchState(guess.charAt(i), i, currentStatePart);
            if (!isValidChar) {
                return false;
            }
        }
        if (currentStatePart.validity == 1 && !guess.contains(currentStatePart.character + "")) {
            return false;
        }
        return true;
    }

    private boolean doesCharMatchState(char guess, int position, LetterInfo currentStatePart) {
        //validity 0 - grey
        if (currentStatePart.validity == 0 && guess == currentStatePart.character) {
            return false;
        }
        // validity 1 - yellow
        if (currentStatePart.validity==1 && guess == currentStatePart.character && position== currentStatePart.position) {
            return false;
        }
        // validity 2 - green
        if (currentStatePart.validity==2 && guess != currentStatePart.character && position== currentStatePart.position) {
            return false;
        }
        return true;
    }
}
