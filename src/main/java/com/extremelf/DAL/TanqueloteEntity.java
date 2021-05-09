package com.extremelf.DAL;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "TANQUELOTE", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name= "Tanquelote.findAll", query = "SELECT a from TanqueloteEntity a "),
        @NamedQuery(name = "Tanquelote.findbyId", query = "SELECT a from TanqueloteEntity a where a.idlote = :idlote"),
        @NamedQuery(name = "Tanquelote.findbyTanque", query = "SELECT a FROM TanqueloteEntity a where a.idtanque = :idtanque")
})
@IdClass(TanqueloteEntityPK.class)
public class TanqueloteEntity {
    private long idlote;
    private long idtanque;
    private Time data;
    private Long quantidadedespescaportanque;
    private LoteEntity loteByIdlote;
    private TanqueEntity tanqueByIdtanque;

    @Id
    @Column(name = "IDLOTE",insertable = false,updatable = false, nullable = false, precision = 0)
    public long getIdlote() {
        return idlote;
    }

    public void setIdlote(long idlote) {
        this.idlote = idlote;
    }

    @Id
    @Column(name = "IDTANQUE",insertable = false,updatable = false, nullable = false, precision = 0)
    public long getIdtanque() {
        return idtanque;
    }

    public void setIdtanque(long idtanque) {
        this.idtanque = idtanque;
    }

    @Basic
    @Column(name = "DATA", nullable = true)
    public Time getData() {
        return data;
    }

    public void setData(Time data) {
        this.data = data;
    }

    @Basic
    @Column(name = "QUANTIDADEDESPESCAPORTANQUE", nullable = true, precision = 0)
    public Long getQuantidadedespescaportanque() {
        return quantidadedespescaportanque;
    }

    public void setQuantidadedespescaportanque(Long quantidadedespescaportanque) {
        this.quantidadedespescaportanque = quantidadedespescaportanque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TanqueloteEntity that = (TanqueloteEntity) o;
        return idlote == that.idlote && idtanque == that.idtanque && Objects.equals(data, that.data) && Objects.equals(quantidadedespescaportanque, that.quantidadedespescaportanque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idlote, idtanque, data, quantidadedespescaportanque);
    }

    @ManyToOne
    @JoinColumn(name = "IDLOTE", referencedColumnName = "IDLOTE",insertable = false,updatable = false, nullable = false)
    public LoteEntity getLoteByIdlote() {
        return loteByIdlote;
    }

    public void setLoteByIdlote(LoteEntity loteByIdlote) {
        this.loteByIdlote = loteByIdlote;
    }

    @ManyToOne
    @JoinColumn(name = "IDTANQUE", referencedColumnName = "IDTANQUE",insertable = false,updatable = false, nullable = false)
    public TanqueEntity getTanqueByIdtanque() {
        return tanqueByIdtanque;
    }

    public void setTanqueByIdtanque(TanqueEntity tanqueByIdtanque) {
        this.tanqueByIdtanque = tanqueByIdtanque;
    }
}
