package org.apcs.model;


import java.util.*;

/**
 * Represents the information that changes throughout each game
 */
public class GameStatus
{
    private Set<String> clickedWords;
    private GameBoardData gameBoardData;
    private int numMistakes;
    private ArrayList<ArrayList<Category>> turnsRecord;
    private GameModel model;


    /**
     * The constructor for Status.
     * It initializes model and clickedWords.
     * It initializes numMistakes as 0, turnsRecord as a new ArrayList,
     * and gameBoardData as an empty ArrayList and all 16 words.
     * @param model - the game's GameModel
     * @param words - the 16 words for the game
     */
    public GameStatus(GameModel model, List<String> words)
    {
        this.model = model;
        clickedWords = new HashSet<>();
        numMistakes = 0;
        turnsRecord = new ArrayList<>();

        gameBoardData = new GameBoardData(new ArrayList<>(), words);
    }

    /**
     * Getter method for GameBoardData
     * @return gameBoardData - contains the game's information for the GameBoard to display
     */
   public GameBoardData getGameBoardData()
    {
        return gameBoardData;
    }

    /**
     * Getter method for clickedWords
     * @return clickedWords - the set of the words that are currently clicked
     */
    public Set<String> getClickedWords()
    {
        return clickedWords;
    }


    /**
     * Getter method for numMistakes
     * @return numMistakes - the current number of mistakes in the game
     */
    public int getNumMistakes()
    {
        return numMistakes;
    }

    /**
     * Getter method for turnsRecord
     * @return turnsRecord - the arraylist for all submissions in a game by four category classes in each entry
     */
    public ArrayList<ArrayList<Category>> getTurnsRecord()
    {
        return turnsRecord;
    }


    /**
     * Gets category of the clicked words members. This is ONLY called when each word in clicked belongs to the same category.
     * @return category - category of words
     */
    public Category getClickedCat()
    {
        for (String word : clickedWords)
        {
            return model.getSolution().getAnswer().get(word);
        }

        // never reached
        return null;
    }


    /**
     * It goes through clicked words and adds an entry to TurnsRecord.
     * Called when submit is clicked
     */
    public void updateTurn()
    {
        ArrayList<Category> toAdd = new ArrayList<>();
        for (String word : clickedWords)
        {
            toAdd.add(model.getSolution().getAnswer().get(word));
        }
        turnsRecord.add(toAdd);
    }

    /**
     * It increases the number of mistakes by one.
     */
    public void updateMistakes()
    {
        numMistakes++;
    }


    /**
     * It adds a clicked word.
     * @param word - word to be added
     */
    public void addClicked(String word)
    {
        clickedWords.add(word);
    }

    /**
     * It removes a clicked word. It represents unclicking a word.
     * @param word - word to be removed
     */
    public void removeClicked(String word)
    {
        clickedWords.remove(word);
    }

    /**
     * It unclicks all clicked words
     */
    public void removeAllClicked()
    {
        clickedWords.clear();
    }

}
