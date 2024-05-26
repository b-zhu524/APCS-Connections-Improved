package org.apcs.model;

import java.util.*;


/**
 *
 */
public class Category
{
    private String[] memberWords;   // supposed to be an array of four
    private String catName;
    private int difficulty;


    /**
     * This constructor is used only for comparing words, where the catName and difficulty do not matter.
     * @param words
     */
    public Category(String[] words)
    {
        memberWords = words;
    }

    /**
     *
     * @param words
     * @param catName
     * @param difficulty
     */
    public Category(String[] words, String catName, int difficulty)
    {
        memberWords = words;
        this.catName = catName;
        this.difficulty = difficulty;
    }


    /**
     *
     * @return
     */
    public String[] getWords()
    {
        return memberWords;
    }


    /**
     *
     * @return
     */
    public String getCatName()
    {
        return catName;
    }


    /**
     *
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
     *
     * @return
     */
    public int getDifficulty()
    {
        return difficulty;
    }

    /**
     * This method sorts memberWords in alphabetical order.
     */
    public void sortWords()
    {
        Arrays.sort(memberWords);
    }
}
