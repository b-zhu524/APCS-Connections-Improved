package org.apcs.model;


import java.util.*;

/**
 * represents the information that changes throughout each game
 */
public class GameStatus
{
    private Set<String> clickedWords;
    private GameBoardData gameBoardData;
    private int numMistakes;
    private ArrayList<ArrayList<Category>> turnsRecord;
    private GameModel model;


    /**
     *
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
     * getter method for GameBoardData
     * @return gameBoardData - contains the game's information for the GameBoard to display
     */
   public GameBoardData getGameBoardData()
    {
        return gameBoardData;
    }

    /**
     * getter method for clickedWords
     * @return clickedWords - the set of the words that are currently clicked
     */
    public Set<String> getClickedWords()
    {
        return clickedWords;
    }


    /**
     * getter method for numMistakes
     * @return numMistakes - the current number of mistakes in the game
     */
    public int getNumMistakes()
    {
        return numMistakes;
    }

    /**
     * getter method for mistakesRecord
     * @return turnsRecord - the arraylist for all submissions in a game by four category classes in each entry
     * each category represents the category a word belongs to
     * meant to be used at the end of the game so the user can ses their turns
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
     * called when submit is clicked
     * goes through clicked words and adds an entry to TurnsRecord
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
     * increases the number of mistakes by one
     */
    public void updateMistakes()
    {
        numMistakes++;
    }


    /**
     * adds a clicked word
     * @param word - word to be added
     */
    public void addClicked(String word)
    {
        clickedWords.add(word);
    }

    /**
     * removes a clicked word. represents unclicking a word
     * @param word - word to be removed
     */
    public void removeClicked(String word)
    {
        clickedWords.remove(word);
    }

    /**
     * removes (unclicks) all clicked words
     */
    public void removeAllClicked()
    {
        clickedWords.clear();
    }

}
