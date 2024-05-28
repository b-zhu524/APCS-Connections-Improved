package org.apcs.view;

import javax.swing.*;

/**
 * Extension of JPanel. It displays the number of mistakes represented by dots.
 */
public class MistakesPanel extends JPanel
{
    private int buttonCnt = 4;

    /**
     * Constructor for MistakesPanel.
     * Renders the panel with initially four mistakes left.
     */
    public MistakesPanel()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        render();
    }

    /**
     * It sets buttonCnt and renders the panel with the new information.
     * @param cnt - number of mistakes left
     */
    public void setCnt(int cnt)
    {
        buttonCnt = cnt;
        render();
    }


    /**
     * It removes all text on MistakesPanel and renders the amount of dots in buttonCnt.
     */
    public void render()
    {
        this.removeAll();
        StringBuilder displayText = new StringBuilder("<html><style>p {font-size: 15}</style><body><p>Mistakes remaining: ");

        if (buttonCnt == 0)
        {
            displayText.append("0");
        }
        else
        {
            String bullet = "&#x25cf;"; // small - find bigger black circle
            displayText.append(bullet.repeat(buttonCnt));
        }

        displayText.append("</p></body></html>");
        JLabel dotLabel = new JLabel(displayText.toString(), SwingConstants.CENTER);
        this.add(dotLabel);
    }
}
