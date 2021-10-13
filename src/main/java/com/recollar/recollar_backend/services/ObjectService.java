package com.recollar.recollar_backend.services;

import com.recollar.recollar_backend.dto.ObjectRequest;
import com.recollar.recollar_backend.dto.ObjectRequestInterface;
import com.recollar.recollar_backend.repository.ObjectRepository;
import com.recollar.recollar_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class ObjectService {
    @Resource
    private ObjectRepository objectRepository;

    public List<ObjectRequest> getObjectsByCollection(Integer idCollection){
        List<ObjectRequest> objects= new ArrayList();
        List<ObjectRequestInterface> objectsAux=objectRepository.getAllByIdCollection(idCollection);
        for(ObjectRequestInterface obj:objectsAux){
            objects.add(new ObjectRequest(obj));
        }
        return objects;
    }
}
