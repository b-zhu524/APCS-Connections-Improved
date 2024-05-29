package org.apcs.view;


import org.apcs.model.Category;
import org.apcs.model.GameStatus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Extension of JPanel. Represents the 4x4 container grid of WordButtons.
 * Contains four rows of JPanels (GameRows) that each have four words in them.
 * @author Bolang Zhu
 */
public class GameBoard extends JPanel
{
    private Set<WordButton> wordButtonList;

    /**
     * Constructor for GameBoard.
     * It sets the size of the grid and initializes wordButtonList to an empty list.
     */
    public GameBoard()
    {
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setBorder(new EmptyBorder(40, 20, 100, 20));
        wordButtonList = new HashSet<>();
    }

    /**
     * Getter method for wordButtonList
     * @return wordButtonList - list of buttons
     */
    public Set<WordButton> getWordButtonList()
    {
        return wordButtonList;
    }

    /**
     * Deselects all buttons in wordButtonList
     */
    public void deselectAll()
    {
        for (WordButton button : wordButtonList)
        {
            button.unclickButton();
        }
    }

    /**
     * Adds a GameRow to the layout
     * @param row - GameRow to add to the layout
     */
    public void addRow(GameRow row)
    {
        super.add(row);
    }

    /**
     * Adds a label to the layout.
     * It is called whenever a category is solved.
     * @param label - GameLabel to add
     */
    public void addLabel(GameLabel label)
    {
        super.add(label);
    }

    /**
     * Adds ActionListeners for WordButton.
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
     * Clears the board and re-renders the board based on GameBoard data in status.
     * It starts with GameLabels of solved categories, and adds them to the top rows.
     * Then it adds all the remaining words in the remaining rows.
     * This is called whenever a board needs to be re-rendered (row is solved or the board is shuffled).
     * It adds a Vertical Strut of height 10 after every row.
     * It also repaints and revalidates the GameBoard.
     * @param status - the game's GameStatus
     */
    public void updateBoard(GameStatus status)
    {
        // clears the board
        this.removeAll();
        wordButtonList = new HashSet<>();

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
