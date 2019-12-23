package io.ebtproject.projectlms.service;

import io.ebtproject.projectlms.model.KullaniciEntity;
import io.ebtproject.projectlms.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KullaniciService {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Transactional
    public KullaniciEntity saveOrUpdate(KullaniciEntity kullanici) {
        return kullaniciRepository.save(kullanici);

    }

    @Transactional
    public Iterable<KullaniciEntity> findAll() {return kullaniciRepository.findAll(); }

    @Transactional
    public KullaniciEntity findById(Long id) {return kullaniciRepository.getById(id);}

    @Transactional
    public void delete(Long id){
        KullaniciEntity kullanici = findById(id);
        kullaniciRepository.delete(kullanici);
    }
}
