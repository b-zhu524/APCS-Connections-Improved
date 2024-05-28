package org.apcs.view;

import org.apcs.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Methods and info for a solved category. It takes up a row of space of the GameBoard.
 * @author Bolang Zhu
 */
public class GameLabel extends JLabel
{
    private final Category category;

    /**
     * initializes the text to be the category name followed by the member words in the category
     * sets the color of label according to the category's difficulty
     * @param cat - the Category of the solved words
     */
    public GameLabel(Category cat)
    {
        super("", JLabel.CENTER);
        category = cat;

        String text = "<html><style>h2 {text-align: center;} p{text-align: center;}</style><head><h2>" +
                cat.getCatName().toUpperCase() + "</h2><head><body><p>" + cat.getCatInfo().toUpperCase()
                + "</p></body></html>";
        super.setText(text);

        unflipLabel();
    }

    /**
     * sets the color of the label
     */
    private void unflipLabel()
    {
        super.setBackground(getBackgroundColor());
        super.setOpaque(true);
    }

    /**
     * sets the color of the label according to the category's difficulty
     * @return color - the color of the label
     */
    private Color getBackgroundColor()
    {
        int difficulty = category.getDifficulty();
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
