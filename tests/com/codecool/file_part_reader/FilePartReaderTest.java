package com.codecool.file_part_reader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private String TEST_FILE_PATH = "files/testFile.txt";

    @Test
    void When_FilePartReaderCreated_Expect_InvalidDefaultValues() {
        FilePartReader reader = new FilePartReader();

        assertThrows(FileNotFoundException.class, (Executable) reader::read);
        assertFalse(reader.getFromLine() >= 1 && reader.getFromLine() <= reader.getToLine());
        assertFalse(reader.getToLine() >= 1 && reader.getToLine() >= reader.getFromLine());
    }

    @Test
    void When_SetupIsCalledWithIllegalValues_Expect_ThrowsIllegalArgumentException() {
        FilePartReader reader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {reader.setup(TEST_FILE_PATH, 3, 2);});
    }

    @Test
    void When_FilePathIsCorrect_Expect_ContentReturnedAsString() throws FileNotFoundException {
        String originalContent = "This assignment we will work lol with files\n" +
                "because we cannot have enough file readers\n" +
                "devoved we are oh yeah\n" +
                "The madam is in charge here\n" +
                "Who can be the first racer in this evening";
        FilePartReader reader = new FilePartReader();
        reader.setup(TEST_FILE_PATH, 1, 5);
        assertEquals(originalContent, reader.read());
    }

    @Test
    void When_FilePathIsInvalid_Expect_ThrowsFileNotFoundException() {
        FilePartReader reader = new FilePartReader();
        reader.setup("invalid path", 1, 5);
        assertThrows(FileNotFoundException.class, (Executable) reader::read);
    }

    @Test
    void When_InputsAreCorrect_Expect_GivenLinesAreReturned() throws FileNotFoundException {
        String expected = "because we cannot have enough file readers\n" +
                "devoved we are oh yeah";
        FilePartReader reader = new FilePartReader();
        reader.setup(TEST_FILE_PATH, 2, 3);
        assertEquals(expected, reader.readLines());

        expected = "This assignment we will work lol with files";
        reader.setup(TEST_FILE_PATH, 1, 1);
        assertEquals(expected, reader.readLines());

        expected = "because we cannot have enough file readers\n" +
                "devoved we are oh yeah\n" +
                "The madam is in charge here\n" +
                "Who can be the first racer in this evening";
        reader.setup(TEST_FILE_PATH, 2, 5);
        assertEquals(expected, reader.readLines());
    }

}