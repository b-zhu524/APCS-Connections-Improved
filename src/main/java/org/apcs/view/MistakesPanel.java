package org.apcs.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 *
 */
public class MistakesPanel extends JPanel
{
    private int buttonCnt = 4;
    public MistakesPanel()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        render();
    }

    public void setCnt(int cnt)
    {
        buttonCnt = cnt;
        render();
    }


    // BUG
    private void render()
    {
        this.removeAll();
        this.add(new JLabel("Mistakes remaining: "));

        BufferedImage blackDot;

        try
        {
            URL dot = this.getClass().getClassLoader().getResource("blackdot.png");
            blackDot = ImageIO.read(dot);
        }
        catch (IOException e)
        {
            blackDot = null;
        }

        if (blackDot != null)
        {
            Image finalDot = blackDot.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

            for ( int i=0; i<buttonCnt; i++ )
            {
                ImageIcon icon = new ImageIcon(finalDot);
                this.add(new JLabel(icon));
            }
        }
    }
}
