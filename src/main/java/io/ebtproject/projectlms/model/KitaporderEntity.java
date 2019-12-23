package io.ebtproject.projectlms.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

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

    @Column(name = "alınma_tarihi")
    private Date alınmaTarihi;

    public KitaporderEntity() {}

    public KitaporderEntity(Date alınmaTarihi) {
        this.alınmaTarihi = alınmaTarihi;
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

    public Date getAlınmaTarihi() {
        return alınmaTarihi;
    }

    public void setAlınmaTarihi(Date alınmaTarihi) {
        this.alınmaTarihi = alınmaTarihi;
    }
}



