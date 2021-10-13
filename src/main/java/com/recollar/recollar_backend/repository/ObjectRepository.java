package com.recollar.recollar_backend.repository;

import com.recollar.recollar_backend.dto.ObjectRequestInterface;
import com.recollar.recollar_backend.models.CollectorModel;
import com.recollar.recollar_backend.models.ObjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjectRepository extends JpaRepository<ObjectModel,String> {
    @Query(value = "select o.id_object as idObject, o.name,o.image from object o where o.id_collection=?1 and status=1", nativeQuery = true)
    List<ObjectRequestInterface> getAllByIdCollection(Integer idCollection);
}
