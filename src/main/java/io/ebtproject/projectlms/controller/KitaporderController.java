package io.ebtproject.projectlms.controller;

import io.ebtproject.projectlms.model.KitaporderEntity;
import io.ebtproject.projectlms.repository.KitapRepository;
import io.ebtproject.projectlms.repository.KitaporderRepository;
import io.ebtproject.projectlms.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
public class KitaporderController {

    @Autowired
    private KitaporderRepository kitaporderRepository;
    @Autowired
    private KitapRepository kitapRepository;
    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Transactional
    @GetMapping("/orders")
    public Iterable<KitaporderEntity> getALL(){
        return kitaporderRepository.findAll();
    }
    @Transactional
    @GetMapping("/orders/{id}")
    public ResponseEntity<KitaporderEntity> findById(@PathVariable(value = "id") long id){
        return kitaporderRepository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/kitap/{kitap_id}/orders")
    public List<KitaporderEntity> getAllAppointmentsByDoctorId(@PathVariable (value = "kitap_id") Long kitap_id) {
        return kitaporderRepository.findByKitapEntityId(kitap_id);
    }

    @GetMapping("/kullanici/{kullanici_id}/orders")
    public List<KitaporderEntity> getAllAppointmentsByPatientId(@PathVariable (value = "kullanici_id") Long kullanici_id) {
        return kitaporderRepository.findByKullaniciEntityId(kullanici_id);
    }
}
