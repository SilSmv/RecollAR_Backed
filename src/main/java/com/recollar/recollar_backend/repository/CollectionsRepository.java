package com.recollar.recollar_backend.repository;


import com.recollar.recollar_backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;

public interface CollectionsRepository extends JpaRepository<CollectionsModel,String> {
    @Modifying
    @Transactional
    @Query("update collection h SET h.status = ?1, h.txHost = ?2, h.txUpdate = ?3 WHERE h.idCollection = ?4")
    public void updateStatus(Integer status, String txHost, Date txUpdate, Integer idCollection);
}
