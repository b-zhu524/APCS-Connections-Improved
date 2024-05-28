package org.apcs.controller;

import org.apcs.model.*;
import org.apcs.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


/**
 * An implementation of ActionListener.
 * This action listener is used by the submit button.
 * It moves four clicked words as solved if the guess is correct and updates the GameBoard accordingly,
 * It removes a try if the guess is incorrect.
 * It automatically solves the game and displays a New Game button if the game is over once the submit button is clicked.
 * @author Bolang Zhu
 */
public class SubmitButtonActionListener implements ActionListener
{
    /**
     * The controller for the game.
     */
    GameController controller;

    /**
     * Constructor for the SubmitButtonActionListener class.
     * @param controller - the GameController for the game
     */
    public SubmitButtonActionListener(GameController controller)
    {
        this.controller = controller;
    }


    /**
     * This is an implementation of ActionListener's actionPerformed method.
     * This is called whenever the submit button is pressed.
     * It invokes GameSolution's allRight method to check if the player's answer is correct.
     * If the answer is correct, update GameBoardData and update the display in GameBoard accordingly.
     * If the answer is not correct, it increases the number of mistakes by one, and updates the mistakes panel accordingly.
     * It also clears the users selection.
     * It disables the submit and deselect all buttons.
     * It then checks if the game is over (if the player has no more tries or the user solved every row).
     * If the game is over, it updates the BottomPanel by removing submit, shuffle, and deselect all,
     * and replacing them with a new game button, and solves the game.
     * It adds an action listener for the new game button.
     * @param actionEvent the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        GameStatus status = controller.getModel().getGameStatus();
        Set<String> clicked = status.getClickedWords();

        GameSolution solution = controller.getModel().getSolution();

        if (solution.allRight(clicked))
        {
            // solve a category in GameBoardData (change cats and words)
            Category solvedCat = status.getClickedCat();
            status.getGameBoardData().solveCategory(solvedCat);

            // update display in GameBoard
            GameBoard board = controller.getView().getGameBoard();
            board.updateBoard(status);
            board.addWordButtonActionListeners(controller.getWordButtonActionListener());
        }
        else
        {
            status.updateMistakes();
            controller.getView().getMistakesPanel().setCnt(4-status.getNumMistakes());
        }
        // clear player's selection
        controller.getView().getGameBoard().deselectAll();
        status.removeAllClicked();

        // disables buttons
        controller.getView().getBottomPanel().getSubmit().setEnabled(false);
        controller.getView().getBottomPanel().getDeselectAll().setEnabled(false);


        // GAME OVER
        if (status.getNumMistakes() == 4 || status.getGameBoardData().getNumRowsSolved() == 4)
        {
            // game over panel for BottomPanel
            controller.getView().getBottomPanel().addAllButtons(true);

            // solve
            GameBoardData data = status.getGameBoardData();
            data.getRemainingWords().clear();
            for (String word : solution.getAnswer().keySet())
            {
                if (!data.getSolvedCategories().contains(solution.getAnswer().get(word)))
                {
                    data.addSolvedCategory(solution.getAnswer().get(word));
                    controller.getView().getGameBoard().updateBoard(status);
                }
            }

            // add the ActionListener for NewGameButton
            controller.getView().addNewGameActionListener(controller.getNewGameActionListener());
        }
    }
}
