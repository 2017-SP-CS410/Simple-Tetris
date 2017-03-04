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
    Random r = new Random();
    int rand = r.nextInt(7);
    
    
    
    public void updateLevel(GameState gs, Integer lines) {
        // Update the level in gs based on the number of lines cleared
        // Update the gravity based the current level
        if(lines > 0){
            gs.level++;
            gs.gravity += 0.02*gs.gravity;
        }
    }
    public void nextTet(GameState gs) {
        // Abstract Factory
        // Randomly Generates a new Tetromino using the Static Factories inside Tetromino
        P2 p = new P2(130, 0);
        Color c = Color.BLACK;
            switch(rand){
                case '0': 
                    gs.currentTet = Tetromino.tetI(p, c);
                    break;
                case '1':
                    gs.currentTet = Tetromino.tetL(p, c);
                    break;
                case '2':
                    gs.currentTet = Tetromino.tetS(p, c);
                    break;
                case '3':
                    gs.currentTet = Tetromino.tetZ(p, c);
                    break;
                case '4':
                    gs.currentTet = Tetromino.tetO(p, c);
                    break;
                case '5': 
                    gs.currentTet = Tetromino.tetJ(p, c);
                    break;
                case '6':
                    gs.currentTet = Tetromino.tetT(p, c);
            } 
    
    
    }
}
