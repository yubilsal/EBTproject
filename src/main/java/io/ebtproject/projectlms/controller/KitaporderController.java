package io.ebtproject.projectlms.controller;

import io.ebtproject.projectlms.model.KitaporderEntity;
import io.ebtproject.projectlms.model.KullaniciEntity;
import io.ebtproject.projectlms.model.KitapEntity;
import io.ebtproject.projectlms.repository.KullaniciRepository;
import io.ebtproject.projectlms.repository.KitapRepository;
import io.ebtproject.projectlms.service.KullaniciService;
import io.ebtproject.projectlms.service.KitapService;
import io.ebtproject.projectlms.repository.KitaporderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class KitaporderController {

    @Autowired
    private KitaporderRepository kitaporderRepository;
    @Autowired
    private KullaniciRepository kullaniciRepository;
    @Autowired
    private KitapRepository kitapRepository;

    @Transactional
    @GetMapping("/orders")
    public Iterable<KitaporderEntity> getALL() {
        return kitaporderRepository.findAll();
    }

    @Transactional
    @GetMapping("/orders/{id}")
    public ResponseEntity<KitaporderEntity> findById(@PathVariable(value = "id") long id) {
        return kitaporderRepository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/kitap/{kitap_id}/orders")
    public List<KitaporderEntity> getAllKitaporderEntitysByDoctorId(@PathVariable(value = "kitap_id") Long kitap_id) {
        return kitaporderRepository.findByKitapEntityId(kitap_id);
    }

    @GetMapping("/kullanici/{kullanici_id}/orders")
    public List<KitaporderEntity> getAllKitaporderEntitysByPatientId(@PathVariable(value = "kullanici_id") Long kullanici_id) {
        return kitaporderRepository.findByKullaniciEntityId(kullanici_id);
    }

    @PostMapping("/kitap/{kitap_id}/kullanici/{kullanici_id}")
    public KitaporderEntity createOrder(@PathVariable(value = "kitap_id") Long kitap_id,@PathVariable(value = "kullanici_id") Long kullanici_id,
                                        @Valid @RequestBody KitaporderEntity kitaporderentity) throws InvalidConfigurationPropertyValueException {
        @Valid KitaporderEntity kkitaportderentity = kullaniciRepository.findById(kullanici_id).map(kullanici -> {
            kitaporderentity.setKullaniciEntity(kullanici);
            return kitaporderentity;
        }).orElseThrow(() -> new InvalidConfigurationPropertyValueException("aaaa","bbbb",null));

        return kitapRepository.findById(kitap_id).map(kitap -> {
            kkitaportderentity.setKitapEntity(kitap);
            return kitaporderRepository.save(kkitaportderentity);
        }).orElseThrow(() -> new InvalidConfigurationPropertyValueException("aaaa","bbbb",null));
    }


}



