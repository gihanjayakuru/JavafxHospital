/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.Admin;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author hasa
 */
public class AdminWindowController implements Initializable {
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        initDrawer();
    }    

    private void initDrawer() {
        try {
            VBox sidebar = FXMLLoader.load(getClass().getResource("/hospital/sidebar.fxml"));
            drawer.setSidePane(sidebar);
            //drawer.setDefaultDrawerSize(150);
        } catch (IOException ex) {
            Logger.getLogger(AdminWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event)->{
            
           
               task.setRate(task.getRate() * -1);
                
                task.play();
                if(drawer.isClosed()){
                    drawer.open();
                    //drawer.setMinWidth(200);
                }
                else{
                    drawer.close();
                   // drawer.setMinWidth(0);
                }
             
        });
    }
//    private void initDrawer() {
//    try {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hospital/sidebar.fxml"));
//        VBox sidebar = loader.load();
//        drawer.setSidePane(sidebar);
//        //AdminWindowController controller = loader.getController();
//        //controller.setBookReturnCallback(this);
//    } catch (IOException ex) {
//        Logger.getLogger(AdminWindowController.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
//    task.setRate(-1);
//    hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
//        drawer.toggle();
//    });
//    drawer.setOnDrawerOpening((event) -> {
//        task.setRate(task.getRate() * -1);
//        task.play();
//        drawer.toFront();
//    });
//    drawer.setOnDrawerClosed((event) -> {
//        drawer.toBack();
//        task.setRate(task.getRate() * -1);
//        task.play();
//    });
//}
}
