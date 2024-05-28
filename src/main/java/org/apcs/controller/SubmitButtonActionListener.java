package org.apcs.controller;

import org.apcs.model.*;
import org.apcs.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


/**
 * ActionListener for the submit button.
 * @author Bolang Zhu
 */
public class SubmitButtonActionListener implements ActionListener
{
    GameController controller;

    /**
     * This is the constructor for the SubmitButtonActionListener
     * @param controller - the GameController for the game
     */
    public SubmitButtonActionListener(GameController controller)
    {
        this.controller = controller;
    }


    /**
     * This is called whenever the submit button is pressed.
     * It compares the clicked words with the solution and updates GameBoardData and GameBoard accordingly.
     * It solves the game and opens up a New Game button if the game is over (player lost or player won).
     * It displays warning messages and end of game messages (One away!, Congratulations!, or Try Harder!)
     * @param actionEvent the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        GameStatus status = controller.getModel().getGameStatus();
        Set<String> clicked = status.getClickedWords();

        GameSolution solution = controller.getModel().getSolution();

        if (clicked.size() == 4)
        {
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
                if (solution.oneAway(clicked))
                {
                    // display one away
                }
                status.updateMistakes();
                controller.getView().getMistakesPanel().setCnt(4-status.getNumMistakes());
            }

            controller.getView().getGameBoard().deselectAll();
            status.updateTurn();
            status.removeAllClicked();
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
}
