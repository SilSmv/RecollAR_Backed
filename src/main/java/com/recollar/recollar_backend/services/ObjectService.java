package com.recollar.recollar_backend.services;

import com.recollar.recollar_backend.dto.ObjectRequest;
import com.recollar.recollar_backend.dto.ObjectSimpleRequest;
import com.recollar.recollar_backend.models.CollectionsModel;
import com.recollar.recollar_backend.models.ObjectModel;
import com.recollar.recollar_backend.models.Transaction;
import com.recollar.recollar_backend.models.UserInformationModel;
import com.recollar.recollar_backend.repository.CollectionsRepository;
import com.recollar.recollar_backend.repository.ObjectRepository;
import com.recollar.recollar_backend.util.user.UserUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

        int  idCollection = objectModel.getIdCollection();
        Optional<CollectionsModel> collectionsModel = collectionsRepository.findById(idCollection);
        if(collectionsModel.isPresent()){
            CollectionsModel auxcollectionsModel=collectionsModel.get();
            newAmount = auxcollectionsModel.getAmount()+1;
        }
        collectionsRepository.updateAmount(transaction.getTxHost(),transaction.getTxUpdate(), newAmount,idCollection);
    }
    public void updateObject(ObjectRequest objectRequest, Transaction transaction){
        status = 1 ;
        ObjectModel objectModel = new ObjectModel();
        objectModel.setIdObject(objectRequest.getIdObject());
        objectModel.setIdCollection(objectRequest.getIdCollection());
        objectModel.setName(objectRequest.getName());
        objectModel.setDescription(objectRequest.getDescription());
        objectModel.setImage(objectRequest.getImage());
        objectModel.setStatus(status);
        objectModel.setObjectStatus(objectRequest.getObjectStatus());
        objectModel.setPrice(objectRequest.getPrice());
        objectModel.setTransaction(transaction);
        objectRepository.save(objectModel);
    }
    public void deleteObject(Integer idObject, Transaction transaction){
        int idCollection = 0;
        int newAmount = 0;
        status = 0 ;
        objectRepository.updateStatus(status, transaction.getTxHost(),transaction.getTxUpdate(), idObject);
        Optional<ObjectModel> objectModel = objectRepository.findById(idObject);
        if(objectModel.isPresent()){
            ObjectModel objectModelAux = objectModel.get();
            idCollection = objectModelAux.getIdCollection();
            Optional<CollectionsModel> collectionsModel = collectionsRepository.findById(idCollection);
            if(collectionsModel.isPresent()){
                CollectionsModel auxcollectionsModel=collectionsModel.get();
                newAmount = auxcollectionsModel.getAmount()-1;
            }

        }
        collectionsRepository.updateAmount(transaction.getTxHost(),transaction.getTxUpdate(), newAmount,idCollection);
    }

    public List<ObjectSimpleRequest> getObjectsCollection(Integer idCollection){
        UserInformationModel userInformationModel= UserUtil.getUser();
        List<ObjectSimpleRequest> listObjects= new ArrayList();
        var listObjectsAux=objectRepository.findByCollectionId(idCollection,userInformationModel.getIdCollector());
        for(var object:listObjectsAux){
            listObjects.add(new ObjectSimpleRequest(object));
        }
        return  listObjects;
    }
    public ObjectModel getObjectById(Integer idObject){
        UserInformationModel userInformationModel= UserUtil.getUser();

        return objectRepository.getByIdWithVerification(idObject,userInformationModel.getIdCollector());
    }
    public List<ObjectModel> getObjectsAvailable(){
        return objectRepository.getObjectAvailable();
    }
    public List<ObjectModel> searchObjects(String search){
        System.out.println(search);

        return objectRepository.getObjectSearch(search);
    }
}
