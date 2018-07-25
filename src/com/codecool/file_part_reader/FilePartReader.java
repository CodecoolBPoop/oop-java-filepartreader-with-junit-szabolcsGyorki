package com.codecool.file_part_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "blabla";
        this.fromLine = 384;
        this.toLine = 1;
    }

    void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws FileNotFoundException {
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
        return read();
    }

    public static void main(String[] args) throws Exception {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("files/testFile.txt", 1, 4);
        fpr.read();
    }
}
