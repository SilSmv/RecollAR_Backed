package com.recollar.recollar_backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class AuthModel {

    @Id
    private String idUser;

    private String email;

    private String password;

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthModel{" +
                "idUser='" + idUser + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
