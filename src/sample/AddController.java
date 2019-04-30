package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class AddController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField notes;


    public Contact processResult(){
        String firstName = this.firstName.getText().trim();
        String lastName = this.lastName.getText().trim();
        String phoneNumber = this.phoneNumber.getText().trim();
        String notes = this.notes.getText().trim();

        Contact newContact = new Contact(firstName,lastName,phoneNumber,notes);
        ContactData.getInstance().addContact(newContact);
        return newContact;
    }
}
