package org.example.solver.wordle;

import java.util.List;

public interface WordQuerier {

    public String initGame();

    List<String> getNextSetOfValidGuesses(String gameId);

    public void addState(String gameId, List<LetterInfo> letterInfos);
}
