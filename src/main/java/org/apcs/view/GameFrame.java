package org.apcs.view;


import javax.swing.*;
import java.awt.*;

/**
 * represents the main container for the GUI.
 * the frame contains the GamePanel, which contains GameBoard (words), mistakes panel, and settings panel
 * @author Bolang Zhu
 */
public class GameFrame extends JFrame
{
    public GameFrame()
    {
        super();
        this.setSize(800, 680);
        this.setTitle("Create four groups of four!");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setBackground(Color color)
    {
        super.getContentPane().setBackground(color);
    }
}
