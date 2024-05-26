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

    public BottomButton(String text)
    {
        this.text = text;

        super.setMargin(new Insets(10, 10, 10, 10));
    }

    public String getText()
    {
        return text;
    }
}
