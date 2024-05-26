package org.apcs.model;

import org.apcs.view.MistakesPanel;

import java.util.*;

public class GameStatus
{
    private final int COL = 4;
    private Set<String> clickedWords;
    private List<String> remainingWords;    // Initially 16 Words

    private int numRowsSolved;
    private int numMistakes;
    private ArrayList<ArrayList<Category>> mistakesRecord;


    public GameStatus(List<String> words)
    {
        clickedWords = new HashSet<>();
        numRowsSolved = 0;
        numMistakes = 0;

        mistakesRecord = new ArrayList<>();
    }

    // GETTERS

    public int getNumCols()
    {
        return COL;
    }

    public Set<String> getClickedWords()
    {
        return clickedWords;
    }

    public int getNumClicked()
    {
        return clickedWords.size();
    }

    public List<String> getRemainingWords()
    {
        return remainingWords;
    }

    public int getNumRowsSolved()
    {
        return numRowsSolved;
    }

    public int getNumMistakes()
    {
        return numMistakes;
    }

    public ArrayList<ArrayList<Category>> getMistakesRecord()
    {
        return mistakesRecord;
    }

    public String getWord(int row, int col)
    {
        int index = row * COL + col - numRowsSolved * COL;
        if ( row < numRowsSolved || index < 0 || index >= remainingWords.size() )
        {
            // exception
            return null;
        }

        return remainingWords.get(index);
    }


    // SETTERS
    public void updateTurn(ArrayList<Category> mistakeCat)
    {
        mistakesRecord.add(mistakeCat);
    }

    public void updateMistakes()
    {
        numMistakes++;
    }

    public void addClicked(String word)
    {
        clickedWords.add(word);
    }

    public void removeClicked(String word)
    {
        clickedWords.remove(word);
    }

    public void removeAllClicked()
    {
        clickedWords.clear();
    }


    /**
     * This is called only when the user input is correct.
     * @param toRemove
     */
    public void removeRemainingWords(Set<String> toRemove)
    {
        List<String> removedWords = new ArrayList<>();

        for ( String word : remainingWords )
        {
            if ( !toRemove.contains(word) )
            {
                removedWords.add(word);
            }
        }

        remainingWords = removedWords;
    }
}
