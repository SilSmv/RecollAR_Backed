package com.recollar.recollar_backend.repository;

import com.recollar.recollar_backend.models.CollectorModel;
import com.recollar.recollar_backend.models.ObjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ObjectRepository extends JpaRepository<ObjectModel,Integer> {
    @Query(value = "select * from object  where id_collection = ?1 and c.status=1", nativeQuery = true)
    CollectorModel findByCollectionId(Integer idCollection);
}
