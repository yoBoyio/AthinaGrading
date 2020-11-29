/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.models;

import athina.Account;
import java.util.ArrayList;

/**
 *
 * @author dimi44
 */
public class Student extends User{
     private int currentSemester;
    private String dateEnrolled;
    private  String am;
    
    public Student(String username,String password, String firstName,
        String lastName,int currentSemester,String am,String email) {
        super(username, password, firstName, lastName,email);
        this.currentSemester = currentSemester;
        this.am = am;
    }
    
  
    public CourseRegistration[] getBathmologies(String username){
        CourseRegistration courseRegistration[] = new CourseRegistration[Account.registrations.length];
        int y =0;
        for (int i = 0; i <Account.registrations.length; i++){
            if (Account.registrations[i] != null && username.equals(Account.registrations[i].getStudent().getUsername())){
                courseRegistration[y] = Account.registrations[i];
                y++;
            }
        }
        return courseRegistration;
    }
    
    public String getAM(){
        return am;
    }
     public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public String getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(String dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }
}
