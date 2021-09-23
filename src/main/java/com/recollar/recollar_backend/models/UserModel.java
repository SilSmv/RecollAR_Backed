package com.recollar.recollar_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "user")
public class UserModel {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUser;
    private String password;
    private String email;
    private Integer status;
    private Date txDate;
    private Integer txIdUser;
    private String txHost;
    private Date txUpdate;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "UserModel{" +
                "idUser=" + idUser +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", txDate=" + txDate +
                ", txIdUser=" + txIdUser +
                ", txHost='" + txHost + '\'' +
                ", txUpdate=" + txUpdate +
                '}';
    }
}
