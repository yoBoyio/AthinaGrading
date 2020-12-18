/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatters;
/**
 *
 * @author dimi44
 */
public class FormattedProfessorCourses {
    private String courseName;
    private int courseSemester;
    private int  credits;
    private String id;
    
   
    public FormattedProfessorCourses(String courseName, int courseSemester,String id,int credits) {
        this.courseName = courseName;
        this.courseSemester = courseSemester;
        this.id=id;
        this.credits=credits;
     
    }
    
    public String getCourseName() {
        return courseName;
    }

    public int getCourseSemester() {
        return courseSemester;
    }



    public int getCredits() {
        return credits;
    }

    public String getId() {
        return id;
    }


    
}