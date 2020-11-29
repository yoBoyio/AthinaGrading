/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.models;

import athina.models.Exam;
import java.util.ArrayList;

/**
 *
 * @author dimi44
 */
public class Examined {
    private  Exam examinationDate;
    private float  grade;

    

    public void setExaminationDate(Exam examinationDate) {
        this.examinationDate = examinationDate;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    public Exam getExam(){
        return examinationDate;
    }
    public Examined(Exam examinationDate,float  Grade){
        this.examinationDate=examinationDate;
        this.grade=grade;}
    
}
