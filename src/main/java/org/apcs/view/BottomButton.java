package org.apcs.view;


import javax.swing.*;
import java.awt.*;

/**
 * Extension of JButton. Submit, deselect all, shuffle, and new game buttons are all instances of this.
 * It changes the spacing of a JButton and makes it non-focusable.
 *
 * @author Bolang Zhu
 */
public class BottomButton extends JButton
{
    private String text;

    /**
     * The constructor for BottomButton.
     * It sets the margin to be 10 pixels in each direction.
     * It sets focusable false - there's no blue border when clicking the button.
     * @param text - text of the button
     */
    public BottomButton(String text)
    {
        this.text = text;

        super.setMargin(new Insets(10, 10, 10, 10));
        super.setFocusable(false);
    }

    /**
     * Getter method for the Button's text
     * @return text - the button's text
     */
    public String getText()
    {
        return text;
    }
}
