package com.recollar.recollar_backend.dto;

public class ObjectRequest {
    private Integer idObject;
    private String name;
    private String image;

    public ObjectRequest(ObjectRequestInterface objectRequestInterface){
        this.idObject=objectRequestInterface.getIdObject();
        this.name=objectRequestInterface.getName();
        this.image=objectRequestInterface.getImage();
    }

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
}
