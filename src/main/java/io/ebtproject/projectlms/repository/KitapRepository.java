package io.ebtproject.projectlms.repository;

import io.ebtproject.projectlms.model.KitapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitapRepository extends JpaRepository<KitapEntity, Long> {

    KitapEntity getById(Long id);

}
