package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField notes;

    public void setContact (Contact contact){
        firstName.setText(contact.getFirstName());
        lastName.setText(contact.getLastName());
        phoneNumber.setText(contact.getPhoneNumber());
        notes.setText(contact.getNotes());
    }

    public Contact processResult(Contact contact){
        contact.setFirstName(this.firstName.getText().trim());
        contact.setLastName(this.lastName.getText().trim());
        contact.setPhoneNumber(this.phoneNumber.getText().trim());
        contact.setNotes(this.notes.getText().trim());
        return contact;
    }
}
