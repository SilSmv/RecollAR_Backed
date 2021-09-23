package com.recollar.recollar_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "collector")
public class CollectorModel {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCollector;
    private Integer idPerson;
    private Integer idUser;
    private String imagePath;
    private Integer status;
    private Date txDate;
    private Integer txIdUser;
    private String txHost;
    private Date txUpdate;

    public Integer getIdCollector() {
        return idCollector;
    }

    public void setIdCollector(Integer idCollector) {
        this.idCollector = idCollector;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
        return "CollectorModel{" +
                "idCollector=" + idCollector +
                ", idPerson='" + idPerson + '\'' +
                ", idUser='" + idUser + '\'' +
                ", imagePath=" + imagePath +
                ", status=" + status +
                ", txDate=" + txDate +
                ", txIdUser=" + txIdUser +
                ", txHost='" + txHost + '\'' +
                ", txUpdate=" + txUpdate +
                '}';
    }
}
