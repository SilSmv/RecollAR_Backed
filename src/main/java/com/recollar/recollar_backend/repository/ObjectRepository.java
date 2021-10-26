package com.recollar.recollar_backend.repository;

import com.recollar.recollar_backend.dto.ObjectSimpleRequest;
import com.recollar.recollar_backend.dto.ObjectSimpleRequestInterface;
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

    @Query(value = "select o.id_object idObject,o.name name, o.image image  from object o INNER JOIN collection c on c.id_collection=o.id_collection where o.id_collection = ?1 and o.status!=0 and c.status=1 and c.id_collector=?2 order by o.id_object DESC", nativeQuery = true)
    List<ObjectSimpleRequestInterface> findByCollectionId(Integer idCollection, Integer idCollector);

    @Query(value = "select * from object c where c.status = 1 and c.object_status = 2 or c.object_status = 3 order by c.id_collection DESC", nativeQuery = true)
    List<ObjectModel> getObjectAvailable();

    @Query(value = "select * from object c where MATCH(c.name,c.description) AGAINST ( 'searchString' IN BOOLEAN MODE) and c.status = 2 or c.status = 3 order by c.id_object DESC", nativeQuery = true)
    List<ObjectModel> getObjectsSearch(@Param("searchString") String searchString);

    @Query(value = "select * from object c where  c.status = 2 or c.status = 3 order by c.id_object DESC", nativeQuery = true)
    List<ObjectModel> getObjects();

    @Query(value = "select o.* from object o INNER JOIN collection c on c.id_collection=o.id_collection where o.id_object= ?1 and o.status!=0 and c.status=1 and c.id_collector=?2", nativeQuery = true)
    ObjectModel getByIdWithVerification(@Param("idObject") Integer idObject,@Param("idCollector") Integer idCollector);
    @Modifying
    @Transactional
    @Query("update object h SET h.txHost = ?1, h.txUpdate = ?2, h.image = ?3 WHERE h.idObject = ?4 and h.status != 0")
    public void updateImage( String txHost, Date txUpdate, String image,Integer idObject);

    @Modifying
    @Transactional
    @Query("update object h SET h.txHost = ?1, h.txUpdate = ?2, h.status = ?3 WHERE h.idObject = ?4 and h.status != 0")
    public void updateObjectStatus( String txHost, Date txUpdate, Integer objectStatus,Integer idObject);

}
