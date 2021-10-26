package com.recollar.recollar_backend.models;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="object")
public class ObjectModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idObject;
    @Column(name = "id_collection")
    private int idCollection;
    private String name;
    private String description;
    private String image;
    @Column(name = "object_status")
    private int objectStatus;
    private Integer status;
    private float price;
    private boolean ar;
    private Date txDate;
    private Integer txIdUser;
    private String txHost;
    private Date txUpdate;

    public int getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(int idCollection) {
        this.idCollection = idCollection;
    }

    public int getIdObject() {
        return idObject;
    }

    public void setIdObject(int idObject) {
        this.idObject = idObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getObjectStatus() {
        return objectStatus;
    }

    public void setObjectStatus(int objectStatus) {
        this.objectStatus = objectStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public void setTransaction(Transaction transaction){
        this.txDate=transaction.getTxDate();
        this.txHost=transaction.getTxHost();
        this.txIdUser=transaction.getTxIdUser();
        this.txUpdate=transaction.getTxUpdate();
    }

    public boolean getAr() {
        return ar;
    }

    public void setAr(boolean ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return "ObjectModel{" +
                "idObject=" + idObject +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", objectStatus=" + objectStatus +
                ", status=" + status +
                ", price=" + price +
                ", txDate=" + txDate +
                ", txIdUser=" + txIdUser +
                ", txHost='" + txHost + '\'' +
                ", txUpdate=" + txUpdate +
                '}';
    }
}
