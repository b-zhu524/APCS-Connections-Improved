package org.apcs.view;


import javax.swing.*;

/**
 * Extension of JPanel. Includes the GameBoard, MistakesPanel, and BottomPanel on top of one another.
 * It is placed inside a GameFrame.
 */
public class GamePanel extends JPanel
{
    /**
     * Constructor for the GamePanel class.
     * Initializes the layout as a BoxLayout with orientation Y_AXIS.
     */
    public GamePanel()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
