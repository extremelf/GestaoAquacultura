package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "AGUA", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Agua.findAll", query = "SELECT a FROM AguaEntity a"),
        @NamedQuery(name = "Agua.findByIdAgua", query = "SELECT a FROM AguaEntity a WHERE a.idagua = :idAgua")
})
public class AguaEntity {
    private long idagua;
    private String descricao;
    private Collection<TanqueEntity> tanquesByIdagua;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDAGUA", nullable = false, precision = 0)
    public long getIdagua() {
        return idagua;
    }

    public void setIdagua(long idagua) {
        this.idagua = idagua;
    }

    @Basic
    @Column(name = "DESCRICAO", nullable = true, length = 200)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AguaEntity that = (AguaEntity) o;
        return idagua == that.idagua && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idagua, descricao);
    }


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "aguaByIdagua")
    public Collection<TanqueEntity> getTanquesByIdagua() {
        return tanquesByIdagua;
    }

    public void setTanquesByIdagua(Collection<TanqueEntity> tanquesByIdagua) {
        this.tanquesByIdagua = tanquesByIdagua;
    }
}
