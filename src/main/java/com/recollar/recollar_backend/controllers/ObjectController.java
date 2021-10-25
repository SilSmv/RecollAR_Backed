package com.recollar.recollar_backend.controllers;
import com.recollar.recollar_backend.dto.ObjectRequest;
import com.recollar.recollar_backend.dto.ObjectSimpleRequest;
import com.recollar.recollar_backend.models.ObjectModel;
import com.recollar.recollar_backend.models.Transaction;
import com.recollar.recollar_backend.services.ObjectService;
import com.recollar.recollar_backend.util.user.TransactionUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/object")
public class ObjectController {
    @Resource
    private ObjectService objectService;

    @PostMapping
    public void create(@RequestBody ObjectRequest objectRequest, HttpServletRequest request) throws Exception {
        Transaction transaction = TransactionUtil.createTransaction(request);
        System.out.println("Estoy en el controler");
       objectService.createObject(objectRequest,transaction);
    }
    @PutMapping
    public void update(@RequestBody ObjectRequest objectRequest, HttpServletRequest request) throws Exception {
        Transaction transaction= TransactionUtil.createTransaction(request);
        objectService.updateObject(objectRequest,transaction);
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
    public ObjectModel getOne(@PathVariable(value = "id_object") Integer idObject)  {
        return objectService.getObjectById(idObject);
    }
    /*@GetMapping("/available")
    public List<ObjectModel> getObjectAvailable() throws Exception {
        return objectService.getObjectsAvailable();
    }*/
    @GetMapping("/search/{text}")
    public List<ObjectModel> searchObject(@PathVariable String text) throws Exception {
        return objectService.searchObjects(text);
    }


}
