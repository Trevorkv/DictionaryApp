package diction;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Class: DictionaryApp
 * @author Trevor
 */
public class DictionaryApp {
 
    
    public static void main(String args[])
    {
        Dictionary test = new Dictionary();
        promptUser(new String(), "Hello World");
        test.loadWordsFromFile("src/data/Dictionary.txt", ",");
        System.out.println(test.toString());
    }
    
    /**
     * Method: Prompts the user and returns the user input as a String
     * @param var
     * @param prompt
     * @return String
     */
    public static String promptUser(String var, String prompt)
    {
        System.out.println(prompt);
        var = readInput();
        return var;
    }
    
    
    /**
     * Method: readInput
     * Description: Returns an input string entered by the user
     * @return String
     */
    public static String readInput()
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String ret = null;
        
        try 
        {
            ret = bf.readLine();
        } 
        catch (IOException ex) 
        {
            System.out.println(ex + " Failed to read input");
        }
        
        return ret;
    }
    
}//EOC
