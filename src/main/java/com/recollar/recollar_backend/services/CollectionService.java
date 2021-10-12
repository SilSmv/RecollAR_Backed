package com.recollar.recollar_backend.services;

import com.recollar.recollar_backend.dto.CollectionRequest;
import com.recollar.recollar_backend.models.Transaction;
//import com.recollar.recollar_backend.models.CollectionModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class CollectionService {
    public void createCollection(CollectionRequest collectionRequest, Transaction transaction){
       /* CollectionModel collectionModel = new CollectionModel();
        collectionModel.setIdCollector(collectionRequest.getIdCollector());
        collectionModel.setName(collectionRequest.getName());
        collectionModel.setColor(collectionRequest.getColor());
        collectionModel.setAmount(collectionRequest.getAmount());
        collectionModel.setTransaction(transaction);*/

    }

}



