package com.recollar.recollar_backend.controllers;

import com.recollar.recollar_backend.dto.UserRequest;
import com.recollar.recollar_backend.models.Transaction;
import com.recollar.recollar_backend.services.UserService;
import com.recollar.recollar_backend.util.user.TransactionUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/signup")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping
    public void Signup(@RequestBody UserRequest userRequest, HttpServletRequest request) throws Exception {
        Transaction transaction= TransactionUtil.createTransaction(request);
        userService.signUp(userRequest,transaction);
    }
}
