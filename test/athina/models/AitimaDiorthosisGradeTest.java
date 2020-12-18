/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.models;

import athina.Account;
import static athina.Account.courses;
import static athina.Account.professors;
import static athina.Account.requestNewGrade;
import static athina.Account.students;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dimi44
 */
public class AitimaDiorthosisGradeTest {
    private static AitimaDiorthosisGrade instance ;
    private Account  data;
    private Student student;
    
    public AitimaDiorthosisGradeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Professor professor= new Professor("vkostogl","123", "Vasileios", "Kostoglou","vkostogl@teithe.gr");
        Student student= new Student("aalexiou","123", "Alexis", "Alexiou",3 ,"173903","aalexiou@it.teithe.gr");
        Course course=new Course("072", "Epixeirisiaki Ereuna", 6, 7,professor);
        CourseRegistration courseRegistration=new CourseRegistration(student,  course, "2018-19 ΕΑΡ","20/5/2019","r1");
        courseRegistration.setGrade(4);
        Exam exam =new Exam("2019", "Β ΕΑΡ","EB1");
         instance = new AitimaDiorthosisGrade(courseRegistration, professor, 0, exam);
         instance.setGrade(5);
         Account account = new Account();
    }
    
    
  
    @Test
    public void testGetGrade() {
       try{
        
        float oldGrade=instance.getCourseRegistration().getGrade();
        float newGrade=instance.getGrade();
        
        int expSize = 5;
        int high = 10;
        int low = 0;
        
        assertTrue("Error, grade is too high", high >= newGrade);
        assertTrue("Error, grade is too low",  low  <= newGrade);
        assertFalse("Error, grade cant be the same", oldGrade == newGrade);
         
        }catch (Exception e){
             
            System.err.println(e);
            
        }
       
    }

    /**
     * Test of setGrade method, of class AitimaDiorthosisGrade.
     */

}
