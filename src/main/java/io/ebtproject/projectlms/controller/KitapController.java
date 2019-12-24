package io.ebtproject.projectlms.controller;

import io.ebtproject.projectlms.model.KitapEntity;
import io.ebtproject.projectlms.repository.KitapRepository;
import io.ebtproject.projectlms.service.KitapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class KitapController {

    @Autowired
    private KitapService KitapService;

    @Autowired
    private KitapRepository kitaprepository;

    @PostMapping("/kitap")
    public ResponseEntity<?> addPTTtoBoard(@Valid @RequestBody KitapEntity kitap, BindingResult result){

        if (result.hasErrors()){
            Map<String, String> errorMap  = new HashMap<>();

            for(FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        KitapEntity yeniKitap = KitapService.saveOrUpdate(kitap);

        return new ResponseEntity<KitapEntity>(yeniKitap, HttpStatus.CREATED);

    }
    @GetMapping("/kitap")
    public Iterable<KitapEntity> getallPt(@Valid KitapEntity kitap,BindingResult Result){
        return KitapService.findAll();

    }

    @GetMapping("/kitap/{pt_id}")
    public ResponseEntity<KitapEntity> getPTById(@PathVariable(value = "pt_id") Long pt_id){

        return kitaprepository.findById(pt_id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/kitap/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id){

        KitapEntity kitap = KitapService.findById(pt_id);
        if  ( kitap == null ) {
            return new ResponseEntity<String>("Kitap Bulunamadı", HttpStatus.OK);
        }
        KitapService.delete(pt_id);

        return new ResponseEntity<String>("Kitap Başarıyla Silindi", HttpStatus.OK);
    }


}


