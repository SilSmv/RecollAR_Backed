package com.recollar.recollar_backend.controllers;

import com.recollar.recollar_backend.util.storage.StorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/image")
public class ImageController {


    @RequestMapping(path="/{path}/{name}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getImage(@PathVariable("path") String path, @PathVariable("name") String name){
        StorageUtil storageUtil=new StorageUtil();
        byte[] image=storageUtil.get(path,name);
        return image;
    }
}
