/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author zoranjanjic
 * Example app
 */


public class Contract {

    private final StringProperty Firstname = new SimpleStringProperty(this, "Firstname", "");
    private final StringProperty Lastname = new SimpleStringProperty(this, "Lastname", "");
    private final StringProperty Address = new SimpleStringProperty(this, "Address", "");
    private final IntegerProperty Speed = new SimpleIntegerProperty(this, "Speed");
    private final StringProperty Flow = new SimpleStringProperty(this, "Flow", "Flow");
    private final IntegerProperty Contract = new SimpleIntegerProperty(this, "Contract");

    private int id;
    private static int c = 0;

    public Contract() {
    }

    public Contract(final String firstname, final String lastname, final String address, final int speed, final String flow, final int contract) {
        this.Firstname.set(firstname);
        this.Lastname.set(lastname);
        this.Address.set(address);
        this.Speed.set(speed);
        this.Flow.set(flow);
        this.Contract.set(contract);
        id = c++;

    }

    public int getId() {
        return id;
    }

    public StringProperty FirstnameProperty() {
        return Firstname;
    }

    public String getFirstname() {
        return Firstname.get();
    }

    public void setFirstname(String firstname) {
        this.Firstname.set(firstname);
    }

    public StringProperty LastnameProperty() {
        return Lastname;
    }

    public String getLastname() {
        return Lastname.get();
    }

    public void setLastname(String lastname) {
        this.Lastname.set(lastname);
    }

    public StringProperty AddressProperty() {
        return Address;
    }

    public String getAddress() {
        return Address.get();
    }

    public void setAddress(String address) {
        this.Address.set(address);
    }

    public IntegerProperty SpeedProperty() {
        return Speed;
    }

    public int getSpeed() {
        return Speed.get();
    }

    public void setSpeed(int speed) {
        this.Speed.set(speed);
    }

    public StringProperty FlowProperty() {
        return Flow;
    }

    public String getFlow() {
        return Flow.get();
    }

    public void setFlow(String flow) {
        this.Flow.set(flow);
    }

    public IntegerProperty ContractProperty() {
        return Contract;
    }

    public int getContract() {
        return Contract.get();
    }

    public void setContract(int contract) {
        this.Contract.set(contract);
    }

    public boolean Validan() { // Validates user input 

        boolean Validan = true;

        if (Firstname.get() != null && Firstname.get().equals("")) {

            Validan = false;
        }
        if ("".equals(Lastname.get())) {

            Validan = false;
        }
        if (Address.get().equals("")) {

            Validan = false;
        }
        return Validan;
    } // end of Validan()

    @Override
    public String toString() {
        return "Firstname= " + Firstname.get() + "\n Lastname= " + Lastname.get() + "\n Address= " + Address.get() + "\n Speed= " + Speed.get() + "\n Flow= " + Flow.get() + "\n Contract= " + Contract.get();
    }

}
