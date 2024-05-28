package org.apcs.view;

import org.apcs.model.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;


/**
 * Main view class.
 * It interacts with Main, GameModel, and GameController
 * @author Bolang Zhu
 */
public class GameView
{
    GameModel model;
    List<String> words;

    GameFrame frame;
    GamePanel panel;
    GameBoard board;
    BottomPanel bottom;
    MessageLabel label;
    MistakesPanel mistakes;


    /**
     * Constructor of GameView.
     * Initializes status from model.
     * Then calls initGUI()
     * @param model - the game's GameModel
     */
    public GameView(GameModel model)
    {
        this.model = model;
        GameStatus status = model.getGameStatus();
        words = status.getGameBoardData().getRemainingWords();    // ArrayList of 16 words

        initGUI();
    }

    /**
     * Initializes the GUI. Adds each component layered into a GameFrame
     */
    private void initGUI()
    {
        // sets up game frame
        frame = new GameFrame();

        // sets up game panel
        panel = new GamePanel();

//        // sets up message label
//        label = new MessageLabel();
//        panel.add(new JLabel(" ")); // spacing
//        panel.add(label);

        // sets up game board
        board = new GameBoard();
        board.updateBoard(model.getGameStatus());
        panel.add(board);

        // sets up mistake label
        mistakes = new MistakesPanel();
        panel.add(mistakes);

        // sets up bottom panel
        bottom = new BottomPanel();
        panel.add(bottom);

        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * adds the game's ActionListener to WordButtons
     * @param listener - ActionListener for WordButton
     */
    public void addWordButtonActionListener(ActionListener listener)
    {
        getGameBoard().addWordButtonActionListeners(listener);
    }


    /**
     * adds the game's ActionListener to DeselectAll
     * @param listener - ActionListener for DeselectAll button
     */
    public void addDeselectAllActionListener(ActionListener listener)
    {
        getBottomPanel().setDeselectAllActionListener(listener);
    }

    /**
     * adds the game's ActionListener to Shuffle button
     * @param listener - ActionListener for Shuffle button
     */
    public void addShuffleActionListener(ActionListener listener)
    {
        getBottomPanel().setShuffleActionListener(listener);
    }

    /**
     * adds the game's ActionListener to Submit button
     * @param listener - ActionListener for Submit button
     */
    public void addSubmitActionListener(ActionListener listener)
    {
        getBottomPanel().setSubmitActionListener(listener);
    }

    /**
     * adds the game's ActionListener for NewGame button
     * @param listener - ActionListener for the NewGame button
     */
    public void addNewGameActionListener(ActionListener listener)
    {
        getBottomPanel().setNewGameActionListener(listener);
    }

    /**
     * getter method for GameFrame
     * @return frame - the game's GameFrame
     */
    public GameFrame getGameFrame()
    {
        return frame;
    }

    /**
     * getter method for GamePanel
     * @return panel - the game's GamePanel
     */
    public GamePanel getGamePanel()
    {
        return panel;
    }

    /**
     * getter method for the game's GameBoard
     * @return board - the GameBoard for the game
     */
    public GameBoard getGameBoard()
    {
        return board;
    }

    /**
     * getter method for the game's MessageLabel
     * @return label - the MessageLabel for the game
     */
    public MessageLabel getMessageLabel()
    {
        return label;
    }

    /**
     * getter method for the game's BottomPanel.
     * @return bottom - the BottomPanel for the game
     */
    public BottomPanel getBottomPanel()
    {
        return bottom;
    }

    /**
     * getter method for the game's MistakesPanel
     * @return mistakes - the MistakesPanel for the game
     */
    public MistakesPanel getMistakesPanel()
    {
        return mistakes;
    }
}
