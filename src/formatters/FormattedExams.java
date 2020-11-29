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
public class FormattedExams {
    private String year;
    private  String type;
    private  String id;
    
    
   
    public FormattedExams(String year, String type,String id) {
        this.year = year;
        this.type = type;
        this.id=id;
    }
    
    public String getId() {
        return id;
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
    
    
}