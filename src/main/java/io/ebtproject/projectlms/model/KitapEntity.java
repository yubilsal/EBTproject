package io.ebtproject.projectlms.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "kitap", schema = "lms", catalog = "")
public class KitapEntity {
    private Long id;
    private String kitapAdi;
    private String yazarAdi;
    private int isbn;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "kitap_adi")
    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    @Basic
    @Column(name = "yazar_adi")
    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    @Basic
    @Column(name = "isbn")
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
        return id == that.id &&
                isbn == that.isbn &&
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
