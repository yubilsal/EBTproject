package io.ebtproject.projectlms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "kitaporder")
public class KitaporderEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kitap_id")
    private KitapEntity kitapEntity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kullanıcı_id")
    private KullaniciEntity kullaniciEntity;

    @Column(name = "tarih")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date tarih;

    public KitaporderEntity() {}

    public KitaporderEntity(Date tarih) {
        this.tarih = tarih;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KitapEntity getKitapEntity() {
        return kitapEntity;
    }

    public void setKitapEntity(KitapEntity kitapEntity) {
        this.kitapEntity = kitapEntity;
    }

    public KullaniciEntity getKullaniciEntity() {
        return kullaniciEntity;
    }

    public void setKullaniciEntity(KullaniciEntity kullaniciEntity) {
        this.kullaniciEntity = kullaniciEntity;
    }

    public Date getarih() {
        return tarih;
    }

    public void settarih(Date tarih) {
        this.tarih = tarih;
    }
}



