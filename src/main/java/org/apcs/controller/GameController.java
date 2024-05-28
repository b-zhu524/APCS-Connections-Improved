package org.apcs.controller;

import org.apcs.model.*;
import org.apcs.view.*;


/**
 * This class has getter methods for model, view, and every ActionListener for the buttons.
 * This is meant to be called by methods in the model and view packages, and to allow the ActionListeners to access
 * model and view classes.
 *
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
     * sets current model to new GameModel
     * called whenever a new game is rendered.
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
     * creates a new action listener for the submit button
     * @return ActionListener - new action listener
     */
    public SubmitButtonActionListener getSubmitButtonActionListener()
    {
        return new SubmitButtonActionListener(this);
    }

    /**
     * creates a new action listener for the shuffle button
     * @return ActionListener - new action listener
     */
    public ShuffleActionListener getShuffleActionListener()
    {
        return new ShuffleActionListener(this);
    }

    /**
     * creates a new action listener for the deselect all button
     * @return ActionListener - new ActionListener
     */
    public DeselectAllActionListener getDeselectAllActionListener()
    {
        return new DeselectAllActionListener(this);
    }

    /**
     * creates a new action listener for the new game button
     * @return ActionListener - new ActionListener
     */
    public NewGameActionListener getNewGameActionListener()
    {
        return new NewGameActionListener(this);
    }

}
