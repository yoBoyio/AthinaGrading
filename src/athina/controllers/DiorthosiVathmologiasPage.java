/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.controllers;

import athina.models.Examined;
import athina.Account;
import athina.Athina;
import athina.models.AitimaDiorthosisGrade;
import athina.models.Course;
import athina.models.CourseRegistration;
import athina.models.Exam;
import athina.models.Professor;
import athina.models.Student;
import formatters.FormattedProfessorCourses;
import formatters.FormattedStudent;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimi44
 */
public class DiorthosiVathmologiasPage implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static  CourseRegistration selectedRegistration;
        public  static Exam globExam;

    @FXML
    private TableView<FormattedStudent> gradeTable;
    @FXML
    private TableColumn<FormattedStudent, String> amCol;
    @FXML
    private TableColumn<FormattedStudent, String> nameCol;
    @FXML
    private TableColumn<FormattedStudent, Float> gradeCol;
    @FXML
    private TableColumn<FormattedStudent, String> surnameCol;
    @FXML
    private  TextField newGradeLbl;
    @FXML
    private  Label errorLbl;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        amCol.setCellValueFactory(new PropertyValueFactory<>("am"));
       nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
       gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
       surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
       
       gradeTable.setItems(formattStudent(selectedRegistration));
      

     
        
    }    
     private ObservableList<FormattedStudent> formattStudent(CourseRegistration courseRegistration) {
        
        ObservableList<FormattedStudent> list = FXCollections.observableArrayList();
        String name = "";
        String am="";
        String surname="";
        float grade =0;
        Student student=courseRegistration.getStudent();
        name = student.getFirstName();
        am =student.getAM();
        surname = student.getLastName();
         grade = courseRegistration.getGrade();
        ArrayList<Examined> e=courseRegistration.getExamined();
//        for(Examined ex:e){
//                if (ex.getExam().getId().equals(globExam.getId())){ 
//                    grade=ex.getGrade();
//                    break;}
//         }
        list.add(new FormattedStudent(am,name, surname,grade));
        return list;
    }
       public void backButtonPressed(ActionEvent event) {
        try {
          //  DiorthosiVathmologiasPage.selectedRegistration = selectedRegistration;
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/athina/views/ProfessorMyCourses.fxml")));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Athina - Τα μαθηματα μου");
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      public void submitNewGrade(ActionEvent event){
         
          if(newGradeLbl.getText().isEmpty()){ 
              errorLbl.setText("Συμπληρωστε τον βαθμο");
              return;}
          try{
               Float grade=Float.parseFloat(newGradeLbl.getText());
               if (grade>10 || grade<0) {
                   errorLbl.setText("Ο βαθμος πρεπει να ειναι μεταξυ 0-10");
                    return;
                 }
                 errorLbl.setText("Το αιτημα σας υποβλθηκε στην γραμματεια");
                Professor professor= (Professor)Athina.user;
                AitimaDiorthosisGrade newReq=new AitimaDiorthosisGrade(selectedRegistration, professor, grade,globExam);
                Account.newRequest(newReq);
          }catch(NumberFormatException e){
              errorLbl.setText("Ωχ κατι πηγε στραβα");
          }
             
      }
      
}
