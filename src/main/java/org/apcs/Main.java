package org.apcs;

import org.apcs.controller.*;
import org.apcs.model.*;
import org.apcs.view.*;
import org.apcs.service.*;


/**
 * This is a clone of the Connections game from New York Times.
 * It is run from the desktop and uses ChatGPT to generate words and categories.
 * There are four categories generated, and in each category, there are four words.
 * The player has four tries to categorize the words.
 * Unlike New York Times, this game has a New Game feature, where the player gets to play an unlimited number of times.
 * Java Swing is used to implement the GUI.
 *
 * @author Bolang Zhu
 */
public class Main
{
    /**
     * Main method for game.
     * Initializes model, view, controller, and action listeners for each button
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
