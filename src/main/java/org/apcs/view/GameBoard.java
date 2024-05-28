package org.apcs.view;


import org.apcs.model.Category;
import org.apcs.model.GameStatus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Represents the 4x4 container grid of WordButtons.
 * Contains four rows of JPanels (GameRows) that each have four words in them.
 * @author Bolang Zhu
 */
public class GameBoard extends JPanel
{
    private List<WordButton> wordButtonList;

    /**
     * constructor for GameBoard
     * sets the size of the grid and initializes wordButtonList to an empty list
     */
    public GameBoard()
    {
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setBorder(new EmptyBorder(40, 20, 100, 20));
        wordButtonList = new ArrayList<>();
    }

    /**
     * getter method for wordButtonList
     * @return wordButtonList - list of buttons
     */
    public List<WordButton> getWordButtonList()
    {
        return wordButtonList;
    }

    /**
     * deselects all buttons in wordButtonList
     */
    public void deselectAll()
    {
        for (WordButton button : wordButtonList)
        {
            button.unclickButton();
        }
    }

    /**
     * adds a GameRow to the layout
     * @param row - GameRow to add to the layout
     */
    public void addRow(GameRow row)
    {
        super.add(row);
    }

    /**
     * adds a label to the layout
     * called whenever a category is solved
     * @param label - GameLabel to add
     */
    public void addLabel(GameLabel label)
    {
        super.add(label);
    }

    /**
     * adds ActionListeners for WordButton
     * @param listener - ActionListener for WordButton
     */
    public void addWordButtonActionListeners(ActionListener listener)
    {
        for (WordButton button : wordButtonList)
        {
            button.addActionListener(listener);
        }
    }

    /**
     * clears the board and re-makes the board based on GameBoard data in status
     * it starts with GameLabels of solved categories, then GameRows of unsolved words
     * called whenever a row is solved or the board is shuffled
     * @param status - the game's GameStatus
     */
    public void updateBoard(GameStatus status)
    {
        // clears the board
        this.removeAll();
        wordButtonList = new ArrayList<>();

        int rows = status.getGameBoardData().numRows();
        List<Category> categories = status.getGameBoardData().getSolvedCategories();
        List<String> words = status.getGameBoardData().getRemainingWords();

        for (Category cat : categories)
        {
            GameRow row = new GameRow();
            row.add(new GameLabel(cat));
            addRow(row);
            this.add(Box.createVerticalStrut(10));
        }

        int cnt = 0;
        for ( int i=0; i<rows; i++ )
        {
            GameRow row = new GameRow();
            for ( int j=0; j<4; j++ )
            {
                WordButton b = new WordButton(words.get(cnt));
                String word = b.getText();
                if (status.getClickedWords().contains(word))
                {
                    b.clickButton();
                }
                wordButtonList.add(b);
                row.add(b);
                cnt++;
            }
            addRow(row);

            this.add(Box.createVerticalStrut(10));
        }

        repaint();
        revalidate();
    }
}
