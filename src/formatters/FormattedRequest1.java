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
public class FormattedRequest1 {
    private  String professorName;
    private  String studentName;
    private  float  oldGrade;
    private float newGrade;
    private String exam;
    private  String regid;
    private  int reqInxed;
    
    public FormattedRequest1(String professorName,String studentName,float  oldGrade,float newGrade,String exam,String regid,int reqInxed){
        this.professorName=professorName;
        this.studentName=studentName;
        this.oldGrade=oldGrade;
        this.newGrade=newGrade;
        this.exam=exam;
        this.regid=regid;
        this.reqInxed=reqInxed;
    }
    public  int getReqIndex(){
        return reqInxed;
    }
    public String getRegId(){
        return  regid;
    }
    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public float getOldGrade() {
        return oldGrade;
    }

    public void setOldGrade(float oldGrade) {
        this.oldGrade = oldGrade;
    }

    public float getNewGrade() {
        return newGrade;
    }

    public void setNewGrade(float newGrade) {
        this.newGrade = newGrade;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }
    
    
}
