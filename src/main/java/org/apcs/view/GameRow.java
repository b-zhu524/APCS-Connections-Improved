package org.apcs.view;

import javax.swing.*;
import java.awt.*;

public class GameRow extends JPanel
{
    public GameRow()
    {
        super();
        this.setLayout(new GridLayout(1, 4));
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
