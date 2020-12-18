/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.models;

import athina.Account;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dimi44
 */
public class CourseTest {
    
      
    private static Course instance ;
    private Account account;
    
    public CourseTest() {
    }
    

    
    @BeforeClass
    public void setUp() {
         instance = new Course("123", "Μαθηματικά 1", 6, 1,new Professor("vkostogl","123", "Vasileios", "Kostoglou","vkostogl@teithe.gr"));
        Account account = new Account();
    }
    
    @AfterClass
    public void tearDown() {
    }

    /**
     * Test of setExam method, of class Course.
     */
    @Test
    public void testGetCurrentRegistrations() {
        System.out.println("getCurrentRegistrations");
        try{
        Student s1 =  new Student("aalexiou","123", "Alexis", "Alexiou",3 ,"173903","aalexiou@it.teithe.gr");
        Student s2 = new Student("aalexiou","123", "Alexis", "Alexiou",3 ,"173903","aalexiou@it.teithe.gr");
        
        Course course2 = new Course("113", "Μαθηματικά 2", 6, 1,new Professor("vkostogl","123", "Vasileios", "Kostoglou","vkostogl@teithe.gr"));
        
        account.registrations[0] = new  CourseRegistration(s1, instance, "2018-19 ΕΑΡ","20/5/2019","r1");
        account.registrations[1] = new  CourseRegistration(s2, instance, "2018-19 ΕΑΡ","20/5/2019","r1");
        account.registrations[2] = new CourseRegistration(s2, course2, "2018-19 ΕΑΡ","20/5/2019","r1");
        
        int expSize = 2;
        CourseRegistration expReg1 = account.registrations[0];
        CourseRegistration expReg2 = account.registrations[1];
        
            assertEquals(expSize, instance.getCurrentRegistrations().size());
            assertEquals(expReg1, instance.getCurrentRegistrations().get(0));
            assertEquals(expReg2, instance.getCurrentRegistrations().get(1));
        }catch (Exception e){
             
            System.err.println(e);
            
        }
       

    }
}
