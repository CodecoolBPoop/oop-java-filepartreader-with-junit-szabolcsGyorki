package com.codecool.file_part_reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    private FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    private ArrayList<String> readLines() {
        return new ArrayList<>(Arrays.asList(reader.readLines().split("\n\\\\")));
    }

    public ArrayList<String> wordsByABC() {
        ArrayList<String> lines = readLines();
        lines.sort(String::compareToIgnoreCase);
        return lines;
    }

    public ArrayList<String> wordsContainingSubString(String subString) {
        ArrayList<String> lines = readLines();
        return lines.stream()
                .filter(s -> s.contains(subString))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String > wordsArePalindrome() {
        ArrayList<String> lines = readLines();
        return lines.stream()
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
