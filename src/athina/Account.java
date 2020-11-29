/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina;
import athina.models.Examined;
import  athina.models.*;
import java.io.IOException;
import java.util.ArrayList;
import models.SMTP;
/**
 *
 * @author dimi44
 */
public class Account {
    public static User[] users;
    public static Student[] students;
    public static Professor[] professors;
    public static Admin[] admins;
    public static Course[] courses;
    public static CourseRegistration[] registrations;
    public static Exam[] exams;
    public static  AitimaDiorthosisGrade requestNewGrade[];
    
    public Account() {
        students = new Student[50];
        professors = new Professor[20];
        admins = new Admin[10];
        courses = new Course[30];
        registrations = new CourseRegistration[10];
        exams= new Exam[10];
        requestNewGrade=new AitimaDiorthosisGrade[10];
    }
    
    public void initializeData(){
        students[0] = new Student("aalexiou","123", "Alexis", "Alexiou",3 ,"173903","aalexiou@it.teithe.gr");
        students[1] = new Student("ddimitriou","123", "Dimitris", "Dimitriou",5 ,"165306","ddimitriou@it.teithe.gr");
        students[2] = new Student("nnikou", "123","Nikos", "Nikou",3, "185401","nnikou@it.teithe.gr");
        
        professors[0] = new Professor("vkostogl","123", "Vasileios", "Kostoglou","vkostogl@teithe.gr");
        professors[1] = new Professor("idel", "123","Ignatios", "Deligianis","idel@teithe.gr");
        professors[2] = new Professor("stoug", "123","Stefanos", "Ougiaroglou","stoug@teithe.gr");
        
            admins[0] = new Admin("gkakou", "123","Georgia", "Kakou","gkakou@it.teithe.gr");
        
        courses[0] = new Course("072", "Epixeirisiaki Ereuna", 6, 7, professors[0]);
        courses[1] = new Course("023", "Antikeimenostrefis Programmatismos", 6, 2, professors[1]);
        courses[2] = new Course("071", "Mhxaniki Logismikou", 6,7, professors[1]);
        courses[3] = new Course("044", "Sxediash Leitourgikwn Systimatwn", 6, 4, professors[2]);
        
        registrations[0] = new CourseRegistration(students[0], courses[0], "2018-19 ΕΑΡ","20/5/2019","r1");
        registrations[1] = new CourseRegistration(students[1], courses[1], "2018-19 XEIM","20/11/2020","r2");
        registrations[2] = new CourseRegistration(students[2], courses[2], "2018-19 ΕΑΡ","20/5/2019","r3");
        registrations[3] = new CourseRegistration(students[2], courses[3], "2018-19 XEIM","20/11/2020","r4");
        
        
        
        exams[0]= new Exam("2019", "Β ΕΑΡ","EB1");
        exams[1] = new Exam("2019","Α XEIM","AX1");
        exams[2] = new Exam( "2020","Α ΕΑΡ","AE3");
        exams[3] = new Exam( "2019","Α ΕΑΡ","AE2"); 
        exams[4]= new Exam("2018", "Α ΕΑΡ","AE1");
        
        registrations[1].setGrade(5);
        
        registrations[1].setExamined(new Examined(exams[0], 5f));
        registrations[2].setExamined(new Examined(exams[1], 6));
        exams[0].setCourse(courses[1]);
        exams[4].setCourse(courses[1]);
        exams[1].setCourse(courses[2]);
    }
    
    public static void newRequest(AitimaDiorthosisGrade request) {
        for (int i=0; i<requestNewGrade.length; i++){
            if (requestNewGrade[i] == null)
                requestNewGrade[i] = request;
                break;
        }
    }
    
   public static ArrayList <AitimaDiorthosisGrade> getRequests() {
       ArrayList <AitimaDiorthosisGrade> fullReq=new ArrayList();
        int i =0;
        for(AitimaDiorthosisGrade req : requestNewGrade){
            
            if (req != null) 
                fullReq.add(req);
            i++;
        }
        return fullReq;
    }
    public static Course[] getFullCourse() {
        Course fullCourse[]=new Course[30];
        int i =0;
        for(Course course : courses){
            
            if (course == null)
                break;
            fullCourse[i] = course;
            i++;
               
        }
        return fullCourse;
    }
    
    public static void insertAdmin(Admin admin) {
        for (int i=0; i<admins.length; i++){
            if (admins[i] == null){
                admins[i] = admin;
                SMTP.sendEmail(admins[i].getFirstName(), admins[i].getLastName(), admins[i].getUsername(),admins[i].getPassword(), admins[i].getEmail());
                break;
            }

        }
    }
    
    
    public static void insertProfessor(Professor professor) {
        for (int i=0; i<professors.length; i++){
            if (professors[i] == null){
                professors[i] = professor;
                SMTP.sendEmail(professors[i].getFirstName(), professors[i].getLastName(), professors[i].getUsername(), professors[i].getPassword(), professors[i].getEmail());
                break;
            }

        }
    }
     public static void insertStudent(Student student) {
        for (int i=0; i<students.length; i++) {
            if (students[i] == null){
                students[i] = student;
                System.out.println(student.getAM());
                SMTP.sendEmail(Account.students[i].getFirstName(),Account.students[i].getLastName(),Account.students[i].getUsername(),Account.students[i].getPassword(), Account.students[i].getAM());
                break;
            }

        }
    }
    private static boolean courseExists(String id)
    {
        for(Course course : courses)
        {
            if (course == null)
                break;
            
            if (course.getId().equals(id))
                return true;
        }
        return false;
    }
    
}
