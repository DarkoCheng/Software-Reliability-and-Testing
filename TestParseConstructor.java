package TestCases;
import java.util.*;
import java.io.*;
import java.text.*;
import org.junit.Test;
import org.junit.Assert;

import GPAcalculator.*;
import GPAdb.*;
import TextTokenizer.*;

public class TestParseConstructor {

    private TextTokenizer.WordExtractor tokenizer = null;
    private Parser parser = null;


    @Test
    public void TestWordExtractor() {
        try {
            tokenizer = new TextTokenizer.WordExtractor("sampledata.txt");
        } catch (FileNotFoundException e) {
            Assert.assertFalse("This statement failed to find a file", false);
        }

        Assert.assertNotNull("\"tokenizer\" should not be null", tokenizer);
    }

    @Test
    public void TestParseConstruct() {
        try {
            parser = new Parser("sampledata.txt");
        } catch(FileNotFoundException e) {
            Assert.assertFalse("TestParseConstruct fails deeper in path", false);
        }

        Assert.assertNotNull("\"parser\" should not be null", parser);
    }


}
