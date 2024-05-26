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
     * This method initializes the ActionListener for a Word Button.
     * @return a new WordButtonActionListener that is able to access model and view
     */
    public WordButtonActionListener getWordButtonActionListener()
    {
        return new WordButtonActionListener(this);
    }

}
