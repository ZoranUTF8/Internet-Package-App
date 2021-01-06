/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author zoranjanjic
 */
public class ContractController {

    @FXML
    private TextField Firstname;
    @FXML
    private TextField Lastname;
    @FXML
    private TextField Address;
    @FXML
    private ChoiceBox Speed;
    @FXML
    private ChoiceBox Flow;
    @FXML
    private ChoiceBox Contract;
    @FXML
    private Button Submit_Btn;
    @FXML
    private Button Delete_Btn;
    @FXML
    private Button All_Contracts_Btn;

    @FXML
    Alert alertConfirmation = new Alert(Alert.AlertType.CONFIRMATION); // Alert object instance
    @FXML
    ObservableList<Contract> contracts = FXCollections.<Contract>observableArrayList(); // list for saving contracts
    @FXML
    Contract contract; // new Contract object

    @FXML
    TableView<Contract> table = new TableView<>(); // Table object instance with  type set as contract

    public ContractController() { // empty constructor for controller

    }

    @FXML //creates the Contract object and gets input values
    private void initialize() {
        contract = new Contract();

        Speed.setItems(FXCollections.observableArrayList(2, 5, 10, 20, 50, 100));
        Flow.setItems(FXCollections.observableArrayList("1", "5", "10", "50", "100", "FLAT"));
        Contract.setItems(FXCollections.observableArrayList(1, 2));

        Firstname.textProperty().bindBidirectional(contract.FirstnameProperty());
        Lastname.textProperty().bindBidirectional(contract.LastnameProperty());
        Address.textProperty().bindBidirectional(contract.AddressProperty());
        Speed.valueProperty().bindBidirectional((contract.SpeedProperty()));
        Flow.valueProperty().bindBidirectional(contract.FlowProperty());
        Contract.valueProperty().bindBidirectional(contract.ContractProperty());

    }

    @FXML
    private void saveContract() // if contract is valid saves the contract instance to ObservableList contracts
    {

        if (contract.Validan()) {

            contracts = table.getItems();
            contracts.add(new Contract(Firstname.getText(), Lastname.getText(), Address.getText(), Integer.parseInt(Speed.getSelectionModel().getSelectedItem().toString()), Flow.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(Contract.getSelectionModel().getSelectedItem().toString())));
            table.setItems(contracts);

            alertConfirmation.setTitle("Save confirmation");
            alertConfirmation.setContentText("Contract saved.");
            alertConfirmation.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Check your input!");
            alert.showAndWait();
        }
    }

    @FXML // Exits the Application
    private void exitApplication() {
        Platform.exit();
    }

    @FXML // Clears input fields
    private void clearInput() {

        Firstname.clear();
        Lastname.clear();
        Address.clear();
        Speed.getSelectionModel().clearSelection();
        Flow.getSelectionModel().clearSelection();
        Contract.getSelectionModel().clearSelection();

    }

    @FXML // Delete entry
    private void deleteEntry() {
        contracts = table.getItems();
        int itemIndex = table.selectionModelProperty().getValue().getSelectedIndex();
        contracts.remove(itemIndex);
        table.setItems(contracts);
    }

}
