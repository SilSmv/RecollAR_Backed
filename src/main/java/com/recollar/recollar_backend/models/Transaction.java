package com.recollar.recollar_backend.models;

import java.sql.Date;

public class Transaction {
    private Date txDate;
    private Integer txIdUser;
    private String txHost;
    private Date txUpdate;

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public Integer getTxIdUser() {
        return txIdUser;
    }

    public void setTxIdUser(Integer txIdUser) {
        this.txIdUser = txIdUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxUpdate() {
        return txUpdate;
    }

    public void setTxUpdate(Date txUpdate) {
        this.txUpdate = txUpdate;
    }

}
