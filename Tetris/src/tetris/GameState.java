
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author micalinscheid
 */
public class GameState {
    public int score = 0;
    public int level = 0;
    public double gravity = .01;
    public Tetris.State state;
    public int untilLock = 20;
    public int deletedLines[] = new int[4];
    // TODO
//    public GamePlay gp;
//    public Skin s;
    public Block[][] stack = new Block[21][9];
    public Tetromino currentTet;
    
    public void tick() {
        // If state is falling call drop
        // Else if state is locking then check if untilLock != 0. Decrement by 1
        // Else if untilLock == 0. Call lock and deleteLines
        // If deleteLines returns true set state to animation
        // If it returns false set game state to falling and call newTet
    }
    
    public void drop() {
        // Delegates to the Tetronimo's drop. If that returns true set state to locking
        
      if( currentTet.drop(this) == true){
          state = state.locking;
      }
      
    }
    
    public void lock() {
        // Breaks apart Tetromino into a bunch of Blocks and puts them into the stack
        //use convPoint to get grid coordinates instead of screen coordinates
        //use rotation state instance variable to get the rotation
        //add point from ln 48 to all points in line 49 
        //creates new coordinates to give each block
        //add to stack  
        
        P2 [] rot = currentTet.rotations[currentTet.rotationState];
        P2 gridP = currentTet.convPoint();
        
        for(int i = 0; i < rot.length; i++){
            double x = rot[i].x + gridP.x;
            double y = rot[i].y + gridP.y;
                
            for(int j = 0; j< stack.length; j++){
                for(int k = 0; k < stack[j].length; k++){
                    stack[j][k]= new Block((int)x,(int)y, Color.BLACK);
                }
            }
        } 
        
    
        }
    
    public boolean deleteLines() {
        // Find all the lines that needed to be deleted
        // Add those line numbers to deletedLines
        // return True if any lines where deleted else false
        return false;
    }
    
    public void update(int lines) {
        // Updates score based on lines
    }
    
    public void horiziontalMove(boolean dirc) {
        // dirc is direction False: Left, True: Right
        // Delegates to Tetromions horizontalMove
    }
    
    public void rotate(boolean dirc) {
        // dirc is direction False: counterclockwise, True: clockwise
        // Delegates to Tetromions rotate
    }
    
    public void paint(Graphics g) {
        // Tell the Skin object to paint
        // If the state is animation
        // Tell Skin object to animate
        // if the animation returns move everything in the stack above the deletedlines down
        // and call nextTet
    }
}
