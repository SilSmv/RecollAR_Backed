package com.recollar.recollar_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import java.sql.Date;

@Entity(name = "collection")
public class CollectionModel {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idCollection;
    @Column(name = "id_collector")
    private int idCollector;
    private String name;
    private String color;
    private int amount;
    @Column(name = "tx_date")
    private Date txDate;
    @Column(name = "tx_id_user")
    private Integer txIdUser;
    @Column(name = "tx_host")
    private String txHost;
    @Column(name = "tx_update")
    private Date txUpdate;


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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setTransaction(Transaction transaction){
        this.txDate=transaction.getTxDate();
        this.txHost=transaction.getTxHost();
        this.txIdUser=transaction.getTxIdUser();
        this.txUpdate=transaction.getTxUpdate();
    }

}
