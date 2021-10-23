package com.recollar.recollar_backend.services;

import com.recollar.recollar_backend.dto.CollectionRequest;
import com.recollar.recollar_backend.models.*;
import com.recollar.recollar_backend.repository.CollectionsRepository;
import com.recollar.recollar_backend.util.storage.StorageUtil;
import com.recollar.recollar_backend.util.user.UserUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CollectionService {

    @Resource
    private CollectionsRepository collectionsRepository;
    int status = 0;

    public CollectionsModel createCollection(CollectionRequest collectionRequest, Transaction transaction){
        CollectionsModel collectionModel = new CollectionsModel();
        UserInformationModel userInformationModel= UserUtil.getUser();
        int status = 1 ;
        collectionModel.setIdCollector(userInformationModel.getIdCollector());
        collectionModel.setName(collectionRequest.getName());
        collectionModel.setAmount(0);
        collectionModel.setStatus(status);
        collectionModel.setIdCategory(collectionRequest.getIdCategory());
        collectionModel.setTransaction(transaction);
        collectionsRepository.save(collectionModel);
        return collectionModel;
    }

    public void updateCollection(CollectionRequest collectionRequest, Transaction transaction){

        UserInformationModel userInformationModel= UserUtil.getUser();
        status = 1 ;
        CollectionsModel collectionModel = new CollectionsModel();
        collectionModel.setIdCollection(collectionRequest.getIdCollection());
        collectionModel.setIdCollector(userInformationModel.getIdCollector());
        collectionModel.setName(collectionRequest.getName());
        collectionModel.setAmount(0);
        collectionModel.setStatus(status);
        collectionModel.setIdCategory(collectionRequest.getIdCategory());
        collectionModel.setTransaction(transaction);

        collectionsRepository.save(collectionModel);
    }
    public void deleteCollection(Integer idCollection, Transaction transaction){
        status = 0 ;
        collectionsRepository.updateStatus(status, transaction.getTxHost(),transaction.getTxUpdate(), idCollection);
    }
    public List<CollectionsModel> getCollections(){
        UserInformationModel userInformationModel= UserUtil.getUser();
        return collectionsRepository.findByCollectorId(userInformationModel.getIdCollector());
    }
    public void uploadImage(MultipartFile image, Integer idCollection, Transaction transaction){
        StorageUtil storageUtil= new StorageUtil();
        String name=storageUtil.upload(image,"imageCollection");
        collectionsRepository.updateImage(transaction.getTxHost(),transaction.getTxUpdate(),name,idCollection);



    }

}



