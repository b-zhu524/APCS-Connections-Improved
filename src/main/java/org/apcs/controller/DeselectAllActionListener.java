package org.apcs.controller;

import org.apcs.model.*;
import org.apcs.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * represents the ActionListener for the DeselectAll button
 * @author Bolang Zhu
 */
public class DeselectAllActionListener implements ActionListener
{
    GameController controller;

    /**
     * constructor for DeselectAllActionListener
     * @param controller - GameController for the game
     */
    public DeselectAllActionListener(GameController controller)
    {
        this.controller = controller;
    }


    /**
     * called when the DeselectAll button is clicked
     * goes through every button in GameBoard and un-clicks every one
     * updates clicked set in GameStatus
     * makes the Submit and DeselectButton button unavailable after clicked
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

