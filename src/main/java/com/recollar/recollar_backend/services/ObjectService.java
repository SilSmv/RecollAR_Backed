package com.recollar.recollar_backend.services;

import com.recollar.recollar_backend.dto.ObjectRequest;
import com.recollar.recollar_backend.models.CollectionsModel;
import com.recollar.recollar_backend.models.ObjectModel;
import com.recollar.recollar_backend.models.Transaction;
import com.recollar.recollar_backend.repository.CollectionsRepository;
import com.recollar.recollar_backend.repository.ObjectRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ObjectService {
    @Resource
    private ObjectRepository objectRepository;

    @Resource
    private CollectionsRepository collectionsRepository;

    private int status = 0;

    public void createObject(ObjectRequest objectRequest, Transaction transaction){
        int newAmount = 0;
        status = 1;
        System.out.println("Entre");
        ObjectModel objectModel = new ObjectModel();
        objectModel.setIdCollection(objectRequest.getIdCollection());
        objectModel.setName(objectRequest.getName());
        objectModel.setDescription(objectRequest.getDescription());
        objectModel.setImage(objectRequest.getImage());
        objectModel.setStatus(status);
        objectModel.setObjectStatus(objectRequest.getObjectStatus());
        objectModel.setPrice(objectRequest.getPrice());
        objectModel.setTransaction(transaction);
        objectRepository.save(objectModel);
        System.out.println("Ya agregue");
        int  idCollection = objectModel.getIdCollection();
        Optional<CollectionsModel> collectionsModel = collectionsRepository.findById(idCollection);
        if(collectionsModel.isPresent()){
            CollectionsModel auxcollectionsModel=collectionsModel.get();
            newAmount = auxcollectionsModel.getAmount()+1;
        }
        collectionsRepository.updateAmount(transaction.getTxHost(),transaction.getTxUpdate(), newAmount,idCollection);
    }

}
