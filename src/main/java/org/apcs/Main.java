package org.apcs;

import org.apcs.controller.*;
import org.apcs.model.*;
import org.apcs.view.*;
import org.apcs.service.*;


/**
 * This is a clone of the Connections game from New York Times.
 * It is run from the desktop and uses ChatGPT to generate words and categories.
 */
public class Main
{
    /**
     * Main method for game.
     * initializes model, view, controller, and action listeners for each button
     */
    public static void main(String[] args)
    {

        ChatGPTRequests requests = new ChatGPTRequests();
        GameModel model = requests.getGameModel();

        GameView view = new GameView(model);    // calling this initializes the game

        GameController controller = new GameController(model, view);
        view.addWordButtonActionListener(controller.getWordButtonActionListener());
        view.addShuffleActionListener(controller.getShuffleActionListener());
        view.addSubmitActionListener(controller.getSubmitButtonActionListener());
        view.addDeselectAllActionListener(controller.getDeselectAllActionListener());
    }
}
