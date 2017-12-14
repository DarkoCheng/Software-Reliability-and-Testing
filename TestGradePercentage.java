package TestCases;

import java.util.*;
import java.io.*;
import java.text.*;
import org.junit.Test;
import org.junit.Assert;

import GPAcalculator.*;
import GPAdb.*;
import TextTokenizer.*;

public class TestGradePercentage {

    private Database db = null;

    @Test
    public void TestGrade() {
    	Parser parser = null;
    	
    	try {
            parser = new GPAdb.Parser("sampledata.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            db = parser.readTranscriptFile();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int grade = db.getCourseGradePercentageWithinTerm(0, 1);

        Assert.assertEquals(78, grade);
    }

}
