package org.apcs.view;


import javax.swing.*;

/**
 * represents panel to include the GameBoard, MistakesPanel, and BottomPanel
 */
public class GamePanel extends JPanel
{
    /**
     * constructor for the GamePanel class
     * sets up a BoxLayout to stack components vertically on top of one another
     */
    public GamePanel()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
