package io.ebtproject.projectlms.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "kitap")
public class KitapEntity {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "kitap_adi")
    private String kitapAdi;


    @Column(name = "yazar_adi")
    private String yazarAdi;

    @Column(name = "isbn")
    private int isbn;

    @OneToMany(mappedBy = "kitapEntity",fetch = FetchType.EAGER)
    @JsonBackReference("kitap")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List< KitaporderEntity > kitaporderEntities;

    public KitapEntity() {

    }

    public KitapEntity(String kitapAdi, String yazarAdi, int isbn) {
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.isbn = isbn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KitapEntity that = (KitapEntity) o;
        return  id.equals(that.id) &&
                isbn == that.isbn  &&
                Objects.equals(kitapAdi, that.kitapAdi) &&
                Objects.equals(yazarAdi, that.yazarAdi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kitapAdi, yazarAdi, isbn);
    }

    @Override
    public String toString() {
        return "KitapEntity{" +
                "id=" + id +
                ", kitapAdi='" + kitapAdi + '\'' +
                ", yazarAdi='" + yazarAdi + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
