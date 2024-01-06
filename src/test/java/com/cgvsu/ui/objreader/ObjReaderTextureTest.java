package com.cgvsu.ui.objreader;


import com.cgvsu.original.vector.Vector2f;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ObjReaderTextureTest {
    @Test
    public void testParseVertex2f01() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.02"));
        Vector2f result = ObjReader.parseTextureVertex(wordsInLineWithoutToken, 5);
        Vector2f expectedResult = new Vector2f(1.01f, 1.02f);
        Assertions.assertTrue(result.x == expectedResult.x && result.y == expectedResult.y);
    }

    @Test
    public void testParseVertex2f02() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.03"));
        Vector2f result = ObjReader.parseTextureVertex(wordsInLineWithoutToken, 5);
        Vector2f expectedResult = new Vector2f(1.01f, 1.10f);
        Assertions.assertNotEquals(result, expectedResult);
    }

    @Test
    public void testParseVertex2f03() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("ab", "o"));
        try {
            ObjReader.parseTextureVertex(wordsInLineWithoutToken, 10);
            Assertions.fail();
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Failed to parse float value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseVertex2f04() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(List.of("1.0"));
        try {
            ObjReader.parseTextureVertex(wordsInLineWithoutToken, 10);
            Assertions.fail();
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too few texture vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseVertex2f05() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "1.1", "1.2"));
        try {
            ObjReader.parseTextureVertex(wordsInLineWithoutToken, 10);
            Assertions.fail();
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too much texture vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

}
