package com.recollar.recollar_backend.repository;

import com.recollar.recollar_backend.models.CollectionsModel;
import com.recollar.recollar_backend.models.CollectorModel;
import com.recollar.recollar_backend.models.ObjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface ObjectRepository extends JpaRepository<ObjectModel,Integer> {

    @Modifying
    @Transactional
    @Query("update object o SET o.status = ?1, o.txHost = ?2, o.txUpdate = ?3 WHERE o.idObject = ?4")
    public void updateStatus(Integer status, String txHost, Date txUpdate, Integer idObject);

    @Query(value = "select * from object c where c.id_collection = ?1 and c.status=1 order by c.id_collection DESC", nativeQuery = true)
    List<ObjectModel> findByCollectionId(Integer idCollector);

    @Query(value = "select * from object c where c.status = 1 and c.object_status = 2 or c.object_status = 3 order by c.id_collection DESC", nativeQuery = true)
    List<ObjectModel> getObjectAvailable();

    @Query(value = "select * from object c where c.status = 1 and MATCH(c.name,c.description) AGAINST ( 'searchString') and c.object_status = 2 or c.object_status = 3 order by c.id_collection DESC", nativeQuery = true)
    List<ObjectModel> getObjectSearch(@Param("searchString") String searchString);

}
