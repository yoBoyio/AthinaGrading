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
public class Exam {
    
    private Course [] courses;
    private String year;
    private String type;
    private  String id;
    
    public Exam (String year, String type,String id){
        this.year=year;
        this.type=type;
        this.id=id;
        this.courses=new Course[10];
    }
     
    
    public void  setCourse(Course course){
        
       
        int i =0;
        for(Course c: courses){
           if(c==null){
              this.courses[i]=course;
              course.setExam(this);
              break;
            }
           i++;
       }
    }
     public  ArrayList<Course> getCourses(){
        int i=0;
        ArrayList<Course> coursesList =new  ArrayList<>();
       
      while(courses[i]!=null){
            coursesList.add(this.courses[i]);
            i++;
        }
        return coursesList;
    }
    

    public void addCourses(Course course) {
        for(int i=0;i<courses.length;i++)
            if( courses==null ){
             courses[i] = course;
             break;
            }   
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
     public String getId() {
        return id;
    }
}
