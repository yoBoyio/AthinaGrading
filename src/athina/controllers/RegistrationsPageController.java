/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.controllers;

import athina.Account;
import athina.Athina;
import athina.models.Course;
import athina.models.CourseRegistration;
import athina.models.Student;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimi44
 */
public class RegistrationsPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField usernameLabel, lastnameLabel, nameLabel, amLabel, examLabel, emailLabel, roleLabel, mesosOrosText,dmTextField, perasmMathField, sunoloDM, sunoloMath,errorField;
    @FXML
    private AnchorPane arxikhSelidaPanel, bathmologiesPanel, mathhmataPanel, dhlwseisPanel;
    @FXML
    private ListView bathmList = new ListView();
    @FXML
    private ListView mathhmataList = new ListView();
    @FXML
    private ListView olaTaMath = new ListView();
    @FXML
    private ListView epilegmenaMath = new ListView();
    @FXML
    private Button addBtn, removeBtn;
    @FXML
    private Label confirmText;
    private boolean firstTimeTree = true;
    private int dm = 0;
    private int arithmosMath = 0;
   
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          if (firstTimeTree){
            for (int i = 0; i < Account.courses.length; i++){
                if (Account.courses[i] != null && !toExeiDhlwsei(i)){
                    olaTaMath.getItems().add(Account.courses[i]);
                }
            }
        }
        firstTimeTree = false;
    
    }  
    private boolean toExeiDhlwsei(int y){
        Student student = (Student) Athina.user;
        for (int i = 0; i< Account.registrations.length; i++){
            if (Account.registrations[i] != null && Account.registrations[i].getStudent() == student && Account.registrations[i].getCourse() == Account.courses[y]) {
                return true;
            }
        }
        return false;
    }
    @FXML
    private void addMathima(ActionEvent event){
        Course course = (Course) olaTaMath.getSelectionModel().getSelectedItem();
        if (olaTaMath.getSelectionModel().getSelectedItem() != null && (course.getCredits() + dm) <= 42){
            epilegmenaMath.getItems().add(olaTaMath.getSelectionModel().getSelectedItem());
            dm+=course.getCredits();
            arithmosMath++;
            olaTaMath.getItems().remove(olaTaMath.getSelectionModel().getSelectedItem());
            sunoloDM.setText(String.valueOf(dm));
            sunoloMath.setText(String.valueOf(arithmosMath));
        }
    }
    @FXML
    private void removeMathima(ActionEvent event){
        if (epilegmenaMath.getSelectionModel().getSelectedItem() != null){
            olaTaMath.getItems().add(epilegmenaMath.getSelectionModel().getSelectedItem());
            Course course = (Course) epilegmenaMath.getSelectionModel().getSelectedItem();
            dm-=course.getCredits();
            arithmosMath--;
            epilegmenaMath.getItems().remove(epilegmenaMath.getSelectionModel().getSelectedItem());
            sunoloDM.setText(String.valueOf(dm));
            sunoloMath.setText(String.valueOf(arithmosMath));
        }
    }
    @FXML
     private void dhlwshMathhmatwn(){
        if (!epilegmenaMath.getItems().isEmpty()){
            for (int i = 0; i < epilegmenaMath.getItems().size(); i++){
                for (int j = 0; j < Account.registrations.length; j++){
                    if (Account.registrations[j] != null){
                        Course course = (Course)  epilegmenaMath.getItems().get(i);
                        String id =Account.registrations[j].getId()+i+1*j+1;
                        Account.registrations[j] = new CourseRegistration((Student) Athina.user, course, "2020-2021 XEIM",formatter.format(Calendar.getInstance().getTime()),id);
                        break;
                    }
                }
            }
        }
        confirmText.setVisible(true);
        addBtn.setDisable(true);
        removeBtn.setDisable(true);
    }
      public void backButtonPressed(ActionEvent event) {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/athina/views/MasterPage.fxml")));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Athina - Τα μαθηματα μου");
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
