package org.apcs.model;
import java.util.*;


/**
 * Represents the data for the GameBoard. The GameBoard uses this class to re-render.
 */
public class GameBoardData
{
    private int numRowsSolved;
    private List<Category> solvedCategories;    // solved categories
    private List<String> remainingWords;   // unsolved words

    /**
     * Constructor for GameBoardData.
     * It initializes the fields solvedCategories and remainingWords.
     * @param categories - the list of the categories that are solved
     * @param words - the list of words that are not solved. these do not include the words from the solved categories
     */
    public GameBoardData(List<Category> categories, List<String> words)
    {
        solvedCategories = categories;
        remainingWords = words;
    }

    /**
     * It shuffles the remaining words.
     * It is called when initializing a new game or when the "shuffle" button is pressed.
     */
    public void shuffleRemainingWords()
    {
        Collections.shuffle(remainingWords);
    }


    /**
     * It adds a category to solvedCategories
     * @param cat - the category to add
     */
    public void addSolvedCategory(Category cat)
    {
        solvedCategories.add(cat);
    }

    /**
     * Getter method for remainingWords.
     * @return remainingWords - the words that are not solved yet
     */
    public List<String> getRemainingWords()
    {
        return remainingWords;
    }

    /**
     * Getter method for solvedCategories.
     * @return solvedCategories - the list of solved categories
     */
    public List<Category> getSolvedCategories()
    {
        return solvedCategories;
    }

    /**
     * Gets the number of rows.
     * It throws a RuntimeException if the number of remaining words is not divisible by 4.
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
     * Gets the number of solved rows.
     * @return numRowsSolved - the number of rows solved
     */
    public int getNumRowsSolved()
    {
        return numRowsSolved;
    }

    /**
     * It represents solving a category in model.
     * It increases the number of rows solved by 1.
     * It adds toSolve to solvedCategories.
     * It removes the words in toSolve from remainingWords.
     * @param toSolve - the category to add
     */
    public void solveCategory(Category toSolve)
    {
        numRowsSolved++;
        solvedCategories.add(toSolve);
        String[] words = toSolve.getWords();

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
