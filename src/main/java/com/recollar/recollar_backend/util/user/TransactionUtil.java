package com.recollar.recollar_backend.util.user;

import com.recollar.recollar_backend.models.Transaction;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class TransactionUtil {
    static public Transaction createTransaction(HttpServletRequest request) {
        Transaction transaction = new Transaction();
        transaction.setTxDate(new Date(System.currentTimeMillis()));
        transaction.setTxUpdate(new Date(System.currentTimeMillis()));
        transaction.setTxHost(request.getRemoteHost());
        transaction.setTxIdUser(1);
        return transaction;
    }
}
