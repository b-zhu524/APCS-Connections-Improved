package org.apcs.view;


import javax.swing.*;

/**
 * Panel with boxlayout to layer the GameBoard, MistakesPanel, and BottomPanel
 */
public class GamePanel extends JPanel
{
    public GamePanel()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void addGameBoard(GameBoard board)
    {
        this.add(board);
    }

    public void addMistakesPanel(MistakesPanel panel)
    {
        this.add(panel);
    }

    public void addBottomPanel(BottomPanel panel)
    {
        this.add(panel);
    }

}
