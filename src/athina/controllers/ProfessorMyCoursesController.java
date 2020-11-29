/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.controllers;

import athina.models.Examined;
import athina.Account;
import athina.Athina;
import athina.models.CourseRegistration;
import athina.models.Professor;
import  athina.models.Course;
import athina.models.Exam;
import athina.models.Student;
import formatters.FormattedExams;
import formatters.FormattedProfessorCourses;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimi44
 */
public class ProfessorMyCoursesController implements Initializable {
    
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<FormattedProfessorCourses> tableCourse;
    @FXML
    private TableColumn<FormattedProfessorCourses, String> courseCol;
    @FXML
    private TableColumn<FormattedProfessorCourses, Integer> semesterCol;
    @FXML
    private TableColumn<FormattedProfessorCourses, String> idCol;
    @FXML
    private TableColumn<FormattedProfessorCourses, Integer> ectsCol;
    @FXML
    private  Label examLbl;
    @FXML
    private  TableView<FormattedExams> tableExams;
    @FXML
    private TableColumn<FormattedExams, String> typeColumn;
      @FXML
    private TableColumn<FormattedExams, String> yearColumn;
    @FXML
    private Button selectExamBtn;
     @FXML
    private Label amLbl;
      @FXML
    private Label errorLbl;
      @FXML
     private Button  searchStdBtn;
      @FXML
    private TextField amField;
      
    private  Course ncCourse;
    private  ArrayList <Course> myCourses;
    public  CourseRegistration selectedReg;
    private Exam globExam;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        courseCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
       semesterCol.setCellValueFactory(new PropertyValueFactory<>("courseSemester"));
       idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
       ectsCol.setCellValueFactory(new PropertyValueFactory<>("credits"));
       Professor professor = (Professor)Athina.user;
        myCourses = professor.getCoursesTaught();
       tableCourse.setItems(formattCourses(myCourses));
       tableCourse.getSortOrder().add(semesterCol);

        tableExams.setVisible(false);
        selectExamBtn.setVisible(false);
        amField.setVisible(false);
        amLbl.setVisible(false);
        searchStdBtn.setVisible(false);
        
    }    
    
    private ObservableList<FormattedProfessorCourses> formattCourses (ArrayList<Course> courses) {
        
        ObservableList<FormattedProfessorCourses> list = FXCollections.observableArrayList();
        String name = "";
        int semester = 0;
        String id="";
        int ects;
        for(Course r: courses){
            name = r.getName();
            semester = r.getSemester();
            id = r.getId();
            ects = r.getCredits();
            list.add(new FormattedProfessorCourses(name, semester,id,ects));
        }
        
        return list;
    }
     public void backButtonPressed(ActionEvent event) {
        try{
            Scene scene = new Scene (FXMLLoader.load(getClass().getResource("/athina/views/MasterPage.fxml")));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setResizable(false);
            window.setTitle("Athina");
            window.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
     
    public void displayExamsCourse(ActionEvent event){
         FormattedProfessorCourses formattedProfessorCourses= tableCourse.getSelectionModel().getSelectedItem();
         
         if (formattedProfessorCourses==null){
             
             errorLbl.setText("Επιλεξτε μαθημα");
         }else{
            errorLbl.setText("");

            tableExams.setVisible(true);
            selectExamBtn.setVisible(true);
            typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
            String course  = formattedProfessorCourses.getCourseName();
            examLbl.setText(course);
             ncCourse = null;
            for (Course c : myCourses){
                if (c.getName().equals(course)){
                    ncCourse=c;
                }
            }
            ArrayList <Exam> examinedArrayList=ncCourse.getExams();
            tableExams.setItems(formattExams(examinedArrayList));
            tableExams.getSortOrder().add(yearColumn);             
         }
         
    }
    private ObservableList<FormattedExams> formattExams (ArrayList<Exam> exams) {
        
        ObservableList<FormattedExams> list = FXCollections.observableArrayList();
        String year = "";
        String type = "";
        String id="";
        for(Exam e: exams){
            year =e.getYear();
            type = e.getType();  
            id = e.getId();
            list.add(new FormattedExams(year, type,id));
        }     
        return list;
    }
    public void displayAMform(ActionEvent event){
       FormattedExams formattedExams= tableExams.getSelectionModel().getSelectedItem();

        if (formattedExams!=null) {
            errorLbl.setText("");
            amField.setVisible(true);
            amLbl.setVisible(true);
            searchStdBtn.setVisible(true);

        }else{
            errorLbl.setText("Επιλεξτε εξεταστικη");
        }  
    }
    
    public  void searchAM(ActionEvent event) {
        
        FormattedExams formattedExams= tableExams.getSelectionModel().getSelectedItem();
        String selectedId=formattedExams.getId();
        String am=amField.getText();
        if (!am.isEmpty()){
            CourseRegistration [] cr= Account.registrations ;
            for(CourseRegistration c:cr){
                if (c!=null) {
                   if(c.getStudent().getAM().equals(am) && c.getCourse()==ncCourse ){
                      ArrayList<Examined> currentE= c.getExamined();
                       for (Examined e: currentE) {
                          Exam sExam= e.getExam();
                           if(sExam.getId().equals(selectedId)){
                                 selectedReg=c;
                                 globExam= sExam;
                                 gotoDiorthosi(event);
                                 break;
                           }
                        }
                    }
                      
                }else{
                    errorLbl.setText("Το ΑΜ δεν βρεθηκε για την επιλεγμενη εξεταστικη");
                }
            }
        }else if(am.isEmpty())
            errorLbl.setText("Συμπληρωστε ΑΜ");
        else
           errorLbl.setText("Το ΑΜ δεν βρεθηκε");

    }
    
    public void gotoDiorthosi(ActionEvent event){
        try {
            DiorthosiVathmologiasPage.selectedRegistration = selectedReg;
            DiorthosiVathmologiasPage.globExam=globExam;
            Scene scene = new Scene (FXMLLoader.load(getClass().getResource("/athina/views/DiorthosiVathmologiasPage.fxml")));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setResizable(false);
            window.setTitle("Athina");
            window.show();
      
        }catch(IOException e){
            e.printStackTrace();

        }
    }
}

