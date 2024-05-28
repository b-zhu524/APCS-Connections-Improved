package org.apcs.controller;

import org.apcs.model.*;
import org.apcs.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * represents the action listener for the word buttons
 */
public class WordButtonActionListener implements ActionListener
{
    GameController controller;

    /**
     * Constructor for WordButtonActionListener. Allows the class to access Model and View
     * @param gameController - the controller for the project.
     */
    public WordButtonActionListener(GameController gameController)
    {
        controller = gameController;
    }


    /**
     * Implementation of ActionPerformed abstract class from ActionListener.
     * Selects and de-selects buttons based on the clicked set from GameStatus.
     * updates the clicked set in the game's GameStatus
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
