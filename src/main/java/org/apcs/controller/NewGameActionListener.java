package org.apcs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apcs.model.*;
import org.apcs.service.*;


/**
 * An implementation of ActonListener. When the game is over, where the user loses or wins, a NewButton appears.
 * Clicking it will generate a new game with new words.
 * @author Bolang Zhu
 */
public class NewGameActionListener implements ActionListener
{
    /**
     * The controller for the game.
     */
    GameController controller;

    /**
     * Constructor for the ActionListener
     * @param controller - the GameController for the game
     */
    public NewGameActionListener(GameController controller)
    {
        this.controller = controller;
    }

    /**
     * This is the implementation of ActionListener's actionPerformed method.
     * It is called whenever NewGame button is clicked.
     * It calls ChatGPTRequests to generate a new GameModel.
     * It re-renders the GUI's GameBoard and mistakes.
     * It removes itself from the BottomPanel and adds submit, de-selectall, and shuffle back.
     * It adds action listeners for every button by calling controller's methods.
     * @param e - the event from NewGame button to be processed.
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
