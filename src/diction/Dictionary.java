
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
    
    
}//EOC
