package com.recollar.recollar_backend.util.security;

import com.recollar.recollar_backend.models.UserModel;
import com.recollar.recollar_backend.repository.UserRepository;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdditionalToken implements TokenEnhancer{

    @Resource
    private UserRepository userRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> info = new HashMap<>();
        UserModel user = userRepository.findByEmail(oAuth2Authentication.getName());
        if(user != null){
            info.put("id", user.getIdUser());
            info.put("email", user.getEmail());
        }
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

        return oAuth2AccessToken;
    }
}
