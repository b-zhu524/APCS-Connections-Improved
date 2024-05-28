package org.apcs.view;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a row in a GameBoard. Each row contains four words.
 */
public class GameRow extends JPanel
{
    /**
     * Constructor for GameRow.
     * It initializes and the layout as a 1 x 4 Gridlayout
     * Adds a vertical gap between words
     */
    public GameRow()
    {
        super();
        GridLayout layout = new GridLayout(1, 4);
        layout.setHgap(10); // Creates vertical gap in between words
        this.setLayout(layout);
    }
}
