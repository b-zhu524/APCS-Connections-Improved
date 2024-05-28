package org.apcs.view;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

/**
 * represents the label that displays messages
 */
public class MessageLabel extends JLabel
{
    private boolean oneAway;

    /**
     * initializes the message to be empty
     */
    public MessageLabel()
    {
        super("", JLabel.CENTER);
        super.setPreferredSize(new Dimension(100, 20));
    }

    /**
     * changes the value of isOneAway
     * @param isOneAway - if the clicked items are one away
     */
    public void setOneAway(boolean isOneAway)
    {
        oneAway = isOneAway;
    }

    /**
     * changes the text to "One away!" if oneAway is true
     */
    public void displayOneAway()
    {
        if (oneAway)
        {
            // warning message
            super.setText("One away!");
        }
        else
        {
            super.setText("");
        }
    }
}
