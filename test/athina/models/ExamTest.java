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
public class ExamTest {
    
    public ExamTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setCourse method, of class Exam.
     */
    @Test
    public void testSetCourse() {
        System.out.println("setCourse");
        Course course = null;
        Exam instance = null;
        instance.setCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourses method, of class Exam.
     */
    @Test
    public void testGetCourses() {
        System.out.println("getCourses");
        Exam instance = null;
        ArrayList<Course> expResult = null;
        ArrayList<Course> result = instance.getCourses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCourses method, of class Exam.
     */
    @Test
    public void testAddCourses() {
        System.out.println("addCourses");
        Course course = null;
        Exam instance = null;
        instance.addCourses(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYear method, of class Exam.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Exam instance = null;
        String expResult = "";
        String result = instance.getYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setYear method, of class Exam.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        String year = "";
        Exam instance = null;
        instance.setYear(year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Exam.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Exam instance = null;
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Exam.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Exam instance = null;
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Exam.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Exam instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
