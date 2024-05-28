package org.apcs.view;

import javax.swing.*;

/**
 * represents a panel that displays the number of mistakes
 */
public class MistakesPanel extends JPanel
{
    private int buttonCnt = 4;

    /**
     * constructor for MistakesPanel.
     * renders the panel with four mistakes left
     */
    public MistakesPanel()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        render();
    }

    /**
     * sets buttonCnt and renders the panel with the new information
     * @param cnt - number of mistakes left
     */
    public void setCnt(int cnt)
    {
        buttonCnt = cnt;
        render();
    }


    /**
     * removes all text on MistakesPanel and renders the amount of dots in buttonCnt
     */
    public void render()
    {
        this.removeAll();
       StringBuilder blackDot = new StringBuilder("<html><style>p {font-size: 15}</style><body><p>Mistakes remaining: ");

        String bullet = "&#x25cf;"; // small - find bigger black circle
        blackDot.append(bullet.repeat(buttonCnt));

        blackDot.append("</p></body></html>");
        JLabel dotLabel = new JLabel(blackDot.toString(), SwingConstants.CENTER);
        this.add(dotLabel);
    }
}
