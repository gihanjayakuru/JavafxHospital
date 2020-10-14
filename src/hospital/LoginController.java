/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hospital.Connection.MYCONNECTION;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author hasa
 */


public class LoginController implements Initializable {
    
    @FXML
    private TabPane tabPaneLogin;
    @FXML
    private Tab tabAdmin;
    @FXML
    private Tab tabDoctor;
    @FXML
    private Tab tabReception;
    @FXML
    private Tab tabPharmacist;
    @FXML
    private Tab tabStockManager;
    @FXML
    private Label lblAdmin;
    @FXML
    private Label lblReception;
    @FXML
    private Label lblDoctor;
    @FXML
    private Label lblPharmacist;
    @FXML
    private Label lblStockManager;
    @FXML
    private Label lblStatus;
    @FXML
    private Pane slidingPane;
    @FXML
    private JFXTextField AUsername;
    @FXML
    private JFXPasswordField APassword;
    @FXML
    private JFXTextField DUsername;
    @FXML
    private JFXPasswordField DPassword;
    @FXML
    private JFXTextField RUsername;
    @FXML
    private JFXPasswordField RPassword;
    @FXML
    private JFXTextField PUsername;
    @FXML
    private JFXPasswordField PPassword;
    @FXML
    private JFXTextField SUsername;
    @FXML
    private JFXPasswordField SPassword;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    } 

    @FXML
    private void close_app(MouseEvent event) {
        
        System.exit(0);     
    }

    private void closeAdminStage(){
        ((Stage) AUsername.getScene().getWindow()).close();

    }
    private void closeDoctorStage(){
        ((Stage) DUsername.getScene().getWindow()).close();

    }
    private void closeReceptionStage(){
        ((Stage) RUsername.getScene().getWindow()).close();

    }
    private void closePharmacistStage(){
        ((Stage) PUsername.getScene().getWindow()).close();

    }
    private void closeStockManagerStage(){
        ((Stage) SUsername.getScene().getWindow()).close();

    }
        
        
        
    
    private void LoadAdminWindow(){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/hospital/Admin/AdminWindow.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Admin");
            stage.setScene(new Scene(parent));
            stage.show();
            //hospital.setStageIcon(stage);
            
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void LoadDoctorWindow(){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/hospital/Admin/AdminWindow.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Doctor");
            stage.setScene(new Scene(parent));
            stage.show();
            //
            
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void LoadReceptionWindow(){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/hospital/ReceptionWindow.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Reception");
            stage.setScene(new Scene(parent));
            stage.show();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void LoadPharmacistWindow(){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/hospital/DashBoard.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pharmacy");
            stage.setScene(new Scene(parent));
            stage.show();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void LoadStockManagerWindow(){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/hospital/DashBoard.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("StockManager");
            stage.setScene(new Scene(parent));
            stage.show();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void loginAdmin(ActionEvent event) {
        
            MYCONNECTION myconnection =new MYCONNECTION();
            
            ResultSet rs;
            PreparedStatement ps;
            
            String username = AUsername.getText().toString();
            String password = APassword.getText().toString();
            
            String sql = "SELECT * FROM `admin` WHERE `user_name`= ? and `password`= ?";
            
            try {
                
            ps = myconnection.createConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if(rs.next()){
                closeAdminStage();
                LoadAdminWindow();//load admin window
            }
            else{
                AUsername.getStyleClass().add("wrong-credentails");
                APassword.getStyleClass().add("wrong-credentails");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void loginDoctor(ActionEvent event) {
        MYCONNECTION myconnection =new MYCONNECTION();
            
            ResultSet rs;
            PreparedStatement ps;
            
            String username = DUsername.getText().toString();
            String password = DPassword.getText().toString();
            
            String sql = "SELECT * FROM `doctor` WHERE `user_name`= ? and `password`= ?";
            
            try {
                
            ps = myconnection.createConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if(rs.next()){
                closeDoctorStage();
                LoadDoctorWindow();//load Doctor window
            }
            else{
                DUsername.getStyleClass().add("wrong-credentails");
                DPassword.getStyleClass().add("wrong-credentails");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    private void loginReception(ActionEvent event) {
        MYCONNECTION myconnection =new MYCONNECTION();
            
            ResultSet rs;
            PreparedStatement ps;
            
            String username = RUsername.getText().toString();
            String password = RPassword.getText().toString();
            
            String sql = "SELECT * FROM `reception` WHERE `user_name`= ? and `password`= ?";
            
            try {
                
            ps = myconnection.createConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if(rs.next()){
                closeReceptionStage();
                LoadReceptionWindow();//load reception window
            }
            else{
                RUsername.getStyleClass().add("wrong-credentails");
                RPassword.getStyleClass().add("wrong-credentails");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    private void loginPharmacist(ActionEvent event) {
        MYCONNECTION myconnection =new MYCONNECTION();
            
            ResultSet rs;
            PreparedStatement ps;
            
            String username = PUsername.getText().toString();
            String password = PPassword.getText().toString();
            
            String sql = "SELECT * FROM `pharmacist` WHERE `user_name`= ? and `password`= ?";
            
            try {
                
            ps = myconnection.createConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if(rs.next()){
                closePharmacistStage();
                LoadPharmacistWindow();//load Pharmacist window
            }
            else{
                PUsername.getStyleClass().add("wrong-credentails");
                PPassword.getStyleClass().add("wrong-credentails");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    private void loginStockManager(ActionEvent event) {
        MYCONNECTION myconnection =new MYCONNECTION();
            
            ResultSet rs;
            PreparedStatement ps;
            
            String username = SUsername.getText().toString();
            String password = SPassword.getText().toString();
            
            String sql = "SELECT * FROM `stockmanager` WHERE `user_name`= ? and `password`= ?";
            
            try {
                
            ps = myconnection.createConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if(rs.next()){
                closeStockManagerStage();
                LoadStockManagerWindow();//load StockManager window
            }
            else{
                SUsername.getStyleClass().add("wrong-credentails");
                SPassword.getStyleClass().add("wrong-credentails");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    private void openAdminTab(MouseEvent event) {
        TranslateTransition toLeftTransition = new TranslateTransition(new Duration(500), lblStatus);
        toLeftTransition.setToX(slidingPane.getTranslateX());
        toLeftTransition.play();
        toLeftTransition.setOnFinished((ActionEvent event2)->{
            lblStatus.setMinWidth(60);
            lblStatus.setText("Admin");
        });
        
        
        
    }

    @FXML
    private void openReceptionTab(MouseEvent event) {
        
       TranslateTransition toRightAnimation = new TranslateTransition(new Duration(500), lblStatus);
       toRightAnimation.setToX(slidingPane.getTranslateX()+(69));
       
       toRightAnimation.setToX(slidingPane.getTranslateX()+(69));
       toRightAnimation.play();
       toRightAnimation.setOnFinished((ActionEvent event1) -> {
           lblStatus.setMinWidth(60);
           lblStatus.setText("Reception");
       });
       tabPaneLogin.getSelectionModel().select(tabReception);
       
    }

    @FXML
    private void openDoctorTab(MouseEvent event) {
        
       TranslateTransition toRightAnimation = new TranslateTransition(new Duration(500), lblStatus);
       toRightAnimation.setToX(slidingPane.getTranslateX()+(138));
       
       toRightAnimation.setToX(slidingPane.getTranslateX()+(138));
       toRightAnimation.play();
       toRightAnimation.setOnFinished((ActionEvent event1) -> {
           lblStatus.setMinWidth(60);
           lblStatus.setText("Doctor");
       });
       tabPaneLogin.getSelectionModel().select(tabDoctor);
        
        
        
    }
    
    @FXML
    private void openPharmacistTab(MouseEvent event) {
        
       TranslateTransition toRightAnimation = new TranslateTransition(new Duration(500), lblStatus);
       toRightAnimation.setToX(slidingPane.getTranslateX()+(207));
       
       toRightAnimation.setToX(slidingPane.getTranslateX()+(207));
       toRightAnimation.play();
       toRightAnimation.setOnFinished((ActionEvent event1) -> {
           lblStatus.setMinWidth(60);
           lblStatus.setText("Pharmacist");
       });
       tabPaneLogin.getSelectionModel().select(tabPharmacist);
    }

    @FXML
    private void openStockManagerTab(MouseEvent event) {
        
       TranslateTransition toRightAnimation = new TranslateTransition(new Duration(500), lblStatus);
       toRightAnimation.setToX(slidingPane.getTranslateX()+(276));
       
       toRightAnimation.setToX(slidingPane.getTranslateX()+(276));
       toRightAnimation.play();
       toRightAnimation.setOnFinished((ActionEvent event1) -> {
           lblStatus.setMinWidth(80);
           lblStatus.setText("StockManager");
           
       });
       tabPaneLogin.getSelectionModel().select(tabStockManager);
    }




    
}