package org.apcs.model;

import java.util.*;

public class GameModel
{
    private GameStatus status;
    private GameSolution solution;

    public GameModel(GameSolution solution)
    {
        this.solution = solution;

        // Set up status
        Map<String, Category> solutionMap = solution.getAnswer();
        ArrayList<String> words = new ArrayList<>(solutionMap.keySet());
        status = new GameStatus(words);
    }

    /**
     *
     * @return
     */
    public GameSolution getSolution()
    {
        return solution;
    }

    /**
     *
     * @return
     */
    public GameStatus getGameStatus()
    {
        return status;
    }
}
