package io.ebtproject.projectlms.controller;


import io.ebtproject.projectlms.model.KullaniciEntity;
import io.ebtproject.projectlms.repository.KullaniciRepository;
import io.ebtproject.projectlms.service.KullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class KullaniciController {

    @Autowired
    private KullaniciService kullaniciService;

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @PostMapping("/kullanici")
    public ResponseEntity<?> kullaniciEkle(@Valid @RequestBody KullaniciEntity kullanici){

        KullaniciEntity yenikullanici = kullaniciService.saveOrUpdate(kullanici);

        return new ResponseEntity<>(yenikullanici, HttpStatus.CREATED);

    }

    @GetMapping("/kullanici")
    public Iterable<KullaniciEntity> getallPt(@Valid KullaniciEntity kullanici,BindingResult Result){
        return kullaniciService.findAll();

    }

    @GetMapping("/kullanici/{pt_id}")
    public ResponseEntity<KullaniciEntity> getPTById(@PathVariable(value = "pt_id") Long pt_id){

        return kullaniciRepository.findById(pt_id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/kullanici/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id){
        KullaniciEntity kullanici = kullaniciService.findById(pt_id);
        if  ( kullanici == null ) {
            return new ResponseEntity<String>("Kullanıcı Bulunamadı", HttpStatus.OK);
        }

        kullaniciService.delete(pt_id);

        return new ResponseEntity<String>("Kullanıcı Başarıyla Silindi", HttpStatus.OK);
    }

}
