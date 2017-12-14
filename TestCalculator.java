
package TestCases;

import java.util.*;

import java.io.*;
import java.text.*;
import org.junit.Test;
import org.junit.Assert;
import GPAdb.*;

import GPAcalculator.*;

public class TestCalculator
{
    CourseInfo currentCourse;

    @Test
    public void testCalculator()
    {
       float result;
       result = GPAconverter.getGPAforLetterGrade("A-");

       Assert.assertEquals(result, 3.7f, 0.02);
    }


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

   private Database db = null;

  /* @BeforeClass
   public void setupDB() {
       try {
           Parser parser = new GPAdb.Parser("sampledata.txt");
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       try {
           db = parser.readTranscriptFile();
       } catch (ParseException e) {
           e.printStackTrace();
       }
   }*/

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

       Assert.assertEquals(78, grade, 0.02);
   }


}
