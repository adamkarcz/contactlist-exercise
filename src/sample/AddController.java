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

    public Contact addContact(){
        String firstName = this.firstName.getText().trim();
        String lastName = this.lastName.getText().trim();
        String phoneNumber = this.phoneNumber.getText().trim();
        String notes = this.notes.getText().trim();

        Contact newContact = new Contact(firstName,lastName,phoneNumber,notes);
        ContactData.getInstance().addContact(newContact);
        return newContact;
    }

    public void setContact (Contact contact){
        firstName.setText(contact.getFirstName());
        lastName.setText(contact.getLastName());
        phoneNumber.setText(contact.getPhoneNumber());
        notes.setText(contact.getNotes());
    }

    public Contact editContact(Contact contact){
        contact.setFirstName(this.firstName.getText().trim());
        contact.setLastName(this.lastName.getText().trim());
        contact.setPhoneNumber(this.phoneNumber.getText().trim());
        contact.setNotes(this.notes.getText().trim());
        return contact;
    }
}
