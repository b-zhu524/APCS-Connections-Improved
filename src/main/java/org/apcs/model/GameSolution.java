package org.apcs.model;

import java.util.*;

public class GameSolution
{
    private final Map<String, Category> answer = new HashMap<>(); // <Word, Category>

    /**
     *
     * @param cat
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
     *
     * @return
     */
    public Map<String, Category> getAnswer()
    {
        return answer;
    }

    /**
     *
     * @param words
     * @return
     */
    public boolean allRight(Collection<String> words)
    {
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
                return false;
            }

            currCat = answer.get(word);
        }

        return true;
    }


    public boolean oneAway(Set<String> words)
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
