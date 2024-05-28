package org.apcs.model;

import java.util.*;

/**
 * This is the model for the game. It holds GameStatus and GameSolution,
 * which give information to render the GUI and give the controller information.
 * @author Bolang Zhu
 */
public class GameModel
{
    private GameStatus status;
    private GameSolution solution;

    /**
     * Constructor for GameModel
     * Initializes solution and status
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
     * Getter method for the game's solution
     * @return solution - the GameSolution for the game
     */
    public GameSolution getSolution()
    {
        return solution;
    }

    /**
     * Getter method for GameStatus
     * @return status - the GameStatus for the game
     */
    public GameStatus getGameStatus()
    {
        return status;
    }
}
