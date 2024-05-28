package org.apcs.view;

import javax.swing.*;
import java.awt.*;

public class GameRow extends JPanel
{
    public GameRow()
    {
        super();
        GridLayout layout = new GridLayout(1, 4);
        layout.setHgap(10); // Creates vertical gap in between words
        this.setLayout(layout);
    }

    private void setLayout(int rows, int cols)
    {
        super.setLayout(new GridLayout(rows, cols));
    }

    public void addWordButton(WordButton button)
    {
        super.add(button);
    }
}
