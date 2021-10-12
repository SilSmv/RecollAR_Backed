package com.recollar.recollar_backend.dto;
import javax.persistence.*;

public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String password;
    private String imagePath;

    public UserRequest() {
    }

    public UserRequest(UserRequestInterface userRequestInterface){
        this.firstName=userRequestInterface.getFirstName();
        this.lastName= userRequestInterface.getLastName();
        this.email= userRequestInterface.getEmail();
        this.phoneNumber= userRequestInterface.getPhoneNumber();
        this.password= userRequestInterface.getPassword();
        this.imagePath=userRequestInterface.getImagePath();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImagePath(String imagePath) {
        imagePath = imagePath;
    }
}