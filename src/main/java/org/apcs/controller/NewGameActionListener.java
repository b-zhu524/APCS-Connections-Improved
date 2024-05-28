package org.apcs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apcs.model.*;
import org.apcs.service.*;


/**
 * ActionListener for NewGame button
 */
public class NewGameActionListener implements ActionListener
{
    GameController controller;

    /**
     * Constructor for the ActionListener
     * @param controller - GameController for the game
     */
    public NewGameActionListener(GameController controller)
    {
        this.controller = controller;
    }

    /**
     * called whenever NewGame button is clicked
     * calls ChatGPTRequests to get a new GameModel
     * Re-Renders the GUI, including GameBoard and mistakes
     * removes itself from the BottomPanel and adds submit, deselectall, and shuffle back
     * @param e - the event from NewGame button to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // reset model (solution)
        ChatGPTRequests requests = new ChatGPTRequests();
        GameModel newModel = requests.getGameModel();
        controller.setModel(newModel);

        // reset bottom panel (submit, deselect, shuffle)
        controller.getView().getBottomPanel().addAllButtons(false);


        // update mistakes count
        controller.getView().getGameBoard().updateBoard(newModel.getGameStatus());
        controller.getView().getMistakesPanel().setCnt(4);


        // add ActionListeners
        // words
        controller.getView().addWordButtonActionListener(controller.getWordButtonActionListener());
        // shuffle
        controller.getView().addShuffleActionListener(controller.getShuffleActionListener());
        // deselect
        controller.getView().addDeselectAllActionListener(controller.getDeselectAllActionListener());
        //submit
        controller.getView().addSubmitActionListener(controller.getSubmitButtonActionListener());
    }
}
