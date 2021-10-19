package com.recollar.recollar_backend.repository;


import com.recollar.recollar_backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface CollectionsRepository extends JpaRepository<CollectionsModel,Integer> {
    @Modifying
    @Transactional
    @Query("update collection h SET h.status = ?1, h.txHost = ?2, h.txUpdate = ?3 WHERE h.idCollection = ?4")
    public void updateStatus(Integer status, String txHost, Date txUpdate, Integer idCollection);

    @Modifying
    @Transactional
    @Query("update collection h SET h.txHost = ?1, h.txUpdate = ?2, h.amount = ?3 WHERE h.idCollection = ?4 and h.status = 1")
    public void updateAmount( String txHost, Date txUpdate, Integer amount,Integer idCollection);

    @Query(value = "select * from collection c where c.id_collector = ?1 and c.status=1", nativeQuery = true)
    List<CollectionsModel> findByCollectorId(Integer idCollector);

    @Modifying
    @Transactional
    @Query("update collection h SET h.txHost = ?1, h.txUpdate = ?2, h.image = ?3 WHERE h.idCollection = ?4 and h.status = 1")
    public void updateImage( String txHost, Date txUpdate, String image,Integer idCollection);

}
