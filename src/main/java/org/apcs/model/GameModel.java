package org.apcs.model;

import java.util.*;

/**
 * This class accesses all the data in the game.
 * It is inputted to render parts of the GUI and is updated by the controller.
 * @author Bolang Zhu
 */
public class GameModel
{
    private GameStatus status;
    private GameSolution solution;

    /**
     * constructor for GameModel
     * initializes solution and status
     * @param solution - the GameSolution for the game
     */
    public GameModel(GameSolution solution)
    {
        this.solution = solution;

        // Set up status
        Map<String, Category> solutionMap = solution.getAnswer();
        ArrayList<String> words = new ArrayList<>(solutionMap.keySet());
        status = new GameStatus(this, words);
    }

    /**
     * getter method for the game's solution
     * @return solution - the GameSolution for the game
     */
    public GameSolution getSolution()
    {
        return solution;
    }

    /**
     * getter method for GameStatus
     * @return status - the GameStatus for the game
     */
    public GameStatus getGameStatus()
    {
        return status;
    }
}
