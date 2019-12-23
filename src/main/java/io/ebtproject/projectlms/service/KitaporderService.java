package io.ebtproject.projectlms.service;
import io.ebtproject.projectlms.repository.KitaporderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.ebtproject.projectlms.repository.KitaporderRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KitaporderService {

    @Autowired
    private KitaporderRepository kitaporderRepository;




}
