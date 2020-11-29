package athina.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import athina.Account;
import athina.Athina;
import athina.models.Admin;
import athina.models.Professor;
import athina.models.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.*;

/**
 * FXML Controller class
 *
 * @author dimi44
 */
public class RegisterNewUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField  nameField, lastnameField, emailField, examField;
    @FXML
    private ChoiceBox userRolle = new ChoiceBox();
    @FXML
    private Label nameLabelEgr, lastnameLabelEgr, emailLabelEgr, examLabelEgr;
    @FXML
    private Button egrBtn;
    private boolean first = true;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    @FXML
    private AnchorPane userEnrollPanel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       if (first){
            userRolle.getItems().add("Φοιτητής");
            userRolle.getItems().add("Καθηγητής");
            userRolle.getItems().add("Γραματεία");
        }
        userRolle.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                nameLabelEgr.setVisible(true); lastnameLabelEgr.setVisible(true); emailLabelEgr.setVisible(true);
                nameField.setVisible(true); lastnameField.setVisible(true); emailField.setVisible(true);
                examLabelEgr.setVisible(false); examField.setVisible(false);
                egrBtn.setVisible(true);
                if (userRolle.getValue().equals("Φοιτητής")){
                    examLabelEgr.setVisible(true); examField.setVisible(true);
                }
            }
        });
        first = false;
    }    
  @FXML
    private void addEgr(ActionEvent event) throws IOException{
        userEnrollPanel.setVisible(true);
        if (userRolle.getValue().equals("Φοιτητής")){
            Student temp = new Student(nameField.getText().substring(0,1) + lastnameField.getText(), "123", nameField.getText(), lastnameField.getText(),Integer.parseInt(examField.getText())," 1234", emailField.getText());
                Account.insertStudent(temp);

        }else if(userRolle.getValue().equals("Καθηγητής")){
            Professor temp = new Professor(nameField.getText().substring(0,1) + lastnameField.getText(),
                    "123", nameField.getText(), lastnameField.getText(), emailField.getText());
            Account.insertProfessor(temp);
        }else{
            Admin temp = new Admin(nameField.getText().substring(0,1) + lastnameField.getText(),
                    "123", nameField.getText(), lastnameField.getText(), emailField.getText());
            Account.insertAdmin(temp);
        }
    }

    @FXML
    public void backButtonPressed(ActionEvent event) {
        try {
          //  DiorthosiVathmologiasPage.selectedRegistration = selectedRegistration;
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/athina/views/MasterPage.fxml")));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Athina");
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
