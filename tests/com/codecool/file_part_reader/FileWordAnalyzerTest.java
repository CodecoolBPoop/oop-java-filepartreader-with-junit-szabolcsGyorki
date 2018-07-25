package com.codecool.file_part_reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private String TEST_FILE_PATH = "files/testFile.txt";
    private FilePartReader reader;
    private FileWordAnalyzer analyzer;

    @BeforeEach
    void initReaderAndAnalyzer() {
        reader = new FilePartReader();
        analyzer = new FileWordAnalyzer(reader);
    }

    @Test
    void When_WordsByABCIsCalled_Expect_ReturnWordsAlphabetically() {
        reader.setup(TEST_FILE_PATH, 1, 2);

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

    @Test
    void When_wordsContainingSubStringIsCalled_Expect_ReturnWordsWithSubstring() {
        reader.setup(TEST_FILE_PATH, 1, 1);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("will");
        expected.add("files");

        assertEquals(expected, analyzer.wordsContainingSubString("il"));

        reader.setup(TEST_FILE_PATH, 2, 4);

        expected = new ArrayList<>();
        expected.add("cannot");
        expected.add("enough");
        expected.add("molino");
        expected.add("minotaur");

        assertEquals(expected, analyzer.wordsContainingSubString("no"));
    }

    @Test
    void When_wordsArePalindromeICalled_Expect_ReturnPalindromes() {
        reader.setup(TEST_FILE_PATH, 1,5);

        ArrayList<String > expected = new ArrayList<>();
        expected.add("lol");
        expected.add("devoved");
        expected.add("madam");

        assertEquals(expected, analyzer.wordsArePalindrome());
    }

}