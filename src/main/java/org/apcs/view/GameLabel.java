package org.apcs.view;

import org.apcs.model.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Methods and info for a SOLVED category. It takes up a row of space.
 * @author Bolang Zhu
 */
public class GameLabel extends JLabel
{
    private Category category;

    public GameLabel(Category cat)
    {
        super(cat.getCatInfo(), JLabel.CENTER);
        category = cat;
        setFont();
        setRoundEdges();
    }

    public GameLabel(String text, int horizontalAlignment)
    {
        super(text, horizontalAlignment);
    }


    private void setFont()
    {
        super.setFont(new Font("Arial", Font.BOLD, 14));
        super.setForeground(Color.BLACK);
    }

    public void unflipLabel()
    {
        super.setBackground(getBackgroundColor(category));
        super.setOpaque(true);
    }


    public void setRoundEdges()
    {
        super.setBorder(new LineBorder(Color.WHITE, 3));
    }

    public Color getBackgroundColor(Category cat)
    {
        int difficulty = cat.getDifficulty();
        if ( difficulty == 0 )
        {
            return new Color(245, 224, 126); // YELLOW from NYTIMES
        }
        else if ( difficulty == 1 )
        {
            return new Color(167, 194, 104); // GREEN from NYTIMES
        }
        else if ( difficulty == 2 )
        {
            return new Color(180, 195, 235); // LIGHT BLUE from NYTIMES
        }
        else
        {
            return new Color(170, 130, 190); // PURPLE from NYTIMES
        }
    }
}
