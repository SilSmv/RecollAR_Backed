package com.recollar.recollar_backend.services;

import com.recollar.recollar_backend.models.AuthModel;
import com.recollar.recollar_backend.repository.AuthRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AuthService implements UserDetailsService {
        @Resource
        private AuthRepository authRepository;



        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


            AuthModel user = authRepository.findByEmail(email);
            if(user != null){
                return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
            } else {
                throw new UsernameNotFoundException("User '"+email+"' not found!");
            }
        }

}
