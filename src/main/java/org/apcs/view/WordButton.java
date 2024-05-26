package org.apcs.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;


/**
 * contains the settings and methods a word-button (one in the 4x4 grid) would use.
 * @author Bolang Zhu
 */
public class WordButton extends JButton
{
    public WordButton(String text)
    {
        super(text);

//        super.setOpaque(true);

        setFontBlack();

        setColorClicked();
    }

    public void clickButton()
    {
        setColorClicked();
        setFontBlack();
    }

    public void unclickButton()
    {
        setColorUnclicked();
        setFontWhite();
    }

    private void setColorUnclicked()
    {
        super.setBackground(Color.white);
    }

    private void setColorClicked()
    {
        super.setBackground(new Color(90, 90, 80));
    }

    private void setFontWhite()
    {
        super.setFont(new Font("Arial", Font.BOLD, 17));
        super.setForeground(Color.WHITE);
    }
    private void setFontBlack()
    {
        super.setFont(new Font("Arial", Font.BOLD, 17));
        super.setForeground(Color.BLACK);
    }
}
