package main;//TODO change "main" to your package name

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.junit.runner.*;
import org.junit.runners.*;

import main.Main;//TODO change import path of your main class

@RunWith(value=Parameterized.class)
public class Homework6Test {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	PrintStream o = System.out;
	PrintStream o2 = new PrintStream(outContent);
	@Parameterized.Parameters
    public static Collection<String[]> getParameters() {
        return Arrays.asList(
            new String[][] {//expect, input
            	{"0", "0 + 0"},
            	{"2", "1 + 1"},
            	{"0", "0 - 0"},
            	{"0", "-2 + 2"},
            	{"1", "1 - 0"},
            	{"579", "123 + 456"},
            	{"-333", "123 - 456"},
            	{"false", "123 > 456"},
            	{"true", "123 < 456"},
            	{"false", "123 = 456"},
            	{"true", "0 = 0"},
            	{"false", "0 < 0"},
            	{"false", "0 > 0"},
            	{"false", "0 < -1"},
            	{"true", "0 > -1"},
            	{"false", "0 = -1"},
            	{"199998", "99999 + 99999"},
            	{"0", "0 - 0 + 0 - 0 + 0 - 0"},
            	{"987654321", "-123456789 + 987654321 - -123456789"},
            	{"9876543210123456789876543210123456912", "9876543210123456789876543210123456789 + 123"},
            	{"9876543210123456789876543210123456666", "9876543210123456789876543210123456789 - 123"},
            	{"false", "-135792468123456789876543210123456789 < -1357924680123456789876543210123456789"},
            	{"true", "-135792468123456789876543210123456789 > -1357924680123456789876543210123456789"},
            	{"false", "-135792468123456789876543210123456789 = -1357924680123456789876543210123456789"},
            	{"3694", "12 + 3 + 4567 - 888"},
            	{"1", "1000 - 999"},
            	{"-8999", "1000 - 9999"},
            	{"997", "1000 - 3"},
            	{"-997", "3 - 1000"},
            	{"-1", "0 - 1"}
            }
        );
    }
    
    private String expected;
    private String input;
    
    public Homework6Test(String expected, String input) {
        this.expected = expected;
        this.input = input;
    }
    
    @Before
    public void setUpStreams() {
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(o2);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }

    @Test
    public void testMain() {

    	Main.main(null);//TODO change "Main" to your main class name
    	if(!expected.equals(outContent.toString())){
    		System.err.println("Question: " + input);
    		System.err.println("Corr: " + expected);
    		System.err.println("Your: " + outContent.toString() + "\n");
    	}
        assertEquals(expected, outContent.toString());
    	
    }
}
