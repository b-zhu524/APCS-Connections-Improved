package org.apcs.view;


import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * represents the buttons layout using a JPanel for the bottom panel (container for submit, shuffle, deselect allO
 * @author Bolang Zhu
 */
public class BottomPanel extends JPanel
{
    private BottomButton shuffle;
    private BottomButton deselectAll;
    private BottomButton submit;

    /**
     *
     */
    public BottomPanel()
    {
        super();

        shuffle = new BottomButton("Shuffle");
        deselectAll = new BottomButton("Deselect All");
        submit = new BottomButton("Submit");

        submit.setEnabled(false);
        deselectAll.setEnabled(false);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        addButton(shuffle, true);
        addButton(deselectAll, true);
        addButton(submit, false);
    }

    // GETTERS

    /**
     * getter method for the BottomButton shuffle
     * @return shuffle - BottomButton that shuffles the words
     */
    public BottomButton getShuffle()
    {
        return shuffle;
    }

    /**
     * getter method for BottomButton deselectAll
     * @return deselectAll - BottomButton that deselects all words
     */
    public BottomButton getDeselectAll()
    {
        return deselectAll;
    }

    /**
     * getter method for BottomButton submit
     * @return submit - BottomButton that submits four words
     */
    public BottomButton getSubmit()
    {
        return submit;
    }

    // SETTERS
    private void addButton(BottomButton button, boolean strut)
    {
        this.add(button);
        if (strut)
        {
            this.add(Box.createHorizontalStrut(10));
        }
    }

    public void setSubmitActionListener(ActionListener listener)
    {
        submit.addActionListener(listener);
    }

    public void setShuffleActionListener(ActionListener listener)
    {
        shuffle.addActionListener(listener);
    }

    public void setDeselectAllActionListener(ActionListener listener)
    {
        deselectAll.addActionListener(listener);
    }
}
