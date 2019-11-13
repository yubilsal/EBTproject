package io.ebtproject.projectlms.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "kitaporder", schema = "lms", catalog = "")
public class KitaporderEntity {
    private int id;
    private Integer kullanıcıId;
    private Timestamp alınmaTarihi;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "kullanıcı_id")
    public Integer getKullanıcıId() {
        return kullanıcıId;
    }

    public void setKullanıcıId(Integer kullanıcıId) {
        this.kullanıcıId = kullanıcıId;
    }

    @Basic
    @Column(name = "alınma_tarihi")
    public Timestamp getAlınmaTarihi() {
        return alınmaTarihi;
    }

    public void setAlınmaTarihi(Timestamp alınmaTarihi) {
        this.alınmaTarihi = alınmaTarihi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KitaporderEntity that = (KitaporderEntity) o;
        return id == that.id &&
                Objects.equals(kullanıcıId, that.kullanıcıId) &&
                Objects.equals(alınmaTarihi, that.alınmaTarihi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kullanıcıId, alınmaTarihi);
    }
}
