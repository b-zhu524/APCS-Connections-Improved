package org.apcs.view;

import org.apcs.model.*;
import java.util.*;


/**
 * Main view class. Interacts with Main, GameModel, and GameController
 * @author Bolang Zhu
 */
public class GameView
{
    GameModel model;

    public GameView(GameModel model)
    {
        this.model = model;
        GameStatus status = model.getGameStatus();
        List<String> words = status.getRemainingWords();    // ArrayList of 16 words

        initGUI(words);
    }
    public GameView()
    {

    }
    public void initGUI(List<String> words)
    {
        GameFrame frame = new GameFrame();
        GamePanel panel = new GamePanel();

        GameBoard board = new GameBoard();

        GameRow row1 = new GameRow();
        setUpRow(row1, 1, words);

        GameRow row2 = new GameRow();
        setUpRow(row2, 2, words);

        GameRow row3 = new GameRow();
        setUpRow(row3, 3, words);

        GameRow row4 = new GameRow();
        setUpRow(row4, 4, words);

        // SETS UP 4x4 GRID OF WORDS
        board.add(row1);
        board.add(row2);
        board.add(row3);
        board.add(row4);
        panel.add(board);

        // SETS UP MISTAKE LABEL
        MistakesPanel mistakes = new MistakesPanel();
        panel.add(mistakes);

        // SETS UP BOTTOM PANEL
        BottomPanel bottom = new BottomPanel();
        panel.add(bottom);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void setUpRow(GameRow row, int rowNum, List<String> words)
    {
        for ( int i=(rowNum-1)*4; i<rowNum*4; i++ )
        {
            WordButton word = new WordButton(words.get(i));
            row.addWordButton(word);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        for ( int i=0; i<16; i++ ){
            l.add("text");
        }

        GameView gv = new GameView();
        gv.initGUI(l);
    }
}
