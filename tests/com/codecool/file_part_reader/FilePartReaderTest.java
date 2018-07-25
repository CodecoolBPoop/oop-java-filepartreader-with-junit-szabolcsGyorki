package com.codecool.file_part_reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private String TEST_FILE_PATH = "files/testFile.txt";
    private FilePartReader reader;

    @BeforeEach
    void initReader() {
        reader = new FilePartReader();
    }

    @Test
    void When_FilePartReaderCreated_Expect_InvalidDefaultValues() {

        assertThrows(FileNotFoundException.class, (Executable) reader::read);
        assertFalse(reader.getFromLine() >= 1 && reader.getFromLine() <= reader.getToLine());
        assertFalse(reader.getToLine() >= 1 && reader.getToLine() >= reader.getFromLine());
    }

    @Test
    void When_SetupIsCalledWithIllegalValues_Expect_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> reader.setup(TEST_FILE_PATH, 3, 2));
    }

    @Test
    void When_FilePathIsCorrect_Expect_ContentReturnedAsString() throws FileNotFoundException {
        String expected = "This assignment we will work lol with files\n" +
                "because we cannot have enough file readers\n" +
                "devoved we are oh yeah molino\n" +
                "The minotaur madam is in charge here\n" +
                "Who can be the first racer in this evening";
        reader.setup(TEST_FILE_PATH, 1, 5);
        assertEquals(expected, reader.read());
    }

    @Test
    void When_FilePathIsInvalid_Expect_ThrowsFileNotFoundException() {
        reader.setup("invalid path", 1, 5);
        assertThrows(FileNotFoundException.class, (Executable) reader::read);
    }

    @Test
    void When_InputsAreCorrect_Expect_GivenLinesAreReturned() {
        String expected = "because we cannot have enough file readers\n" +
                "devoved we are oh yeah molino";
        reader.setup(TEST_FILE_PATH, 2, 3);
        assertEquals(expected, reader.readLines());

        expected = "This assignment we will work lol with files";
        reader.setup(TEST_FILE_PATH, 1, 1);
        assertEquals(expected, reader.readLines());

        expected = "because we cannot have enough file readers\n" +
                "devoved we are oh yeah molino\n" +
                "The minotaur madam is in charge here\n" +
                "Who can be the first racer in this evening";
        reader.setup(TEST_FILE_PATH, 2, 5);
        assertEquals(expected, reader.readLines());
    }

    @Test
    void When_readLinesCantFindFile_Expected_ReturnNull() {
        reader.setup("Invalid path", 2, 4);
        assertNull(reader.readLines());
    }
}