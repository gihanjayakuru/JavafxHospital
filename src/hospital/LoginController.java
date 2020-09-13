/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author hasa
 */
public class LoginController implements Initializable {
    private JFXTextField txtUsername;
    private JFXTextField txtPassword;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void close_app(MouseEvent event) {
        
        System.exit(0);     
    }


    
    private boolean isLoginDetailsCorrect(){
                if(txtUsername.getText().equals("") && txtPassword.getText().equals(""))
                {
                    return true;
                }else{
                    return false;
                }     
        }

    private void logIn(ActionEvent event) {
        
        String id = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        //String table = cmb to select table database doctor,admin,reception
        
    }

    @FXML
    private void loginAdmin(ActionEvent event) {
    }

    @FXML
    private void loginDoctor(ActionEvent event) {
    }

    @FXML
    private void loginReception(ActionEvent event) {
    }

    @FXML
    private void loginPharmecist(ActionEvent event) {
    }

    @FXML
    private void loginStockManager(ActionEvent event) {
    }

}