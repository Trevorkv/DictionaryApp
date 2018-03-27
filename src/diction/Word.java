package diction;

/**
 * Class: Word
 * Description: A Model of a word that contains its definition, part of speech,
 *              origin, etc
 * @author Trevor
 */
public class Word {
    private String word; 
    private String def;
    private String partOfSpeech;
    
    /**
     * Default Constructor
     */
    public Word()
    {
        word = new String();
        def = new String();
        partOfSpeech  = new String();
    }
       
    
    /**
     * Constructor
     * @param word
     * @param def
     * @param partOfSpeech 
     */
    public Word(String word, String def, String partOfSpeech) {
        this.word = word;
        this.def = def;
        this.partOfSpeech = partOfSpeech;
    }

    
    /**
     * Method: getWord
     * Description: Returns the word property of type String
     * @return word
     */
    public String getWord() {
        return word;
    }

    
    /**
     * Method: getDef
     * Description: Returns the def property of type String
     * @return def
     */
    public String getDef() {
        return def;
    }

    
    /**
     * Method: getPartOfSpeech
     * Description: Returns the partOfSpeech property of type String
     * @return 
     */
    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    
    /**
     * Method: setWord
     * Description: Assigns the value of the given param to the word property
     * @param word 
     */
    public void setWord(String word) {
        this.word = word;
    }

    
    /**
     * Method: setDef
     * Description: Assigns the value of the given param to the def property
     * @param def
     */
    public void setDef(String def) {
        this.def = def;
    }

    
    /**
     * Method: setPartOfSpeech
     * Description: Assigns the value of the given param to the partOfSpeech
     *              property
     * @param partOfSpeech 
     */
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    
    /**
     * Method: toString
     * Description: Returns the string representation of the instance
     *
     */
    @Override
    public String toString() {
        return "Word{" + "word=" + word + ", def=" + def + ", partOfSpeech=" + partOfSpeech + '}';
    }
  
}//EOC
