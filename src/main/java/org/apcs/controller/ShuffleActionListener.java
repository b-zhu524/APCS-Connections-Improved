package org.apcs.controller;

import org.apcs.model.GameBoardData;
import org.apcs.model.GameStatus;
import org.apcs.view.GameBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * represents the ActionListener for shuffle button
 * @author Bolang Zhu
 */
public class ShuffleActionListener implements ActionListener
{
    GameController controller;

    /**
     * allows the actionListener to access methods from Model and View
     * @param controller - the game's controller
     */
    public ShuffleActionListener(GameController controller)
    {
        this.controller = controller;
    }

    /**
     * this is called when the shuffle button is clicked
     * it shuffles the remaining words in GameBoardData and re-renders the GUI
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
