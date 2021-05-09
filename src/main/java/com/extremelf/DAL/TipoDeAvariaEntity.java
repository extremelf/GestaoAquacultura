package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TIPO_DE_AVARIA", schema = "DATABASEPROJ", catalog = "")
@NamedQueries({
        @NamedQuery(name= "TipoDeAvaria.findAll", query = "SELECT a from TipoDeAvariaEntity a "),
        @NamedQuery(name = "TipoDeAvaria.findbyId", query = "SELECT a from TipoDeAvariaEntity a where a.idtipodeavaria = :idtipodeavaria")
})
public class TipoDeAvariaEntity {
    private long idtipodeavaria;
    private String descricao;
    private Collection<ReportaavariaEntity> reportaavariasByIdtipodeavaria;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDTIPODEAVARIA", nullable = false, precision = 0)
    public long getIdtipodeavaria() {
        return idtipodeavaria;
    }

    public void setIdtipodeavaria(long idtipodeavaria) {
        this.idtipodeavaria = idtipodeavaria;
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
        TipoDeAvariaEntity that = (TipoDeAvariaEntity) o;
        return idtipodeavaria == that.idtipodeavaria && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtipodeavaria, descricao);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDeAvariaByIdtipodeavaria")
    public Collection<ReportaavariaEntity> getReportaavariasByIdtipodeavaria() {
        return reportaavariasByIdtipodeavaria;
    }

    public void setReportaavariasByIdtipodeavaria(Collection<ReportaavariaEntity> reportaavariasByIdtipodeavaria) {
        this.reportaavariasByIdtipodeavaria = reportaavariasByIdtipodeavaria;
    }
}
