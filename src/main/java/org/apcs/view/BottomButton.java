package org.apcs.view;


import javax.swing.*;
import java.awt.*;

/**
 * Methods and info for the buttons below the GameGrid. These include submit, shuffle, and de-select all.
 *
 * @author Bolang Zhu
 */
public class BottomButton extends JButton
{
    private String text;

    /**
     * constructor for BottomButton
     * sets the margin to be 10 pixels in each direction
     * sets focusable false - there's no blue border when clicking the button
     * @param text - text of the button
     */
    public BottomButton(String text)
    {
        this.text = text;

        super.setMargin(new Insets(10, 10, 10, 10));
        super.setFocusable(false);
    }

    /**
     * getter method for the Button's text
     * @return text - the button's text
     */
    public String getText()
    {
        return text;
    }
}
