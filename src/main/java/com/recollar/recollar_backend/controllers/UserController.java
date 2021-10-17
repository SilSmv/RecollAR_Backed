package com.recollar.recollar_backend.controllers;

import com.recollar.recollar_backend.dto.SimpleUserRequest;
import com.recollar.recollar_backend.dto.UserRequest;
import com.recollar.recollar_backend.models.Transaction;
import com.recollar.recollar_backend.services.UserService;
import com.recollar.recollar_backend.util.user.TransactionUtil;
import com.recollar.recollar_backend.util.user.UserUtil;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/signup")
    public void Signup(@RequestBody UserRequest userRequest, HttpServletRequest request) throws Exception {
        Transaction transaction= TransactionUtil.createTransaction(request);
        userService.signUp(userRequest,transaction);
    }

    @GetMapping
    public UserRequest getProfile(){
        return userService.getProfile();
    }

    @PutMapping
    public void updateProfile(@RequestBody SimpleUserRequest simpleUserRequest){
        userService.updateProfile(simpleUserRequest);
    }
}
