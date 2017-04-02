/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author JesseRichmond
 */
public class InputKeyEvent extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case (KeyEvent.VK_A):
                gui.gs.horizontalMove(false);
                break;
            case (KeyEvent.VK_D):
                gui.gs.horizontalMove(true);
                break;
            case (KeyEvent.VK_J):
                gui.gs.rotate(false);
                break;
            case (KeyEvent.VK_L):
                gui.gs.rotate(true);
                break;
            case (KeyEvent.VK_S):
                gui.gs.drop(1000);
                break;
            case (KeyEvent.VK_R):
                gui.gs.stack = new Block[20][10];
        }
    }
}
