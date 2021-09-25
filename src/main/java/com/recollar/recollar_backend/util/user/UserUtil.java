package com.recollar.recollar_backend.util.user;
import com.recollar.recollar_backend.models.UserInformationModel;
import org.springframework.security.core.context.SecurityContextHolder;
public class UserUtil {
    static public UserInformationModel getUser(){
        UserInformationModel user= (UserInformationModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}