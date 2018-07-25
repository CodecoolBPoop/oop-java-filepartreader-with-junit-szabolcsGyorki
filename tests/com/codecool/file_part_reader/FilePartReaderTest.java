package com.codecool.file_part_reader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private String TEST_FILE_PATH = "files/testFile.txt";

    @Test
    void testIfTheFileIsReadCorrectly() throws FileNotFoundException {
        String originalContent = "This assignment we will work lol with files\n" +
                "because we cannot have enough file readers\n" +
                "devoved we are oh yeah\n" +
                "The madam is in charge here\n" +
                "Who can be the first racer in this evening";
        FilePartReader reader = new FilePartReader();
        reader.setup(TEST_FILE_PATH, 1, 5);
        assertEquals(originalContent, reader.readLines());
    }

}