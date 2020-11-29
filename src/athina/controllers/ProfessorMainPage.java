package athina.controllers;

import athina.Account;
import athina.Athina;
import athina.models.Admin;
import athina.models.Course;
import athina.models.Professor;
import athina.models.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class ProfessorMainPage implements Initializable {

    @FXML
    private AnchorPane arxikhSelidaPanel, mathhmataPanel;
    @FXML
    private TextField usernameLabel, lastnameLabel, nameLabel, emailLabel, amField;
    @FXML
    private ChoiceBox choiceBoxMath, choiceBoxHmer;
    @FXML
    private ListView studensList;
    @FXML
    private Button searchBtn;
    @FXML
    private TextArea statistics;
    @FXML
    private ToggleGroup group;


    private float sumBathmwn = 0;
    private int sumFoitPouEdwsan = 0;
    private int sumFoit = 0;
    private int toPerasan = 0;
   
 
    private void setLabels(ActionEvent actionEvent) {
        Professor professor = (Professor) Athina.user;
        usernameLabel.setText(professor.getUsername());
        lastnameLabel.setText(professor.getLastName());
        nameLabel.setText(professor.getFirstName());
        emailLabel.setText(professor.getEmail());
    }

    @Override
   public void initialize(URL url, ResourceBundle rb) {
        choiceBoxMath.getItems().clear();
        choiceBoxHmer.getItems().clear();
        studensList.getItems().clear();
        statistics.clear();
        Professor professor= (Professor)Athina.user;
        ArrayList <Course> pCourses= professor.getCoursesTaught();
        for (int i = 0; i< Account.courses.length; i++){
            if (Account.courses[i] != null && Athina.user.getUsername().equals(Account.courses[i].getProfessor().getUsername())){
                choiceBoxMath.getItems().add(Account.courses[i].getName());
            }
        }
        choiceBoxMath.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                choiceBoxHmer.getItems().clear();
                getHmerom((String) choiceBoxMath.valueProperty().getValue());
            }
        });
    }

    private void getHmerom(String courseName) {
        for (int i = 0; i < Account.registrations.length; i++) {
            if (Account.registrations[i] != null && Account.registrations[i].getCourse().getName().equals(courseName)) {
                if (!choiceBoxHmer.getItems().contains(Account.registrations[i].getRegistrationSemester())) {
                    choiceBoxHmer.getItems().add(Account.registrations[i].getRegistrationSemester());
                }
            }
        }
        choiceBoxHmer.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                studensList.getItems().clear();
                getStudens((String) choiceBoxMath.valueProperty().getValue(), (String) choiceBoxHmer.valueProperty().getValue());
            }
        });
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
    private void getStudens(String course, String hmer){
        sumFoitPouEdwsan = 0;
        sumBathmwn = 0;
        sumFoit = 0;
        toPerasan = 0;
        statistics.clear();
        for (int i = 0; i < Account.registrations.length; i++){
            if (Account.registrations[i] != null && Account.registrations[i].getCourse().getName().equals(course) &&Account.registrations[i].getRegistrationSemester().equals(hmer)){
                studensList.getItems().add(Account.registrations[i].getStudent().getUsername() + " " + Account.registrations[i].getStudent().getFirstName() + " " +
                        Account.registrations[i].getStudent().getLastName() + " " + Account.registrations[i].getGrade());
                        sumFoit++;
                        if (Account.registrations[i].getGrade()!=-1 && Account.registrations[i].getNewGrade()== -1){
                            sumFoitPouEdwsan++;
                            sumBathmwn+= Account.registrations[i].getGrade();
                            if (Account.registrations[i].getGrade()>=5) toPerasan++;
                        }else if (Account.registrations[i].getGrade()!=-1 && Account.registrations[i].getGrade()!= -1){
                            sumFoitPouEdwsan++;
                            sumBathmwn+=Account.registrations[i].getGrade();
                            if (Account.registrations[i].getNewGrade()>=5) toPerasan++;
                        }
            }
        }statistics.setText("Μέσος όρος: \t" +  String.format("%.2f", sumBathmwn/sumFoitPouEdwsan) + "\n"
                            + "Σύνολο φοιτητών που το δήλωσαν: \t" + sumFoit + "\n"
                            + "Σύνολο φοιτητών που έγραψαν: \t" + sumFoitPouEdwsan + "\n"
                            + "Σύνολο φοιτητών που το πέρασαν: \t" + toPerasan);
    }

    @FXML
    private void searchStudent(ActionEvent event){
        for (int j = 0; j< Account.registrations.length; j++){
            if (Account.registrations[j] != null && Account.registrations[j].getStudent().getUsername().equals(amField.getText())){
                studensList.getItems().clear();
                studensList.getItems().add(Account.registrations[j]);
                statistics.clear();
            }
        }
    }

   




}
