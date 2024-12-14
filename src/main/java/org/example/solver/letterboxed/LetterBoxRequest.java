package org.example.solver.letterboxed;


import java.util.*;

public class LetterBoxRequest {
    public List<Set<Character>> inputEdges;

    public Set<Character> allCharacters;

    public LetterBoxRequest(Set<Character> left, Set<Character> right, Set<Character> down, Set<Character> up) {
        List<Set<Character>> inputEdges = new ArrayList<>();
        inputEdges.add(left);
        inputEdges.add(right);
        inputEdges.add(down);
        inputEdges.add(up);
        this.inputEdges = inputEdges;
        this.allCharacters = getAllCharacters(inputEdges);
    }

    public int getSetForLetter(char c) {
        for (int i = 0; i < inputEdges.size(); i++) {
            if (inputEdges.get(i).contains(c)) {
                return i;
            }
        }
        return -1;
    }

    public Set<Character> getAllCharacters(List<Set<Character>> inputEdges) {
        Set<Character> allCharacters = new HashSet<>();
        for (Set<Character> edge: inputEdges) {
            for (Character c: edge) {
                allCharacters.add(c);
            }
        }
        return allCharacters;
    }
}
