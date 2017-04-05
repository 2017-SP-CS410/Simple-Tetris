/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import tetris.Skins.Skin;
import java.awt.Color;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.GameState;
import tetris.P2;
//import tetris.Tetris.State;
import tetris.Tetromino;

/**
 *
 * @author Ty
 */
public class TetrominoTest {
    
    public TetrominoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of tetI method, of class Tetromino.
     
    @Test
    public void testTetI() {
        System.out.println("tetI");
        P2 start = null;
        Color c = null;
        Tetromino expResult = null;
        Tetromino result = Tetromino.tetI(start, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
     * Test of tetJ method, of class Tetromino.
     
    @Test
    public void testTetJ() {
        System.out.println("tetJ");
        P2 start = null;
        Color c = null;
        Tetromino expResult = null;
        Tetromino result = Tetromino.tetJ(start, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
     * Test of tetL method, of class Tetromino.
     
    @Test
    public void testTetL() {
        System.out.println("tetL");
        P2 start = new P2 (0,0);
        Color c = Color.red;
        Tetromino expResult = null;
        Tetromino result = Tetromino.tetL(start, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
     * Test of tetO method, of class Tetromino.
    
    @Test
    public void testTetO() {
        System.out.println("tetO");
        P2 start = null;
        Color c = null;
        Tetromino expResult = null;
        Tetromino result = Tetromino.tetO(start, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
     * Test of tetS method, of class Tetromino.
     
    @Test
    public void testTetS() {
        System.out.println("tetS");
        P2 start = null;
        Color c = null;
        Tetromino expResult = null;
        Tetromino result = Tetromino.tetS(start, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
     * Test of tetT method, of class Tetromino.
     
    @Test
    public void testTetT() {
        System.out.println("tetT");
        P2 start = null;
        Color c = null;
        Tetromino expResult = null;
        Tetromino result = Tetromino.tetT(start, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

     * Test of tetZ method, of class Tetromino.
    
    @Test
    public void testTetZ() {
        System.out.println("tetZ");
        P2 start = null;
        Color c = null;
        Tetromino expResult = null;
        Tetromino result = Tetromino.tetZ(start, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drop method, of class Tetromino.
     */
    @Test
    public void testDrop() {
        System.out.println("drop");
        GameState gs = new GameState(new GamePlay(), new Skin());
        gs.currentTet = Tetromino.tetI(new P2(0,0), Color.red);
        GameState expResult = new GameState(new GamePlay(), new Skin());
        expResult.currentTet = Tetromino.tetI(new P2(0,.01), Color.red);
        gs.drop();
        assertEquals(expResult, gs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of horizontalMove method, of class Tetromino.
     */
    @Test
    public void testHorizontalMove() {
        System.out.println("horizontalMove");
        GameState gs = new GameState(new GamePlay(), new Skin());
        gs.currentTet = Tetromino.tetI(new P2(240,0), Color.red);
        Boolean d = false;
        GameState expResult = new GameState(new GamePlay(), new Skin());
        expResult.currentTet = Tetromino.tetI(new P2(214,0), Color.red);
        gs.currentTet.horizontalMove(false, gs);
        assertEquals(expResult,gs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotate method, of class Tetromino.
     */
    @Test
    public void testRotate() {
        System.out.println("rotate");
        boolean d = true;
        GameState gs = new GameState(new GamePlay(), new Skin());
        Tetromino result = Tetromino.tetI(new P2(240,0),Color.red);
        result.rotationState = 0;
        Tetromino expResult = Tetromino.tetI(new P2(240,0), Color.red);
        expResult.rotationState = 1;
        result.rotate(d, gs);
        assertEquals(expResult, gs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intersect method, of class Tetromino.
     */
    @Test
    public void testIntersect() {
        System.out.println("intersect");
        GameState gs = new GameState(new GamePlay(), new Skin());
        boolean expResult = true;
        gs.currentTet = Tetromino.tetI(new P2(240,0), Color.red);
        boolean result = gs.currentTet.intersect(gs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convPoint method, of class Tetromino.
     */
    @Test
    public void testConvPoint() {
        System.out.println("convPoint");
        P2 result = new P2(240,200);
        P2 expResult = new P2(9.231,7.692);
        Tetromino t = Tetromino.tetI(result, Color.red);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
