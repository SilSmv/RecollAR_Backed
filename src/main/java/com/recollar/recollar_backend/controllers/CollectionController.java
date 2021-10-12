package com.recollar.recollar_backend.controllers;

import com.recollar.recollar_backend.dto.CollectionRequest;
import com.recollar.recollar_backend.dto.UserRequest;
import com.recollar.recollar_backend.models.CollectionsModel;
import com.recollar.recollar_backend.models.Transaction;
import com.recollar.recollar_backend.services.CollectionService;
import com.recollar.recollar_backend.services.UserService;
import com.recollar.recollar_backend.util.user.TransactionUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/collection")
public class CollectionController {

    @Resource
    private CollectionService collectionService;

    @PostMapping
    public void create(@RequestBody CollectionRequest collectionRequest, HttpServletRequest request) throws Exception {
        Transaction transaction= TransactionUtil.createTransaction(request);
        collectionService.createCollection(collectionRequest,transaction);
    }

    @PutMapping
    public void update(@RequestBody CollectionRequest collectionRequest, HttpServletRequest request) throws Exception {
        Transaction transaction= TransactionUtil.createTransaction(request);
        collectionService.updateCollection(collectionRequest,transaction);
    }

    @DeleteMapping("/{idCollection}")
    public void delete(@PathVariable int idCollection, HttpServletRequest request) throws Exception {
        Transaction transaction= TransactionUtil.createTransaction(request);
        collectionService.deleteCollection(idCollection,transaction);
    }

    @GetMapping("/{idCollector}")
    public List<CollectionsModel> get(@PathVariable int idCollector) throws Exception {
        return collectionService.getCollections(idCollector);
    }

}
