package com.recollar.recollar_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "object")
public class ObjectModel {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idObject;

    private Integer idCollection;
    private Integer idCategory;
    private String name;
    private String description;
    private String image;
    private String objectStatus;
    private Double price;
    private Integer status;
    private Date txDate;
    private Integer txIdUser;
    private String txHost;
    private Date txUpdate;
    public void setTransaction(Transaction transaction){
        this.txDate=transaction.getTxDate();
        this.txHost=transaction.getTxHost();
        this.txIdUser=transaction.getTxIdUser();
        this.txUpdate=transaction.getTxUpdate();
    }

    public Integer getIdObject() {
        return idObject;
    }

    public Integer getIdCollection() {
        return idCollection;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getObjectStatus() {
        return objectStatus;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setIdObject(Integer idObject) {
        this.idObject = idObject;
    }

    public void setIdCollection(Integer idCollection) {
        this.idCollection = idCollection;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setObjectStatus(String objectStatus) {
        this.objectStatus = objectStatus;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ObjectModel{" +
                "idObject=" + idObject +
                ", idCollection=" + idCollection +
                ", idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", objectStatus='" + objectStatus + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
