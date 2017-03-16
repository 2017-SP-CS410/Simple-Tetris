/*
 * Copyright (C) 2017
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tetris;

import java.awt.Color;
import java.util.Random;

/**
 * The methods related to game play that can be changed between different
 * versions of Tetris have been moved into this class which acts as a base class
 * for a Templet of GamePlays.
 *
 * @author Team1
 */
public class GamePlay {

    // Array to keep track of what code has run in this class
    public static boolean[] coverage = new boolean[10];

    // Random Number Generator
    public static Random r = new Random();

    /**
     * Used to update both the level and gravity based on the number of lines 
     * cleared and other information stored in the GameState.
     * <p>
     * In this basic version the level is increased by 1 and gravity is
     * increased by 2% provided that lines is greater than 0.
     *
     * @param gs The current GameState
     * @param lines Number of lines cleared
     */
    public void update(GameState gs, Integer lines) {
        coverage[0] = true;
        if (lines > 0) {
            coverage[1] = true;
            gs.level++;  // Increment the level
            gs.gravity += (0.02 * gs.gravity);  // Increase Gravity
        }
    }

    /**
     * An Abstract factory for picking the next Tetromino.
     * <p>
     * In this basic version the next Tetromino is picked at random.
     * 
     * @param gs
     */
    public void nextTet(GameState gs) {
        coverage[2] = true;
        int rand = r.nextInt(7);  // Get a random number
        P2 p = new P2(130, -52);  // Default starting position
        switch (rand) {
            case 0:
                coverage[3] = true;
                gs.currentTet = Tetromino.tetI(p, Color.RED);
                break;
            case 1:
                coverage[4] = true;
                gs.currentTet = Tetromino.tetL(p, Color.ORANGE);
                break;
            case 2:
                coverage[5] = true;
                gs.currentTet = Tetromino.tetS(p, Color.MAGENTA);
                break;
            case 3:
                coverage[6] = true;
                gs.currentTet = Tetromino.tetZ(p, Color.GREEN);
                break;
            case 4:
                coverage[7] = true;
                gs.currentTet = Tetromino.tetO(p, Color.YELLOW);
                break;
            case 5:
                coverage[8] = true;
                gs.currentTet = Tetromino.tetJ(p, Color.BLUE);
                break;
            case 6:
                coverage[9] = true;
                gs.currentTet = Tetromino.tetT(p, Color.CYAN);
        }
    }
}
