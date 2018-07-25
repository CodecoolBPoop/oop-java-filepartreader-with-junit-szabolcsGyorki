package com.codecool.file_part_reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class FileWordAnalyzer {

    private FilePartReader reader;
    private ArrayList<String> lines;

    FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    private ArrayList<String> readLines() {
        return new ArrayList<>(Arrays.asList(reader.readLines().split("\\s")));
    }

    ArrayList<String> wordsByABC() {
        lines = readLines();
        lines.sort(String::compareToIgnoreCase);
        return lines;
    }

    ArrayList<String> wordsContainingSubString(String subString) {
        lines = readLines();
        return lines.stream()
                .filter(s -> s.contains(subString))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<String > wordsArePalindrome() {
        lines = readLines();
        return lines.stream()
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
