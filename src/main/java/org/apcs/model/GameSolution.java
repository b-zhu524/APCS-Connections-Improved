package org.apcs.model;

import java.util.*;


/**
 * represents the answer key for the game, and has methods to verify the answer
 */
public class GameSolution
{
    private final Map<String, Category> answer = new HashMap<>(); // <Word, Category>

    /**
     * Adds a category into the answer key.
     * Each of the four words are their own keys, and their value is the category name
     * @param cat - the category of the words to add
     */
    public void add(Category cat)
    {
        String[] catWords = cat.getWords();

        for ( String word : catWords )
        {
            answer.put(word, cat);
        }
    }

    /**
     * getter method for answer
     * @return answer - the Map of <Word, Category> for each word of the game
     */
    public Map<String, Category> getAnswer()
    {
        return answer;
    }

    /**
     * checks if all strings in words belong to the same category
     * @param words - collection of words to verify
     * @return true if all words belong to the same category. false otherwise
     */
    public boolean allRight(Collection<String> words)
    {
        Category currCat = null;
        for ( String word : words )
        {
            if ( !answer.containsKey(word) )
            {
                // exception
                throw new RuntimeException("word is not in solution list");
            }

            if ( currCat != null && !answer.get(word).equals(currCat) )
            {
                return false;
            }

            currCat = answer.get(word);
        }

        return true;
    }


    /**
     * Checks if all but one word in words belong to the same category (all right, except for one).
     * @param words - collection of words to verify
     * @return true of all but one word in words belong to the same cateogry. false otherwise
     */
    public boolean oneAway(Collection<String> words)
    {
        int numWrong = 0;
        Category currCat = null;
        for ( String word : words )
        {
            if ( !answer.containsKey(word) )
            {
                // exception
                return false;
            }

            if ( currCat != null && !answer.get(word).equals(currCat) )
            {
                numWrong++;
            }

            currCat = answer.get(word);
        }

        return numWrong == 1;
    }
}
