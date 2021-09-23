package com.recollar.recollar_backend.repository;
import com.recollar.recollar_backend.models.CollectorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectorRepository extends JpaRepository<CollectorModel,String> {

}
