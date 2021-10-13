package com.recollar.recollar_backend.repository;

import com.recollar.recollar_backend.models.CollectorModel;
import com.recollar.recollar_backend.models.ObjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;

public interface ObjectRepository extends JpaRepository<ObjectModel,Integer> {

    @Modifying
    @Transactional
    @Query("update object o SET o.status = ?1, o.txHost = ?2, o.txUpdate = ?3 WHERE o.idObject = ?4")
    public void updateStatus(Integer status, String txHost, Date txUpdate, Integer idObject);

}
