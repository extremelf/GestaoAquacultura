package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TIPO_DE_CONTROLO", schema = "PROJETO", catalog = "")
public class TipoDeControloEntity {
    private long idtipodecontrolo;
    private String descricao;
    private Collection<ControlodequalidadeEntity> controlodequalidadesByIdtipodecontrolo;

    @Id
    @Column(name = "IDTIPODECONTROLO", nullable = false, precision = 0)
    public long getIdtipodecontrolo() {
        return idtipodecontrolo;
    }

    public void setIdtipodecontrolo(long idtipodecontrolo) {
        this.idtipodecontrolo = idtipodecontrolo;
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
        TipoDeControloEntity that = (TipoDeControloEntity) o;
        return idtipodecontrolo == that.idtipodecontrolo && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtipodecontrolo, descricao);
    }

    @OneToMany(mappedBy = "tipoDeControloByIdtipodecontrolo")
    public Collection<ControlodequalidadeEntity> getControlodequalidadesByIdtipodecontrolo() {
        return controlodequalidadesByIdtipodecontrolo;
    }

    public void setControlodequalidadesByIdtipodecontrolo(Collection<ControlodequalidadeEntity> controlodequalidadesByIdtipodecontrolo) {
        this.controlodequalidadesByIdtipodecontrolo = controlodequalidadesByIdtipodecontrolo;
    }
}
