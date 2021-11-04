package com.recollar.recollar_backend.controllers;
import com.recollar.recollar_backend.dto.ObjectRequest;
import com.recollar.recollar_backend.dto.ObjectSimpleRequest;
import com.recollar.recollar_backend.models.ObjectModel;
import com.recollar.recollar_backend.models.Transaction;
import com.recollar.recollar_backend.services.ObjectService;
import com.recollar.recollar_backend.util.user.TransactionUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/object")
public class ObjectController {
    @Resource
    private ObjectService objectService;

    @PostMapping
    public ObjectModel create(@RequestBody ObjectRequest objectRequest, HttpServletRequest request) throws Exception {
        Transaction transaction = TransactionUtil.createTransaction(request);
        System.out.println("Estoy en el controler");
       return objectService.createObject(objectRequest,transaction);
    }
    @PutMapping
    public void update(@RequestBody ObjectRequest objectRequest, HttpServletRequest request) throws Exception {
        Transaction transaction= TransactionUtil.createTransaction(request);
        objectService.updateObject(objectRequest);
    }
    @DeleteMapping("/{idObject}")
    public void delete(@PathVariable int idObject, HttpServletRequest request) throws Exception {
        Transaction transaction= TransactionUtil.createTransaction(request);
        objectService.deleteObject(idObject,transaction);
    }
    @GetMapping()
    public List<ObjectSimpleRequest> get(@RequestParam(value = "id_collection") Integer idCollection)  {
        return objectService.getObjectsCollection(idCollection);
    }

    @GetMapping("/{id_object}")
    public ObjectModel getOne(@PathVariable(value = "id_object") Integer idObject,@RequestParam(required = false) boolean pub)  {
        if(pub){
            return objectService.getObjectByIdPublic(idObject);
        }
        else{
            return objectService.getObjectById(idObject);
        }
    }
    /*@GetMapping("/available")
    public List<ObjectModel> getObjectAvailable() throws Exception {
        return objectService.getObjectsAvailable();
    }*/
    @GetMapping("/public")
    public List<ObjectModel> searchObject(@RequestParam(required = false) String text) throws Exception {
        return objectService.searchObjects(text);
    }
    @RequestMapping(path="/image",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadImage(@RequestParam MultipartFile images, HttpServletRequest request, @RequestParam Integer idObject){
        Transaction transaction= TransactionUtil.createTransaction(request);
        objectService.uploadImage(images,idObject,transaction);
    }

    @RequestMapping(path="/change-status",method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateObjectStatus(@RequestParam Integer idObject,@RequestParam Integer objectStatus,HttpServletRequest request){
        Transaction transaction= TransactionUtil.createTransaction(request);
        objectService.updateObjectStatus(idObject,objectStatus,transaction);
    }
}
