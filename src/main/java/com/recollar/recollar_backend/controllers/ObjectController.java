package com.recollar.recollar_backend.controllers;
import com.recollar.recollar_backend.dto.CollectionRequest;
import com.recollar.recollar_backend.dto.ObjectRequest;
import com.recollar.recollar_backend.models.Transaction;
import com.recollar.recollar_backend.services.ObjectService;
import com.recollar.recollar_backend.util.user.TransactionUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

}
