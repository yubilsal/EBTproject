package io.ebtproject.projectlms.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "kullanici", schema = "lms", catalog = "")

public class KullaniciEntity {
    private int id;
    private String isim;
    private String soyisim;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "isim")
    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    @Basic
    @Column(name = "soyisim")
    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KullaniciEntity that = (KullaniciEntity) o;
        return id == that.id &&
                Objects.equals(isim, that.isim) &&
                Objects.equals(soyisim, that.soyisim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isim, soyisim);
    }
}
