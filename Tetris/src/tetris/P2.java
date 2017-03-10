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
public class P2 {
    public static boolean coverage[] = new boolean[3];
    // This is screen coordinates
    public double x, y;
    
    public P2(double x, double y) {
        coverage[0] = true;
        this.x = x;
        this.y = y;
    }
    
    public P2 add(P2 other) {
        coverage[1] = true;
        double nx = this.x + other.x;
        double ny = this.y + other.y;
        return new P2(nx, ny);
    }
    
    public P2 scalar(int a) {
        coverage[2] = true;
        return new P2(x * a, y * a);
    }
}
