package com.recollar.recollar_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "person")
public class PersonModel {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPerson;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private Integer status;
    private Date txDate;
    private Integer txIdUser;
    private String txHost;
    private Date txUpdate;

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public void setTransaction(Transaction transaction){
        this.txDate=transaction.getTxDate();
        this.txHost=transaction.getTxHost();
        this.txIdUser=transaction.getTxIdUser();
        this.txUpdate=transaction.getTxUpdate();
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "idPerson=" + idPerson +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", status=" + status +
                ", txDate=" + txDate +
                ", txIdUser=" + txIdUser +
                ", txHost='" + txHost + '\'' +
                ", txUpdate=" + txUpdate +
                '}';
    }
}
