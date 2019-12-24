package io.ebtproject.projectlms.repository;

import io.ebtproject.projectlms.model.KitapEntity;
import io.ebtproject.projectlms.model.KitaporderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KitaporderRepository extends JpaRepository<KitaporderEntity, Long> {

    List<KitaporderEntity> findByKitapEntityId(Long kitap_id);
    List<KitaporderEntity> findByKullaniciEntityId(Long kullanici_id);
    Optional<KitaporderEntity> findByIdAndKitapEntityId(Long id, Long id2);


}
