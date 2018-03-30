
package diction;

import java.io.*;
import java.util.*;

/**
 * CLass: Dictionary
 * Description: Model of a word dictionary that contains words along with their 
 *              definitions (Parts of speech, Meaning, etc)
 * @author Trevor
 */
public class Dictionary {
    private ArrayList<Word> words;
    
    
    //functionality for a collection of words
    //search, edit, add, delete

    /**
     * Default COnstructor
     */
    public Dictionary()
    {
        words = new ArrayList<>();
    }
    
    
    /**
     * Constructor
     * @param words 
     */
    public Dictionary(ArrayList<Word> words) {
        this.words = words;
    }
    
    /**
     * Method: getWord
     * Description: Returns a word data type that matches the given argument 
     * @param word
     * @return Word
     */
    public Word getWord(String word)
    {
        int index = -1;
        int min = 0;
        int max = words.size();
        int mid = max/2;
        
        while(true && min != mid)
        {
            if(words.get(mid).getWord().compareToIgnoreCase(word) == 0)
            {
                index = min;
                break;
            }
            else if(words.get(mid).getWord().compareToIgnoreCase(word) < 0)
            {
                min = mid;
                mid = (max + min)/2;
            }
            else if(words.get(mid).getWord().compareToIgnoreCase(word) > 0)
            {
                max = mid;
                mid = (max + min)/2;
            }
        }
        
        return index == -1 ? null : words.get(index);
    }
    
    
    /**
     * Method: getworldIndex
     * Description: Returns the index of the element from the ArrayList of Words
     *              that matches the given argument
     * @param word
     * @return 
     */
    public int getWordIndex(String word)
    {
        int index = -1;
        int min = 0;
        int max = words.size();
        int mid = max/2;
        
        while(true && min != mid)
        {
            if(words.get(mid).getWord().compareToIgnoreCase(word) == 0)
            {
                index = min;
                break;
            }
            else if(words.get(mid).getWord().compareToIgnoreCase(word) < 0)
            {
                min = mid;
                mid = (max + min)/2;
            }
            else if(words.get(mid).getWord().compareToIgnoreCase(word) > 0)
            {
                max = mid;
                mid = (max + min)/2;
            }
        }
        
        return index;
    }
    
    
    /**
     * Method: addWord
     * Description: Adds the argument to the ArrayList of type Word 
     *              lexicographically
     * @param word
     * @return boolean
     */
    public boolean addWord(Word word)
    {
        boolean ret = false;
        if(words.isEmpty())
            ret = words.add(word);
        else
            for(int i = 0; i < words.size(); i++)
            {
                if(words.get(i).getWord().compareToIgnoreCase(word.getWord()) > 0)
                {
                    words.add(i, word);
                    ret = true;
                    break;
                }
                else if(i == words.size() - 1)
                {
                        ret = words.add(word);
                        break;
                }
            }	

        return ret;
    }
    
    
    /**
     * Method: deleteWord
     * Description: Deletes the word that matches the given argument. Returns 
     *              true if deleted successfully
     * @param word
     * @return boolean
     */
    public boolean deleteWord(String word)
    {
        boolean ret = false;
        Word key = getWord(word);
        
        if(key != null)
        {
            ret = words.remove(key);
        }
        
        return ret;
    }
    
    
    /**
     * Method: editWord
     * @param word
     * @param newWord
     * @param def
     * @param partOfSpeech 
     */
    public void editWord(String word, String newWord, String def, String partOfSpeech)
    {
        int index = getWordIndex(word);
        words.get(index).setWord(newWord == null ? word : newWord);
        words.get(index).setDef(def);
        words.get(index).setPartOfSpeech(partOfSpeech);
    }
    
    
    /**
     * Method: loadWordsFromFile
     * Description: Populates the ArrayList of words and their data from the 
     *              given file. The String tokenList is a sting containing the
     *              characters used to separate each data (see StringTokenizer)
     * @param filePath
     * @param tokenList 
     */
    public void loadWordsFromFile(String filePath, String tokenList)
    {
        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(filePath));
            String line = bf.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line, tokenList);
            Word word;
            
            while(line != null)
            {
                word = new Word(tokenizer.nextToken(),tokenizer.nextToken(),
                    tokenizer.nextToken());

                this.addWord(word);
                line = bf.readLine();
                tokenizer = new StringTokenizer(line == null ? "" : line, tokenList);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e + " Cannot Find File");
        }
        catch(IOException e)
        {
            System.out.println(e + " Failure Reading File");
        }
    }
    
    
    /**
     * Method: toString
     * Description: Returns the string representation of the instance data
     * @return String
     */
    @Override
    public String toString()
    {
        String ret = new String();
        
        for(int i = 0; i < words.size(); i++)
        {
            ret += words.get(i).toString() + "\n";
        }
        
        return ret;
    }
    
}//EOC
