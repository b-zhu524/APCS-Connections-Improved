package org.apcs.view;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;


/**
 * Contains the settings and methods a word-button (one in the 4x4 grid) would use.
 * @author Bolang Zhu
 */
public class WordButton extends JButton
{
    /**
     * Constructor for the WordButton class.
     * Initializes the text of the button and attributes to change its color.
     * The font is set black and the color is set unclicked.
     * @param text - the text of the WordButton
     */
    public WordButton(String text)
    {
        super(text);
        super.setOpaque(true);
        super.setBorderPainted(false);
        super.setContentAreaFilled(false);
        super.setFocusable(false);

        setFontBlack();
        setColorUnclicked();
    }

    /**
     * Changes the color and font of the button to look clicked
     */
    public void clickButton()
    {
        setColorClicked();
        setFontWhite();
    }

    /**
     * Changes the color and font of the button to look unclicked.
     */
    public void unclickButton()
    {
        setColorUnclicked();
        setFontBlack();
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


    /**
     * It paints the inside of the button, and makes the button rounded.
     * It is called when method setBackground() is called
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,    // traces the pixel the shape
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2d.setRenderingHints(hints);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth()-1, getHeight()-1, 15, 15));
        g2d.setColor(getForeground());
        super.paintComponent(g2d);
        g2d.dispose();
    }
}
