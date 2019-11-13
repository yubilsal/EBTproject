package io.ebtproject.projectlms.controller;

import io.ebtproject.projectlms.model.KitapEntity;
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
@RequestMapping(value="/kitap")
public class KitapController {

    @Autowired
    private KitapService KitapService;

    @PostMapping("/ekle")
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
    @GetMapping("/all")
    public Iterable<KitapEntity> getallPt(@Valid KitapEntity kitap,BindingResult Result){
        return KitapService.findAll();

    }

    @GetMapping("/göster/{pt_id}")
    public ResponseEntity<?> getPTById(@PathVariable Long pt_id){
        KitapEntity kitap = KitapService.findById(pt_id);
        return new ResponseEntity<KitapEntity>(kitap, HttpStatus.OK);
    }

    @DeleteMapping("/sil/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id){
        KitapService.delete(pt_id);

        return new ResponseEntity<String>("Kitap silindi", HttpStatus.OK);
    }


}


