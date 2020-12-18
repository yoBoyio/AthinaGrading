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
public class FormattedStudent {
     private String am;
    private String name;
    private String surname;
    private float grade;

   
    public FormattedStudent(String am, String name,String surname,Float grade) {
        this.am = am;
        this.name = name;
        this.surname=surname;
        this.grade=grade;
     
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    
  
}
