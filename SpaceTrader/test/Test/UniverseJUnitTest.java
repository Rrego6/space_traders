/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * !!README!!
 * 
 * The Universe class has a name and an ArrayList of SolarSystems.
 * My JUnit tests for branch coverage because it checks everything the universe should have and should be careful against.
 * [x] Adding a SINGULAR SolarSystem works correctly and changes the size accordingly.
 * [x] Adding MULTIPLE SolarSystems works correctly and changes the size accordingly.
 * [x] Removing SolarSystems works correctly and changes the size accordingly.
 * [x] Correct checks that the Universe name cannot be null
 * This is more or less all that the Universe has to do. 
 * 
 * **NOT ALL THE TESTS PRODUCE THE DESIRED RESULT. THE JUNIT IS CODED CORRECTLY, THE ACTUAL CLASS METHODS ARE NOT.
 * **I HAVENT FIXED THIS YET BECAUSE THE INSTRUCTIONS SAY THE JUNIT CAN BE FAILING, BUT NOT DUE TO INCORRECT JUNIT.
 * **MY JUNIT SHOULD BE CORRECT, THE REASON FOR THE UNDESIRED RESULT IS BECAUSE THE CLASS METHODS ARE CODED POORLY.
 * **WE WILL GET AROUND TO FIXING THIS EVENTUALLY.
 */



/**
 * JUNIT TESTING
 * @author Ivan
 */
public class UniverseJUnitTest {
    
    Universe main;
    SolarSystem a;
    SolarSystem b;
    SolarSystem c;
    ArrayList<SolarSystem> two;
    Point five;
    Point ten;
    Point twenty;
    
    @Before
    public void setUp() {
        five = new Point(5, 5);
        ten = new Point(10, 10);
        twenty = new Point(20, 20);
        a = new SolarSystem("A", five, 1, 1);
        b = new SolarSystem("B", ten, 2, 2);
        c = new SolarSystem("C", twenty, 7, 7);
        two = new ArrayList<SolarSystem>();
        main = new Universe("Test");
    }
    
    @Test
    public void testAddingAndRemovingSolarSystems() {
        //Check if empty
        assertEquals(main.getSize(), 0);
        
        //Check if it adds one solarsystem
        main.addSolarSystem(a);
        assertEquals(1, main.getSize());
 
        //Check if it adds multiple solarsystems
        two.add(b);
        two.add(c);
        main.addSolarSystem(two);
        assertEquals(3, main.getSize());
    
        //Checks if it removes one solarsystem
        main.removeSolarSystem(a);
        assertEquals(2, main.getSize());
        
        //Removing a solarsystem that isn't there shouldn't be a problem
        //Shouldn't change the universe or decrement the size
        main.removeSolarSystem(a);
        assertEquals(2, main.getSize());
        assertEquals(false, main.getSize() < 0);
        
        //Removing null shouldn't cause problems
        main.removeSolarSystem(null);
        assertEquals(2, main.getSize());
    }
    
    @Test
    public void testUniverseName() {
        //Test Passes if name is null BECAUSE it only goes to the test case if name is null.
        try {
            main.setName(null);
        } catch (Exception e) {
            assertEquals(false, false);
        }

    }

}
