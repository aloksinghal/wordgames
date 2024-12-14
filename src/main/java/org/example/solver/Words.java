package org.example.solver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Words {
    public static List<String> getFiveLetterWords() {
        Scanner s = null;
        try {
            s = new Scanner(new File("/home/alok/personal/words/src/wordlist.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        return list.stream().filter(word -> word.length() == 5).collect(Collectors.toList());
    }

    public static List<String> getWordsGreaterThan(int n) {
        Scanner s = null;
        try {
            s = new Scanner(new File("/home/alok/personal/words/src/wordlist.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        return list.stream().filter(word -> word.length() > n).collect(Collectors.toList());
    }

}
