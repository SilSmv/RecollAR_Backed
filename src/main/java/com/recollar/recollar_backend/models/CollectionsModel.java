package com.recollar.recollar_backend.models;

import javax.persistence.*;

import java.sql.Date;

@Entity(name = "collection")
public class CollectionsModel {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idCollection;
    @Column(name = "id_collector")
    private int idCollector;
    private String name;
    private int amount;
    private String image;
    private int status;
    @Column(name = "id_category")
    private int idCategory;
    @Column(name = "tx_date")
    private Date txDate;
    @Column(name = "tx_id_user")
    private Integer txIdUser;
    @Column(name = "tx_host")
    private String txHost;
    @Column(name = "tx_update")
    private Date txUpdate;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(int idCollection) {
        this.idCollection = idCollection;
    }

    public int getIdCollector() {
        return idCollector;
    }

    public void setIdCollector(int idCollector) {
        this.idCollector = idCollector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTransaction(Transaction transaction){
        this.txDate=transaction.getTxDate();
        this.txHost=transaction.getTxHost();
        this.txIdUser=transaction.getTxIdUser();
        this.txUpdate=transaction.getTxUpdate();
    }

}
