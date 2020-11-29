package athina.controllers;

import athina.Account;
import athina.Athina;
import athina.models.Course;
import athina.models.CourseRegistration;
import athina.models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class StudentMainPage implements Initializable  {

    private TextField usernameLabel;

    @FXML
    private TextField lastnameLabel, nameLabel, examLabel, emailLabel, mesosOrosText,dmTextField, perasmMathField, sunoloDM, sunoloMath;
    private AnchorPane arxikhSelidaPanel;
    @FXML
    private AnchorPane bathmologiesPanel, dhlwseisPanel;
    @FXML
    private ListView bathmList = new ListView();
    private ListView mathhmataList = new ListView();
    private ListView olaTaMath = new ListView();
    private ListView epilegmenaMath = new ListView();

    private int dm = 0;
    private int arithmosMath = 0;
    private boolean firstTime = true;
    private boolean firstTimeTwo = true;
    private boolean firstTimeTree = true;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        if (firstTime){
            CourseRegistration[] courseRegistration;
            Student student = (Student) Athina.user;
            courseRegistration = student.getBathmologies(student.getUsername());
            float sum = 0;
            int count = 0;
            int dm = 0;
            for (int i =0; i<courseRegistration.length; i++){
                if (courseRegistration[i] != null){
                        bathmList.getItems().add((courseRegistration[i].toString()));
                        if (courseRegistration[i].getGrade()!= -1 && courseRegistration[i].getNewGrade()>= 5){
                            sum+= courseRegistration[i].getNewGrade();
                            dm+= courseRegistration[i].getCourse().getCredits();
                            count++;
                        }
                        else if (courseRegistration[i].getGrade()!= -1 && courseRegistration[i].getGrade()>= 5){
                            sum+= courseRegistration[i].getGrade();
                            dm+= courseRegistration[i].getCourse().getCredits();
                            count++;
                        }

                }

        }
            String mesosOros = String.format("%.2f", sum/count);
            mesosOrosText.setText(mesosOros);
            dmTextField.setText(String.valueOf(dm));
            perasmMathField.setText(String.valueOf(count));
        }
        firstTime = false;
    }
    private void setLabels(ActionEvent actionEvent) {
     
        arxikhSelidaPanel.setVisible(true);
        Student student = (Student) Athina.user;
        usernameLabel.setText(student.getUsername());
        lastnameLabel.setText(student.getLastName());
        nameLabel.setText(student.getFirstName());
        examLabel.setText(String.valueOf(student.getCurrentSemester()));
        emailLabel.setText(student.getEmail());
    }

    private void emfMathhmatwn(ActionEvent event){
        
        if (firstTimeTwo){
            for (int i =0; i< Account.courses.length; i++){
                if (Account.courses[i] != null )
                    mathhmataList.getItems().add(Account.courses[i]);
            }
        }
        firstTimeTwo = false;
    }

    private void dhlwseisMath(ActionEvent event){
        
        dhlwseisPanel.setVisible(true);
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
