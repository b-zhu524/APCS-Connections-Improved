package org.apcs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apcs.view.WordButton;

public class WordButtonActionListener implements ActionListener
{
    GameController controller;  // Allows the method to access Model and View

    /**
     * Constructor for WordButtonActionListener
     * @param gameController
     */
    public WordButtonActionListener(GameController gameController)
    {
        controller = gameController;
    }


    /**
     *
     * @param actionEvent the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        WordButton button = (WordButton) actionEvent.getSource();
    }
}
