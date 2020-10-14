/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.Admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import hospital.Connection.MYCONNECTION;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javax.swing.table.DefaultTableModel;

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
    @FXML
    private TableColumn<Person, String> colID;
    @FXML
    private TableColumn<Person, String> colName;
    @FXML
    private TableColumn<Person, String> colPosition;
    @FXML
    private TableColumn<Person, String> colGender;
    @FXML
    private TableColumn colEdit;

    private ObservableList<Person> list;
    @FXML
    private TableView<Person> tablePerson;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        initDrawer();
        
        populateTableView();

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
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {

            task.setRate(task.getRate() * -1);

            task.play();
            if (drawer.isClosed()) {
                drawer.open();
                //drawer.setMinWidth(200);
            } else {
                drawer.close();
                // drawer.setMinWidth(0);
            }

        });
    }

    private void populateTableView() {

        list = FXCollections.observableArrayList();

        MYCONNECTION myconnection = new MYCONNECTION();

        try {

            PreparedStatement ps;
            ResultSet rs;
            String selectQuery = "SELECT * FROM `employees`";

            ps = myconnection.createConnection().prepareStatement(selectQuery);

            rs = ps.executeQuery();

            Object[] row;

            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getString("id"));
                person.setName(rs.getString("name"));
                person.setPosition(rs.getString("position"));
                person.setGender(rs.getString("gender"));

                list.add(person);

            }
            colID.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
            colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            
            //cell button
            Callback<TableColumn<Person,String>,TableCell<Person,String>> cellFactory=(param) ->{
                
                final TableCell<Person,String> cell = new TableCell<Person,String>(){
                    
                    @Override
                    public void updateItem(String Item, boolean empty){
                        
                        super.updateItem(Item, empty);
                        
                        if(empty){
                            
                            setGraphic(null);
                            setText(null);
                        
                        }
                        else{
                            
                            final JFXButton editButton = new JFXButton("EDIT");
                            editButton.setOnAction(event ->{
                            
                            Person p = getTableView().getItems().get(getIndex());
                            
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("You\n"+p.getId()+p.getName()+"\n"+p.getPosition()+"\n"+p.getGender());
                            alert.show();
                            
                        });
                           setGraphic(editButton);
                           setText(null);
                        } 
                    }
                };
            
                return cell;
            };
            
            colEdit.setCellFactory(cellFactory);
            
            //set data to table
            tablePerson.setItems(list);
            

        } catch (SQLException ex) {
            Logger.getLogger(AdminWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}


