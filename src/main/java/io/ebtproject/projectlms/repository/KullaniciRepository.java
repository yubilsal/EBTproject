package io.ebtproject.projectlms.repository;

import io.ebtproject.projectlms.model.KitapEntity;
import io.ebtproject.projectlms.model.KullaniciEntity;
import org.springframework.data.repository.CrudRepository;

public interface KullaniciRepository extends CrudRepository<KullaniciEntity, Long> {

    KullaniciEntity getById(Long id);
}
