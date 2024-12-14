package org.example.solver.wordle;

public class LetterInfo {
    public char character;
    public int position;
    public int validity;

    public LetterInfo(char character, int position, int validity) {
        this.validity = validity;
        this.position = position;
        this.character = character;
    }
}

