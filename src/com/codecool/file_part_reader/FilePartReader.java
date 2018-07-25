package com.codecool.file_part_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "blabla";
        this.fromLine = 384;
        this.toLine = 1;
    }

    String getFilePath() {
        return filePath;
    }

    Integer getFromLine() {
        return fromLine;
    }

    Integer getToLine() {
        return toLine;
    }

    void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    String read() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        StringBuilder content = new StringBuilder();
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine());
            if (scanner.hasNextLine()) {
                content.append("\n");
            }
        }
        return content.toString();
    }

    String readLines() throws FileNotFoundException {
        String content = read();
        ArrayList<String> selectedLines = new ArrayList<>(Arrays.asList(content.split("\n")));
        return selectedLines.stream()
                .filter(s -> selectedLines.indexOf(s) >= fromLine - 1 && selectedLines.indexOf(s) <= toLine - 1)
                .collect(Collectors.joining("\n"));
    }

}
