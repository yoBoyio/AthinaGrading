/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.models;

import java.util.ArrayList;

/**
 *
 * @author dimi44
 */
public class CourseRegistration {
    private Student student;
    private Course course;
    private String registrationSemester;
    private float grade;
    private Examined examined [];
    private String dateRegistered;
    private String id;
    private float newGrade;
    
    
    public CourseRegistration(Student student, Course course, String registrationSemester,String dateRegistered,String id) {
        this.student = student;
        this.course = course;
        this.registrationSemester = registrationSemester;
        this.dateRegistered = dateRegistered;
        this.examined=new Examined[10];
        this.id=id;
        grade=-1;
        newGrade=-1;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setNewGrade(float newGrade) {
        this.newGrade = newGrade;
    }
    public String getId(){
        return id;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    
    public String getRegistrationSemester() {
        return registrationSemester;
    }
    public void setGrade(float grade) {
        this.grade = grade;
      
    }
    
    public void setExamined(Examined examination) {
       int i =0;
        for(Examined e: examined){
           if(e==null){
              this.examined[i]=examination;
              break;
            }
           i++;
       }
    }
    
    public ArrayList<Examined> getExamined() {
       
        int i=0;
        ArrayList<Examined> examList =new  ArrayList<>();
       
      while(examined[i]!=null){
            examList.add(this.examined[i]);
            i++;
        }
        return examList;
    }
    
    public String getDateRegistered() {
                return dateRegistered;
    }

    public float getGrade() {
        return grade;
    }

     public String toString2() {
        return
                " bathmos=" + grade +
                ", kainBathmos=" + newGrade ;
    }

    public float getNewGrade() {
        return newGrade;
    }
     
    @Override
    public String toString() {
        if (grade != -1) {
            if (newGrade != -1){
                return
                        course + " | " +
                        "" + registrationSemester + '\'' +" | " +
                        " " + grade + "-παλιός " + " | " + newGrade + "-νεος" ;
            }
            return " " +
                    course + " | " +
                    " " + registrationSemester + " | " + '\''  + "" + grade;
        }
        return "";
    }
}
