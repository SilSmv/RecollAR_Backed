package com.recollar.recollar_backend.services;

import com.recollar.recollar_backend.dto.CollectionRequest;
import com.recollar.recollar_backend.models.*;
import com.recollar.recollar_backend.repository.CollectionsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Transactional
public class CollectionService {

    @Resource
    private CollectionsRepository collectionsRepository;

    public void createCollection(CollectionRequest collectionRequest, Transaction transaction){
        CollectionsModel collectionModel = new CollectionsModel();
        int status = 1 ;
        collectionModel.setIdCollector(collectionRequest.getIdCollector());
        collectionModel.setName(collectionRequest.getName());
        collectionModel.setColor(collectionRequest.getColor());
        collectionModel.setAmount(collectionRequest.getAmount());
        collectionModel.setStatus(status);
        collectionModel.setTransaction(transaction);
        collectionsRepository.save(collectionModel);
    }

    public void updateCollection(CollectionRequest collectionRequest, Transaction transaction){
        CollectionsModel collectionModel = new CollectionsModel();
        collectionModel.setIdCollection(collectionRequest.getIdCollection());
        collectionModel.setIdCollector(collectionRequest.getIdCollector());
        collectionModel.setName(collectionRequest.getName());
        collectionModel.setColor(collectionRequest.getColor());
        collectionModel.setAmount(collectionRequest.getAmount());
        collectionModel.setStatus(collectionRequest.getStatus());
        collectionModel.setTransaction(transaction);
        collectionsRepository.save(collectionModel);
    }
    public void deleteCollection(CollectionRequest collectionRequest, Transaction transaction){
       // collectionsRepository.update(collectionModel);
    }

}



