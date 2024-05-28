package org.apcs.view;


import javax.swing.*;


/**
 * represents the main container for the GUI.
 * the frame contains the GamePanel, which contains GameBoard (words), mistakes panel, and settings panel
 * @author Bolang Zhu
 */
public class GameFrame extends JFrame
{
    /**
     * constructor for GameFrame
     * initializes width to 800 and height to 680, sets title, and allows the user to exit
     */
    public GameFrame()
    {
        super();
        this.setSize(800, 680);
        this.setTitle("Create four groups of four!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
