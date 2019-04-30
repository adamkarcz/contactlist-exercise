package sample;

import javafx.beans.property.SimpleStringProperty;

public class Contact {

    private SimpleStringProperty FirstName;
    private SimpleStringProperty LastName;
    private SimpleStringProperty PhoneNumber;
    private SimpleStringProperty Notes;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phoneNumber, String notes) {
        this.FirstName = new SimpleStringProperty(firstName);
        this.LastName = new SimpleStringProperty(lastName);
        this.PhoneNumber = new SimpleStringProperty(phoneNumber);
        this.Notes = new SimpleStringProperty(notes);
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = new SimpleStringProperty(firstName);
    }

    public String getLastName() {
        return LastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName= new SimpleStringProperty(lastName);
    }

    public String getPhoneNumber() {
        return PhoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = new SimpleStringProperty(phoneNumber);
    }

    public String getNotes() {
        return Notes.get();
    }

    public SimpleStringProperty notesProperty() {
        return Notes;
    }

    public void setNotes(String notes) {
        this.Notes = new SimpleStringProperty(notes);
    }
}
