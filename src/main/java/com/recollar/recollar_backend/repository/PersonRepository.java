package com.recollar.recollar_backend.repository;
import com.recollar.recollar_backend.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel,String> {

}
