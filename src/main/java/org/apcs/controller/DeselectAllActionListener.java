package org.apcs.controller;

import org.apcs.model.*;
import org.apcs.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An implementation of ActonListener. When the DeselectAll button is clicked, it clears the user's selection, and updates GameBoard accordingly.
 * @author Bolang Zhu
 */
public class DeselectAllActionListener implements ActionListener
{
    /**
     * The controller for the game.
     */
    private GameController controller;

    /**
     * Constructor for DeselectAllActionListener
     * @param controller - GameController for the game
     */
    public DeselectAllActionListener(GameController controller)
    {
        this.controller = controller;
    }


    /**
     * This is the implementation of ActionListener's actionPerformed Method. It is called when the DeselectAll button is clicked.
     * It clears the user's selected words in GameModel, and call GameBoard's deselect all method to update the GUI.
     * It also disables Submit and DeselectButton button.
     * @param e - the event from DeselectAll to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        GameStatus gameStatus = controller.getModel().getGameStatus();
        BottomButton deselectAllButton = (BottomButton) e.getSource();
        BottomButton submitButton = controller.getView().getBottomPanel().getSubmit();

        gameStatus.removeAllClicked();
        controller.getView().getGameBoard().deselectAll();
        deselectAllButton.setEnabled(false);
        submitButton.setEnabled(false);
    }
}

