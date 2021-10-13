package com.recollar.recollar_backend.dto;

public class ObjectRequest {
    private int idObject;
    private int idCollection;
    private String name;
    private String description;
    private String image;
    private int objectStatus;
    private float price;

    /*public ObjectRequest(ObjectRequestInterface objectRequestInterface){
        this.idObject=objectRequestInterface.getIdObject();
        this.name=objectRequestInterface.getName();
        this.image=objectRequestInterface.getImage();
        this.idCollection = objectRequestInterface.getIdCollection();
        this.description = objectRequestInterface.getDescription();
        this.objectStatus = objectRequestInterface.getObjectStatus();
        this.price = objectRequestInterface.getPrice();
    }*/

    public Integer getIdObject() {
        return idObject;
    }

    public void setIdObject(Integer idObject) {
        this.idObject = idObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIdObject(int idObject) {
        this.idObject = idObject;
    }

    public int getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(int idCollection) {
        this.idCollection = idCollection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getObjectStatus() {
        return objectStatus;
    }

    public void setObjectStatus(int objectStatus) {
        this.objectStatus = objectStatus;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
