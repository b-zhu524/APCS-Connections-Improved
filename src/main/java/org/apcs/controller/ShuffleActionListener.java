package org.apcs.controller;

import org.apcs.model.GameBoardData;
import org.apcs.model.GameStatus;
import org.apcs.view.GameBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * An implementation of ActionListener.
 * When shuffle is clicked, it shuffles the words in GameBoardData and re-renders GameBoard accordingly.
 * @author Bolang Zhu
 */
public class ShuffleActionListener implements ActionListener
{
    /**
     * The controller for the game.
     */
    GameController controller;

    /**
     * Constructor for ShuffleActionListener.
     * @param controller - the game's controller
     */
    public ShuffleActionListener(GameController controller)
    {
        this.controller = controller;
    }

    /**
     * This is the implementation of ActionListener's actionPerformed method.
     * This is called when the shuffle button is clicked.
     * It shuffles the remaining words in GameBoardData, and re-renders the GUI accordingly.
     * It also re-adds the action listener for the WordButton class.
     * @param e - the event on the shuffle button to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        GameBoard gameBoard = controller.getView().getGameBoard();
        GameStatus gameStatus = controller.getModel().getGameStatus();
        GameBoardData gameBoardData = gameStatus.getGameBoardData();

        // shuffle words in GameBoardData
        gameBoardData.shuffleRemainingWords();

        // re-render GameBoardData
        gameBoard.updateBoard(gameStatus);
        gameBoard.addWordButtonActionListeners(controller.getWordButtonActionListener());
    }
}
