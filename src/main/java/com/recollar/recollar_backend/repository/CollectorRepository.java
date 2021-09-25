package com.recollar.recollar_backend.repository;
import com.recollar.recollar_backend.models.CollectorModel;
import com.recollar.recollar_backend.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CollectorRepository extends JpaRepository<CollectorModel,String> {
    @Query(value = "select c.* from collector c  where c.id_user = ?1 and c.status=1", nativeQuery = true)
    CollectorModel findByUserId(Integer userId);
}
