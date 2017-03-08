/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author gunny
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TetrominoTest {
    
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
////import java.util.Queue;
////import java.util.Stack;
//import stacksandqueues.*;

public class QueueTest {
    public String values[];
    public Queue queue;
    public Stack stack;
    public QueueTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        values = new String[5];
        values[0] = "Zero";
        values[1] = "One";
        values[2] = "Two";
        values[3] = "Three";
        values[4] = "Four";
        queue = new Queue() {};
        stack = new Stack();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEmptyQueue() {
        assertEquals("Initial Queue should be empty", queue.isEmpty(), true);
    }
    @Test
    public void testEmptyStack() {
        assertEquals("Initial Stack should be empty", stack.isEmpty(), true);
    }
    @Test
    public void testNonEmptyQueue() {
        queue.add("Stuff");
        assertEquals("Initial Queue should be empty", queue.isEmpty(), false);
    }
    @Test

    public void testNonEmptyStack() {
        stack.add("Stuff");
        assertEquals("Initial Stack should be empty", stack.isEmpty(), false);
    }
    @Test
    public void testQueueAddGet() {
        for (String s : values) queue.add(s);
        for (String s : values) queue.get();
        assertEquals("Queue should be empty", queue.isEmpty(), true);
    }
    @Test
    public void testStackAddGet() {
        for (String s : values) stack.add(s);
        for (String s : values) stack.get();
        assertEquals("Stack should be empty", stack.isEmpty(), true);
    }
    @Test
    public void testQueueOrder() {
        for (String s : values) queue.add(s);
        for (int i = 0; i < values.length; i++)
            assertEquals("Expecting " + values[i], queue.get(), values[i]);
    }
    @Test
    public void testStackOrder() {
        for (String s : values) stack.add(s);
        for (int i = values.length-1; i >= 0; i--)
            assertEquals("Expecting " + values[i], stack.get(), values[i]);
    }
    @Test
    public void testQueueSize() {
        for (int i = 0; i < 12; i++) queue.add("Junk");
        assertEquals("Expecting length 12 values", queue.size(), 12);
    }
    @Test
    public void testStackSize() {
        for (int i = 0; i < 9; i++) stack.add("Junk");
        assertEquals("Expecting 9 values", stack.size(), 9);
    }

}
    
}
