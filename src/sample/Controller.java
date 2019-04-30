package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {

    @FXML
    private GridPane mainGridPane;
    @FXML
    private TableView<Contact> tableView;
    @FXML
    private TableColumn<Contact,String> columnFirstName;
    @FXML
    private TableColumn<Contact,String> columnLastName;
    @FXML
    private TableColumn<Contact,String> columnPhoneNumber;
    @FXML
    private TableColumn<Contact,String> columnNotes;


    private ObservableList<Contact> contactsList;

    public void initialize(){
        contactsList = ContactData.getInstance().getContacts();
        tableView.setItems(contactsList);
        columnFirstName.setCellValueFactory(new PropertyValueFactory("FirstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory("LastName"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory("PhoneNumber"));
        columnNotes.setCellValueFactory(new PropertyValueFactory("Notes"));
    }


    @FXML
    public void handleAdd(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Add new Contact");
        dialog.setHeaderText("Use this dialog to create a new Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addwindow.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            AddController addController = fxmlLoader.getController();
            Contact newItem = addController.processResult();
            tableView.getSelectionModel().select(newItem);
        }
    }

    @FXML
    public void handleEdit(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        dialog.setHeaderText("Use this dialog to edit Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("editwindow.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        EditController editController = fxmlLoader.getController();
        editController.setContact(tableView.getSelectionModel().getSelectedItem());

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();



        if (result.isPresent() && result.get() == ButtonType.OK) {
            Contact editContact = tableView.getSelectionModel().getSelectedItem();
            editController.processResult(editContact);
            tableView.refresh();
        }
    }

    @FXML
    public void handleDelete(){
        Contact contact = tableView.getSelectionModel().getSelectedItem();
        deleteItem(contact);
    }


    public void  deleteItem(Contact contact){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText("Delete Contact: " + contact.getFirstName() + " " + contact.getLastName());
        alert.setContentText("Are you sure? Press OK to confirm or CANCEL to back out.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            ContactData.getInstance().deleteContact(contact);
        }
    }

}
