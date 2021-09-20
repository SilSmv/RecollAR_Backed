package com.recollar.recollar_backend.repository;

import com.recollar.recollar_backend.models.AuthModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthRepository extends JpaRepository<AuthModel,String> {

    @Query(value = "select u.* from user u where u.email = ?1 and u.status=1", nativeQuery = true)
    AuthModel findByEmail(String email);

}
