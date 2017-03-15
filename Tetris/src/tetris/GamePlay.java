/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Brendan
 */
public class GamePlay {
    
    public static boolean[] coverage = new boolean[10];
    
    Random r = new Random();
    
    public void updateLevel(GameState gs, Integer lines) {
        coverage[0] = true;
        // Update the level in gs based on the number of lines cleared
        // Update the gravity based the current level
        if(lines > 0){
            coverage[1] = true;
            gs.level++;
            gs.gravity += 0.02*gs.gravity;
        }
    }
    public void nextTet(GameState gs) {
        coverage[2] = true;
        // Abstract Factory
        // Randomly Generates a new Tetromino using the Static Factories inside Tetromino
        int rand = r.nextInt(7);
        P2 p = new P2(130, -52);
        Color c = Color.WHITE;
            switch(rand){
                case 0:
                    coverage[3] = true;
                    gs.currentTet = Tetromino.tetI(p, c);
                    break;
                case 1:
                    coverage[4] = true;
                    gs.currentTet = Tetromino.tetL(p, c);
                    break;
                case 2:
                    coverage[5] = true;
                    gs.currentTet = Tetromino.tetS(p, c);
                    break;
                case 3:
                    coverage[6] = true;
                    gs.currentTet = Tetromino.tetZ(p, c);
                    break;
                case 4:
                    coverage[7] = true;
                    gs.currentTet = Tetromino.tetO(p, c);
                    break;
                case 5: 
                    coverage[8] = true;
                    gs.currentTet = Tetromino.tetJ(p, c);
                    break;
                case 6:
                    coverage[9] = true;
                    gs.currentTet = Tetromino.tetT(p, c);
            } 
    
    
    }
}
