package io.ebtproject.projectlms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "kullanici")

public class KullaniciEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "isim")
    private String isim;

    @Column(name = "soyisim")
    private String soyisim;

    @OneToMany(mappedBy = "kullaniciEntity", fetch = FetchType.EAGER)
    @JsonBackReference("kullanici")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<KitaporderEntity> kitaporderEntities;

    public KullaniciEntity() {
    }

    public KullaniciEntity(String isim, String soyisim) {
        this.isim = isim;
        this.soyisim = soyisim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public List<KitaporderEntity> getKitaporderEntities() {
        return kitaporderEntities;
    }

    public void setKitaporderEntities(List<KitaporderEntity> kitaporderEntities) {
        this.kitaporderEntities = kitaporderEntities;
    }

}






