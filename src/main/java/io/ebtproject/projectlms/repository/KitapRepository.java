package io.ebtproject.projectlms.repository;

import io.ebtproject.projectlms.model.KitapEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitapRepository extends CrudRepository<KitapEntity, Long> {

    KitapEntity getById(Long id);

}
