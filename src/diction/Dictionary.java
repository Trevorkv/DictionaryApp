
package diction;

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
     * Method: addWord
     * Description: Adds the argument to the ArrayList of type Word
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
                if(words.get(i).getWord().compareTo(word.getWord()) > 0)
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
    
    
}//EOC
