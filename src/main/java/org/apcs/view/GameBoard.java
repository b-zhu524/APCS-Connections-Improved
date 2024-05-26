package org.apcs.view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Represents the 4x4 container grid of WordButtons.
 * Contains four rows of JPanels (GameRows) that each have four words in them.
 * @author Bolang Zhu
 */
public class GameBoard extends JPanel
{
    public GameBoard()
    {
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(60, 20, 100, 20));
    }

    public void addRow(JPanel row)
    {
        super.add(row);
    }
}
