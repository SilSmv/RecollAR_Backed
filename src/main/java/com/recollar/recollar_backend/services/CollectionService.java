package com.recollar.recollar_backend.services;

import com.recollar.recollar_backend.dto.CollectionRequest;
import com.recollar.recollar_backend.models.*;
import com.recollar.recollar_backend.repository.CollectionsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;

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
        collectionModel.setIdCategory(collectionRequest.getIdCategory());
        collectionModel.setTransaction(transaction);
        collectionsRepository.save(collectionModel);
    }

    public void updateCollection(CollectionRequest collectionRequest, Transaction transaction){
        int status = 1 ;
        CollectionsModel collectionModel = new CollectionsModel();
        collectionModel.setIdCollection(collectionRequest.getIdCollection());
        collectionModel.setIdCollector(collectionRequest.getIdCollector());
        collectionModel.setName(collectionRequest.getName());
        collectionModel.setColor(collectionRequest.getColor());
        collectionModel.setAmount(collectionRequest.getAmount());
        collectionModel.setStatus(status);
        collectionModel.setIdCategory(collectionRequest.getIdCategory());
        collectionModel.setTransaction(transaction);

        collectionsRepository.save(collectionModel);
        System.out.println();
    }
    public void deleteCollection(Integer idCollection, Transaction transaction){
        int status = 0 ;
        collectionsRepository.updateStatus(status, transaction.getTxHost(),transaction.getTxUpdate(), idCollection);
    }

}



