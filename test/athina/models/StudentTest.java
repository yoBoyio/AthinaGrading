/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.models;

import athina.Account;
import static athina.Account.courses;
import static athina.Account.students;
import athina.Athina;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dimi44
 */
public class StudentTest {
     private static Student instance ;
    private Account data;
    private static Student  student;
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         Account account = new Account();
        Athina.user = new  Student("aalexiou","123", "Alexis", "Alexiou",3 ,"173903","aalexiou@it.teithe.gr");
        student = (Student) Athina.user;
        instance = student;
    }
    
    
    @Test
    public void testGetRegistrations() {
        System.out.println("getRegistrations");
                
        Course course1 = new Course("01-Θ");
        Course course2 = new Course("02-Θ");
        
        Student student2 = new  Student("ddimitriou","123", "Dimitris", "Dimitriou",5 ,"165306","ddimitriou@it.teithe.gr");

        data.registrations[0] = new CourseRegistration(student, course1, "2018-19 ΕΑΡ","20/5/2019","r1");
        data.registrations[1] = new CourseRegistration(student2, course2, "2018-19 XEIM","20/11/2020","r2");

        CourseRegistration expResult = data.registrations[0];
        int expSize = 1;
        assertEquals(expResult, instance.getRegistrations().get(0));
        assertEquals(expSize, instance.getRegistrations().size());
    }

    /**
     * Test of getBathmologies method, of class Student.
     */
  
    
}
