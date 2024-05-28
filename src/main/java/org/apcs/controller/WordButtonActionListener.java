package org.apcs.controller;

import org.apcs.model.*;
import org.apcs.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * An implementation of ActionListener.
 * The action listener is used by WordButton objects.
 * @author Bolang Zhu
 */
public class WordButtonActionListener implements ActionListener
{
    /**
     * The controller for the game.
     */
    GameController controller;

    /**
     * Constructor for WordButtonActionListener.
     * @param gameController - the controller for the project.
     */
    public WordButtonActionListener(GameController gameController)
    {
        controller = gameController;
    }

    /**
     * Implementation of ActionPerformed method from ActionListener.
     * It is called when a WordButton object is pressed.
     * It checks if the button is already clicked.
     * If the button is already clicked, remove the word from clicked, unclick the word in view, disable the submit button,
     * and disable the deselect all button if there are no more clicked words.
     * Otherwise, if the number of clicked buttons is less than four, click the word in model, update view accordingly,
     * enable the deselect all button, and enable the submit button if the number of clicked words is four.
     * @param actionEvent the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        WordButton button = (WordButton) actionEvent.getSource();
        String word = button.getText();

        GameStatus status = controller.getModel().getGameStatus();
        Set<String> clicked = status.getClickedWords();

        BottomButton submitButton = controller.getView().getBottomPanel().getSubmit();
        BottomButton deselectButton = controller.getView().getBottomPanel().getDeselectAll();

        if (clicked.contains(word)) // the word is already clicked, and the user wants to un-click
        {
            status.removeClicked(word);
            button.unclickButton();

            // after running, the number of clicked items has to be less than four
            submitButton.setEnabled(false);

            if (clicked.isEmpty())
            {
                deselectButton.setEnabled(false);
            }
        }
        else if (clicked.size() < 4)    // the word has not been selected before the click
        {
            status.addClicked(word);
            button.clickButton();

            deselectButton.setEnabled(true);

            if (clicked.size() == 4)
            {
                submitButton.setEnabled(true);
            }
        }
    }
}
