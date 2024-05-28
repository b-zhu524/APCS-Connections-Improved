package org.apcs.controller;

import org.apcs.model.*;
import org.apcs.view.*;


/**
 * This is the controller of the game. It holds GameModel and GameView, and creates action listeners, which updates the game's data and view.
 * @author Bolang Zhu
 */
public class GameController
{
    private GameModel model;
    private GameView view;

    /**
     * Constructor for the GameController
     * @param model - GameModel for the game.
     * @param view - GameView for the game.
     */
    public GameController(GameModel model, GameView view)
    {
        this.model = model;
        this.view = view;
    }


    /**
     * This is the getter method for model.
     * @return the model passed into GameController
     */
    public GameModel getModel()
    {
        return model;
    }

    /**
     * This is the getter method for view.
     * @return the view passed into GameController
     */
    public GameView getView()
    {
        return view;
    }

    /**
     * Sets gameModel.
     * It is called whenever a new game is started.
     * @param newModel - model to set
     */
    public void setModel(GameModel newModel)
    {
        model = newModel;
    }

    /**
     * This method initializes the ActionListener for a Word Button.
     * @return a new WordButtonActionListener that is able to access model and view
     */
    public WordButtonActionListener getWordButtonActionListener()
    {
        return new WordButtonActionListener(this);
    }

    /**
     * It creates a new action listener for the submit button.
     * @return ActionListener - the new action listener
     */
    public SubmitButtonActionListener getSubmitButtonActionListener()
    {
        return new SubmitButtonActionListener(this);
    }

    /**
     * It creates a new action listener for the shuffle button.
     * @return ActionListener - the new action listener
     */
    public ShuffleActionListener getShuffleActionListener()
    {
        return new ShuffleActionListener(this);
    }

    /**
     * It creates a new action listener for the deselect all button.
     * @return ActionListener - the new ActionListener
     */
    public DeselectAllActionListener getDeselectAllActionListener()
    {
        return new DeselectAllActionListener(this);
    }

    /**
     * It creates a new action listener for the new game button.
     * @return ActionListener - the new ActionListener
     */
    public NewGameActionListener getNewGameActionListener()
    {
        return new NewGameActionListener(this);
    }

}
