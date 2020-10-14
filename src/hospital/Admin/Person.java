/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author hasa
 */
public class Person {
    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty position = new SimpleStringProperty();
    private final StringProperty gender = new SimpleStringProperty();

    public String getGender() {
        return gender.get();
    }

    public void setGender(String value) {
        gender.set(value);
    }

    public StringProperty genderProperty() {
        return gender;
    }
    
    

    public String getPosition() {
        return position.get();
    }

    public void setPosition(String value) {
        position.set(value);
    }

    public StringProperty PositionProperty() {
        return position;
    }
    
    

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }
    
    

    public String getId() {
        return id.get();
    }

    public void setId(String value) {
        id.set(value);
    }

    public StringProperty idProperty() {
        return id;
    }
    
}
