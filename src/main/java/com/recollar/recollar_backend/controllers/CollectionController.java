package com.recollar.recollar_backend.controllers;

import com.recollar.recollar_backend.dto.CollectionRequest;
import com.recollar.recollar_backend.models.CollectionsModel;
import com.recollar.recollar_backend.models.Transaction;
import com.recollar.recollar_backend.services.CollectionService;
import com.recollar.recollar_backend.util.user.TransactionUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
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

    @GetMapping
    public List<CollectionsModel> get() {
        return collectionService.getCollections();
    }
    @RequestMapping(path="/image",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadImage(@RequestParam MultipartFile images, HttpServletRequest request, @RequestParam Integer idCollection){
        Transaction transaction= TransactionUtil.createTransaction(request);
        collectionService.uploadImage(images,idCollection,transaction);
    }

}
