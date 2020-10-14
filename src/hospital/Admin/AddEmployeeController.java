/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.Admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import hospital.Connection.MYCONNECTION;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author hasa
 */


public class AddEmployeeController implements Initializable {
    @FXML
    private JFXTextField EmployeeIDtxt;
    @FXML
    private JFXTextField EmployeeNametxt;
    @FXML
    private JFXRadioButton Male;
    @FXML
    private JFXRadioButton Femal;
    
    private ToggleGroup ToggleGroup1;
    @FXML
    private ComboBox comboBox;

    /**
     * Initializes the controller class.
     */
    static String gender;
    @FXML
    private JFXButton closeButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        ToggleGroup1 = new ToggleGroup();
       this.Femal.setToggleGroup(ToggleGroup1);
       this.Male.setToggleGroup(ToggleGroup1);
       
       comboBox.getItems().add("Doctor");
       comboBox.getItems().addAll("Nurse","Pharmecist","Manager");
       
       Male.setToggleGroup(ToggleGroup1);

       Femal.setToggleGroup(ToggleGroup1);
    
    
    }  
       
       
    
 

    @FXML
    private void SaveEmployeeBtn(ActionEvent event) {
        
        MYCONNECTION myconnection =new MYCONNECTION();
        
 
        
//        (ToggleGroup1.getSelectedToggle().toString())
        if(this.ToggleGroup1.getSelectedToggle().equals(this.Male)){
            gender ="Male";
        }
        if(this.ToggleGroup1.getSelectedToggle().equals(this.Femal)){
            gender = "Femal";
        }
     
       
//       Femal.getText().toString();
//
//        RadioButton rb1 = new RadioButton("Male");
//        rb1.setUserData("Male");
//        rb1.setToggleGroup(group);
//        rb1.setSelected(true);
//
//        RadioButton rb2 = new RadioButton("Femal");
//        rb2.setUserData("Femal");
//        rb2.setToggleGroup(group);
//        
//        String gender = group.getSelectedToggle().getUserData().toString();
        
        String position = comboBox.getValue().toString();
        String id = EmployeeIDtxt.getText().toString();
        String name = EmployeeNametxt.getText().toString();
        
        
        PreparedStatement st;
        ResultSet rs;
        String addQuery= "INSERT INTO `employees`(`id`, `name`, `position`, `gender`) VALUES (?,?,?,?)";
        
        try {
            st=myconnection.createConnection().prepareStatement(addQuery);
            
            st.setString(1, id);
            st.setString(2, name);
            st.setString(3, position);   
            st.setString(4, gender);
            
            
            if(st.executeUpdate()>0){
            System.out.println("successfully stored");
            //massage success!
            }
            
 
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
    }

    @FXML
    private void CancelEmployeeBtn(ActionEvent event) {
       Stage stage = (Stage) closeButton.getScene().getWindow();
  // do what you have to do
        stage.close();
    }
    
}
