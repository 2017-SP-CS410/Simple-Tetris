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

/**
 * P2 is used as a wrapper for a x, y position in screen space
 * @author Architects
 */
public class P2 {
    // Array to keep track of what code has run in this class
    public static boolean coverage[] = new boolean[3];
    // X and Y are in screen space (X should be a multiple of Block width)
    public double x, y;
    
    /**
     * Simple P2 constructor
     * @param x X coordinate (screen space)
     * @param y Y coordinate (screen space)
     */
    public P2(double x, double y) {
        coverage[0] = true;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Non-Destructive add for a pair of P2s
     * 
     * @param other The P2 that is being added
     * @return A new P2 with the x and y of this and other added together.
     */
    public P2 add(P2 other) {
        coverage[1] = true;
        double nx = this.x + other.x;
        double ny = this.y + other.y;
        return new P2(nx, ny);
    }
    
    /**
     * Non-Destructive Uniform scale of scaler point by scaler scalar
     * 
     * @param scaler The double used for scaling
     * @return A new P2 with x and y values of this times the scaler
     */
    public P2 scale(double scaler) {
        coverage[2] = true;
        return new P2(this.x * scaler, this.y * scaler);
    }
}
