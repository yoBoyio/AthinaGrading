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
public class Course {
    private  String id;
    private  String name;
    private  int credits;
    private int semester;
    private Professor professor;
    private  Exam [] exams;
   
    public  Course(String id){
        this.id=id;
    }
    public Course(String id, String name, int credits, int semester, Professor professor) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.semester = semester;
        this.professor = professor;
        this.exams=new Exam[30];
    }
    public void  setExam(Exam exam){
        
       
        int i =0;
        for(Exam e: exams){
           if(e==null){
              this.exams[i]=exam;
              break;
            }
           i++;
       }
    }
 public ArrayList<CourseRegistration> getCurrentRegistrations() {
        int i = 0;
        ArrayList<CourseRegistration> registrations = new ArrayList<>();
        
        while(Account.registrations[i] != null){
            if (Account.registrations[i].getCourse() == this){
                registrations.add(Account.registrations[i]);
            }
                
            i++;
        }
        
        return registrations;
    }
       
    
     public String getName() {
        return name;
    }
    public  ArrayList<Exam> getExams(){
        int i=0;
        ArrayList<Exam> examList =new  ArrayList<>();
       
      while(exams[i]!=null){
            examList.add(this.exams[i]);
            i++;
        }
        return examList;
    }
    public Course() {
    }

    public String getId() {
        return id;
    }
     public int getCredits() {
        return credits;
    }

    public int getSemester() {
        return semester;
    }
    public Professor getProfessor() {
        return professor;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
