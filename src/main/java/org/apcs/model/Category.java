package org.apcs.model;


/**
 * Represents a category of words.
 */
public class Category
{
    private String[] memberWords;   // supposed to be an array of four
    private String catName;
    private int difficulty;

    /**
     * Constructor for a Category class.
     * @param words - four words in the category
     * @param catName - name of the category
     * @param difficulty - integer between 0 - 3 inclusive (0 being easy, and 3 being hardest)
     */
    public Category(String[] words, String catName, int difficulty)
    {
        memberWords = words;
        this.catName = catName;
        this.difficulty = difficulty;
    }

    /**
     * Getter method for memberWords.
     * @return memberWords - words in the category
     */
    public String[] getWords()
    {
        return memberWords;
    }


    /**
     * Getter method for catName.
     * @return catName - the name of the category
     */
    public String getCatName()
    {
        return catName;
    }


    /**
     * Gives the words to output to a GameLabel.
     * @return member words in string format "{word1}, {word2}, {word3}, {word4}"
     */
    public String getCatInfo()
    {
        StringBuilder stringWords = new StringBuilder();

        for ( int i=0; i<memberWords.length; i++ )
        {
            String word = memberWords[i];

            stringWords.append(word);
            if ( i < memberWords.length-1 )
            {
                stringWords.append(", ");
            }
        }

        return stringWords.toString();
    }


    /**
     * Getter method for attribute, "difficulty".
     * @return - difficulty
     */
    public int getDifficulty()
    {
        return difficulty;
    }
}
