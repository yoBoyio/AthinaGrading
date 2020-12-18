/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.models;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dimi44
 */
public class ProfessorTest {
    
    public ProfessorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCoursesTaught method, of class Professor.
     */
    @Test
    public void testGetCoursesTaught() {
        System.out.println("getCoursesTaught");
        Professor instance = null;
        ArrayList<Course> expResult = null;
        ArrayList<Course> result = instance.getCoursesTaught();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCoursesTaught method, of class Professor.
     */
    @Test
    public void testSetCoursesTaught() {
        System.out.println("setCoursesTaught");
        Course[] coursesTaught = null;
        Professor instance = null;
        instance.setCoursesTaught(coursesTaught);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Professor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Professor instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
