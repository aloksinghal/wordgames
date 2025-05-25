package org.example;

import org.example.solver.letterboxed.LetterBoxRequest;
import org.example.solver.letterboxed.LetterBoxSolver;
import org.example.solver.spellingbee.SpellingBee;
import org.example.solver.spellingbee.SpellingBeeRequest;
import org.example.solver.wordle.LetterInfo;
import org.example.solver.wordle.WordQuerier;
import org.example.solver.wordle.WordQuerierImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();
        characters = Stream.of('x','u','a','c','h','e').collect(Collectors.toList());
        SpellingBeeRequest spellingBeeRequest = new SpellingBeeRequest('t',characters);
        SpellingBee spellingBee = new SpellingBee();
        List<String> answers = spellingBee.getWords(spellingBeeRequest);
        System.out.println(answers);

        WordQuerier wordQuerier = new WordQuerierImpl();
        String gameId = wordQuerier.initGame();
        List<LetterInfo> letterInfos = new ArrayList<>();
        letterInfos.add(new LetterInfo('c',0,1));
        letterInfos.add(new LetterInfo('r', 1,0));
        letterInfos.add(new LetterInfo('a', 2,0));
        letterInfos.add(new LetterInfo('n',3,1));
        letterInfos.add(new LetterInfo('e', 4, 0));
        wordQuerier.addState(gameId, letterInfos);
        System.out.println(wordQuerier.getNextSetOfValidGuesses(gameId));
       List<LetterInfo> letterInfos1 =  new ArrayList<>();
        letterInfos1.add(new LetterInfo('p',0,0));
        letterInfos1.add(new LetterInfo('i', 1,1));
        letterInfos1.add(new LetterInfo('l', 2,0));
        letterInfos1.add(new LetterInfo('o',3,0));
        letterInfos1.add(new LetterInfo('t', 4, 1));
        wordQuerier.addState(gameId, letterInfos1);
        System.out.println(wordQuerier.getNextSetOfValidGuesses(gameId));


        List<LetterInfo> letterInfos2 =  new ArrayList<>();
        letterInfos2.add(new LetterInfo('p',0,0));
        letterInfos2.add(new LetterInfo('i', 1,0));
        letterInfos2.add(new LetterInfo('o', 2,1));
        letterInfos2.add(new LetterInfo('u',3,0));
        letterInfos2.add(new LetterInfo('s', 4, 1));
        wordQuerier.addState(gameId, letterInfos2);
        System.out.println(wordQuerier.getNextSetOfValidGuesses(gameId));

        Set<Character> left = Stream.of('i','h','t').collect(Collectors.toSet());
        Set<Character> right = Stream.of('d','y','l').collect(Collectors.toSet());
        Set<Character> down = Stream.of('n','x','c').collect(Collectors.toSet());
        Set<Character> up = Stream.of('o','a','e').collect(Collectors.toSet());
        LetterBoxRequest letterBoxRequest = new LetterBoxRequest(left, right, down, up);
        LetterBoxSolver letterBoxSolver = new LetterBoxSolver();
        List<List<String>> solutions = new ArrayList<>();
       solutions =  letterBoxSolver.solveInNWords(2, letterBoxRequest);
        if (solutions.isEmpty()) {
            solutions = letterBoxSolver.solveInNWords(3, letterBoxRequest);
        }
        System.out.println(solutions);
        System.out.println("Hello world!");
    }
}