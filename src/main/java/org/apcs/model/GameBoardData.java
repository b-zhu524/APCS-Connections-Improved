package org.apcs.model;
import java.util.*;


/**
 * represents the data for the GameBoard. the GameBoard part of view uses this to render the board
 */
public class GameBoardData
{
    private final int COL = 4;
    private int numRowsSolved;
    private List<Category> solvedCategories;    // solved categories
    private List<String> remainingWords;   // unsolved words

    /**
     * constructor for GameBoardData
     * initializes solvedCategories and remainingWords
     * @param categories - the list of the categories that are solved
     * @param words - the list of words that are not solved. these do not include the words from the solved categories
     */
    public GameBoardData(List<Category> categories, List<String> words)
    {
        solvedCategories = categories;
        remainingWords = words;
    }

    /**
     * shuffles the remaining words
     * called when initializing a new game or when the "shuffle" button is pressed
     */
    public void shuffleRemainingWords()
    {
        Collections.shuffle(remainingWords);
    }


    /**
     * adds a category to solvedCategories
     * @param cat - the category to add
     */
    public void addSolvedCategory(Category cat)
    {
        solvedCategories.add(cat);
    }

    /**
     * getter method for remainingWords
     * @return remainingWords - the words that are not solved yet
     */
    public List<String> getRemainingWords()
    {
        return remainingWords;
    }

    /**
     * getter method for solvedCategories
     * @return solvedCategories - the list of solved categories
     */
    public List<Category> getSolvedCategories()
    {
        return solvedCategories;
    }

    /**
     * gets the number of rows, or the number of remaining categories
     * throws a RuntimeException if the number of remaining words is not divisible by 4
     * @return the number of remaining rows
     */
    public int numRows()
    {
        if ( remainingWords.size() % 4 != 0)
        {
            throw new RuntimeException("remaining words needs to be divisible by four");
        }

        return remainingWords.size() / 4;
    }

    /**
     * gets the number of solved rows
     * @return numRowsSolved - the number of rows solved
     */
    public int getNumRowsSolved()
    {
        return numRowsSolved;
    }

    /**
     * increases the number of rows solved by 1
     * adds toAdd to solvedCategories
     * removes the words in toAdd from remainingWords
     * @param toAdd - the category to add
     */
    public void solveCategory(Category toAdd)
    {
        numRowsSolved++;
        solvedCategories.add(toAdd);
        String[] words = toAdd.getWords();

        List<String> newWords = new ArrayList<>();
        for ( String word : remainingWords )
        {
            if (!Arrays.asList(words).contains(word))
            {
                newWords.add(word);
            }
        }
        remainingWords = newWords;
    }
}
