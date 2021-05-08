package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CONTROLODEQUALIDADE", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ControloDeQualidade.findAll", query = "SELECT a FROM ControlodequalidadeEntity a"),
        @NamedQuery(name = "ControloDeQualidade.findByIds", query = "SELECT a FROM ControlodequalidadeEntity a WHERE a.idtipodecontrolo = :idTipoControlo  AND a.idfuncionario = :idFuncionario AND a.idtanque = :idTanque"),
        @NamedQuery(name = "ControloDeQualidade.findByIdFuncionario", query = "SELECT a FROM ControlodequalidadeEntity a WHERE a.idfuncionario = :idFuncionario"),
        @NamedQuery(name = "ControloDeQualidade.findByIdTanque", query = "SELECT a FROM ControlodequalidadeEntity a WHERE a.idtanque = :idTanque")
})
@IdClass(ControlodequalidadeEntityPK.class)
public class ControlodequalidadeEntity {
    private long idtipodecontrolo;
    private long idfuncionario;
    private long idtanque;
    private TipoDeControloEntity tipoDeControloByIdtipodecontrolo;
    private FuncionarioEntity funcionarioByIdfuncionario;
    private TanqueEntity tanqueByIdtanque;

    @Id
    @Column(name = "IDTIPODECONTROLO", nullable = false, precision = 0)
    public long getIdtipodecontrolo() {
        return idtipodecontrolo;
    }

    public void setIdtipodecontrolo(long idtipodecontrolo) {
        this.idtipodecontrolo = idtipodecontrolo;
    }

    @Id
    @Column(name = "IDFUNCIONARIO", nullable = false, precision = 0)
    public long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @Id
    @Column(name = "IDTANQUE", nullable = false, precision = 0)
    public long getIdtanque() {
        return idtanque;
    }

    public void setIdtanque(long idtanque) {
        this.idtanque = idtanque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControlodequalidadeEntity that = (ControlodequalidadeEntity) o;
        return idtipodecontrolo == that.idtipodecontrolo && idfuncionario == that.idfuncionario && idtanque == that.idtanque;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtipodecontrolo, idfuncionario, idtanque);
    }

    @ManyToOne
    @JoinColumn(name = "IDTIPODECONTROLO", referencedColumnName = "IDTIPODECONTROLO", nullable = false)
    public TipoDeControloEntity getTipoDeControloByIdtipodecontrolo() {
        return tipoDeControloByIdtipodecontrolo;
    }

    public void setTipoDeControloByIdtipodecontrolo(TipoDeControloEntity tipoDeControloByIdtipodecontrolo) {
        this.tipoDeControloByIdtipodecontrolo = tipoDeControloByIdtipodecontrolo;
    }

    @ManyToOne
    @JoinColumn(name = "IDFUNCIONARIO", referencedColumnName = "IDFUNCIONARIO", nullable = false)
    public FuncionarioEntity getFuncionarioByIdfuncionario() {
        return funcionarioByIdfuncionario;
    }

    public void setFuncionarioByIdfuncionario(FuncionarioEntity funcionarioByIdfuncionario) {
        this.funcionarioByIdfuncionario = funcionarioByIdfuncionario;
    }

    @ManyToOne
    @JoinColumn(name = "IDTANQUE", referencedColumnName = "IDTANQUE", nullable = false)
    public TanqueEntity getTanqueByIdtanque() {
        return tanqueByIdtanque;
    }

    public void setTanqueByIdtanque(TanqueEntity tanqueByIdtanque) {
        this.tanqueByIdtanque = tanqueByIdtanque;
    }
}
