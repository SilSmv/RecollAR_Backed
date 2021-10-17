package com.recollar.recollar_backend.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserInformationModel extends User {
    private Integer idUser;
    private Integer idCollector;
    private Integer idPerson;
    private String email;

    public UserInformationModel(String username,Integer idUser,Integer idCollector,String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.idCollector=idCollector;
        this.idUser=idUser;
        this.email=username;
    }


    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdCollector() {
        return idCollector;
    }

    public void setIdCollector(Integer idCollector) {
        this.idCollector = idCollector;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public String toString() {
        return "UserInformationModel{" +
                "idUser=" + idUser +
                ", idCollector=" + idCollector +
                ", email='" + email + '\'' +
                '}';
    }
}
