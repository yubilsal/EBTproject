package io.ebtproject.projectlms.service;

import io.ebtproject.projectlms.repository.KitapRepository;
import io.ebtproject.projectlms.model.KitapEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KitapService {

    @Autowired
    private KitapRepository kitapRepository;

    @Transactional
    public KitapEntity saveOrUpdate(KitapEntity kitap) {

        if (kitap.getKitapAdi() == null || (kitap.getKitapAdi()== "")){

            kitap.setKitapAdi("TO_DO");
        }
        else if(kitap.getIsbn() == 0){
            kitap.setIsbn(111);
        }

        return kitapRepository.save(kitap);
    }

    @Transactional
    public Iterable<KitapEntity> findAll(){
        return kitapRepository.findAll();
    }

    @Transactional
    public KitapEntity findById(Long id){
        return kitapRepository.getById(id);
    }

    @Transactional
    public void delete(Long id){
        KitapEntity kitap = findById(id);
        kitapRepository.delete(kitap);
    }
}
