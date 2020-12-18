/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.models;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dimi44
 */
public class StudentTest {
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getRegistrations method, of class Student.
     */
    @Test
    public void testGetRegistrations() {
        System.out.println("getRegistrations");
        Student instance = null;
        ArrayList<CourseRegistration> expResult = null;
        ArrayList<CourseRegistration> result = instance.getRegistrations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBathmologies method, of class Student.
     */
    @Test
    public void testGetBathmologies() {
        System.out.println("getBathmologies");
        String username = "";
        Student instance = null;
        CourseRegistration[] expResult = null;
        CourseRegistration[] result = instance.getBathmologies(username);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAM method, of class Student.
     */
    @Test
    public void testGetAM() {
        System.out.println("getAM");
        Student instance = null;
        String expResult = "";
        String result = instance.getAM();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentSemester method, of class Student.
     */
    @Test
    public void testGetCurrentSemester() {
        System.out.println("getCurrentSemester");
        Student instance = null;
        int expResult = 0;
        int result = instance.getCurrentSemester();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentSemester method, of class Student.
     */
    @Test
    public void testSetCurrentSemester() {
        System.out.println("setCurrentSemester");
        int currentSemester = 0;
        Student instance = null;
        instance.setCurrentSemester(currentSemester);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateEnrolled method, of class Student.
     */
    @Test
    public void testGetDateEnrolled() {
        System.out.println("getDateEnrolled");
        Student instance = null;
        String expResult = "";
        String result = instance.getDateEnrolled();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateEnrolled method, of class Student.
     */
    @Test
    public void testSetDateEnrolled() {
        System.out.println("setDateEnrolled");
        String dateEnrolled = "";
        Student instance = null;
        instance.setDateEnrolled(dateEnrolled);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
