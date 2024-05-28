package org.apcs.view;


import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Extension of JPanel. Contains getter methods for the buttons shuffle, deselect all, submit, and new game.
 * It is formatted so that buttons can be next to each other.
 * It is also formatted so that there are two modes: one where the panel contains shuffle, deselect all, and submit,
 * and another where the panel contains only the new game button.
 * @author Bolang Zhu
 */
public class BottomPanel extends JPanel
{
    private final BottomButton shuffle;
    private final BottomButton deselectAll;
    private final BottomButton submit;
    private final BottomButton newGame;

    /**
     * Initializes the buttons shuffle, deselectAll, submit, and newGame.
     * Initially makes submit and deselectAll unavailable and hides the new game button.
     * Adds a BoxLayout to the panel.
     */
    public BottomPanel()
    {
        super();

        shuffle = new BottomButton("Shuffle");
        deselectAll = new BottomButton("Deselect All");
        submit = new BottomButton("Submit");
        newGame = new BottomButton("New Game");

        submit.setEnabled(false);
        deselectAll.setEnabled(false);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        addAllButtons(false);
    }

    /**
     * Getter method for the BottomButton shuffle
     * @return shuffle - BottomButton that shuffles the words
     */
    public BottomButton getShuffle()
    {
        return shuffle;
    }

    /**
     * Getter method for BottomButton deselectAll
     * @return deselectAll - BottomButton that deselects all words
     */
    public BottomButton getDeselectAll()
    {
        return deselectAll;
    }

    /**
     * Getter method for BottomButton submit
     * @return submit - BottomButton that submits four words
     */
    public BottomButton getSubmit()
    {
        return submit;
    }


    /**
     * Removes every button in bottom panel and adds buttons accordingly.
     * If it is the end of the game, the only thing added is the newGame button.
     * Otherwise, shuffle, deselect all, and submit are added to the BottomPanel.
     * @param endGame - if it is the end of the game, or if the player can continue playing
     */
    public void addAllButtons(boolean endGame)
    {
        this.removeAll();
        if (endGame)
        {
            addButton(newGame);
        }
        else
        {
            addButton(shuffle);
            addButton(deselectAll);
            addButton(submit);
        }
        this.add(Box.createHorizontalStrut(20));
    }

    /**
     * Adds a button to the bottom panel
     * @param button - BottomButton to be added
     */
    private void addButton(BottomButton button)
    {
        this.add(button);
    }

    /**
     * Adds an ActionListener to the submit button
     * @param listener - ActionListener for the submit button
     */
    public void setSubmitActionListener(ActionListener listener)
    {
        submit.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the shuffle button
     * @param listener - ActionListener for the shuffle button
     */
    public void setShuffleActionListener(ActionListener listener)
    {
        shuffle.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the deselect all button
     * @param listener - ActionListener for the deselect all button
     */
    public void setDeselectAllActionListener(ActionListener listener)
    {
        deselectAll.addActionListener(listener);
    }

    /**
     * Adds an action listener for the new game button
     * @param listener - ActionListener for the new game button
     */
    public void setNewGameActionListener(ActionListener listener)
    {
        newGame.addActionListener(listener);
    }
}
