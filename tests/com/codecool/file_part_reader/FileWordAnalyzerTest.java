package com.codecool.file_part_reader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private String TEST_FILE_PATH = "files/testFile.txt";

    @Test
    void When_WordsByABCIsCalled_Expect_ReturnWordsAlphabetically() {
        FilePartReader reader = new FilePartReader();
        reader.setup(TEST_FILE_PATH, 1, 2);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("assignment");
        expected.add("because");
        expected.add("cannot");
        expected.add("enough");
        expected.add("file");
        expected.add("files");
        expected.add("have");
        expected.add("lol");
        expected.add("readers");
        expected.add("This");
        expected.add("we");
        expected.add("we");
        expected.add("will");
        expected.add("with");
        expected.add("work");

        assertEquals(expected, analyzer.wordsByABC());
    }



}