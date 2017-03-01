/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author Brendan
 */
public interface Painting {
    public void paint(Tetromino t);
    public void paint(Block b);
    public void animate(int frame);
    public void changeBackground(int level);
}
