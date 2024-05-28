package org.apcs.view;

import org.apcs.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Extension of JLabel. A GameLabel is displayed when a category is solved.
 * Each category has a unique color, name, and words to be displayed once solved.
 * @author Bolang Zhu
 */
public class GameLabel extends JLabel
{
    private final Category category;

    /**
     * Constructor for GameLabel.
     * It initializes the text to be the category name followed by the member words in the category.
     * It sets the color of label according to the category's difficulty.
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
     * It sets the label to its color and allows it to be displayed.
     */
    private void unflipLabel()
    {
        super.setBackground(getBackgroundColor());
        super.setOpaque(true);
    }

    /**
     * It gets the color of the label according to the category's difficulty.
     * Difficulty 0 : YELLOW.
     * Difficulty 1 : GREEN.
     * Difficulty 2 : BLUE.
     * Difficulty 4 : PURPLE.
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
