package com.recollar.recollar_backend.controllers;

import com.recollar.recollar_backend.dto.ObjectRequest;
import com.recollar.recollar_backend.services.ObjectService;
import com.recollar.recollar_backend.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/object")
public class ObjectController {
    @Resource
    private ObjectService objectService;

    @GetMapping
    public List<ObjectRequest> objectList(@RequestParam Integer idCollection){
        return objectService.getObjectsByCollection(idCollection);
    }
}
