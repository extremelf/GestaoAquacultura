package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LINHADEENCOMENDAC", schema = "DATABASEPROJ", catalog = "")
@IdClass(LinhadeencomendacEntityPK.class)
@NamedQueries({
        @NamedQuery(name= "Linhaencomendac.findAll", query = "SELECT a from LinhadeencomendacEntity a "),
        @NamedQuery(name = "Linhaencomendac.findbyId", query = "SELECT a from LinhadeencomendacEntity a where a.idencomendac = :idencomendac"),
        @NamedQuery(name = "Linhaencomendac.findbyIdLote", query = "SELECT a from LinhadeencomendacEntity a where a.idlote = :idlote")
})
public class LinhadeencomendacEntity {
    private long idencomendac;
    private long idlote;
    private Long precounitario;
    private String descricao;
    private EncomendacEntity encomendacByIdencomendac;
    private LoteEntity loteByIdlote;

    @Id
    @Column(name = "IDENCOMENDAC",insertable = false,updatable = false, nullable = false, precision = 0)
    public long getIdencomendac() {
        return idencomendac;
    }

    public void setIdencomendac(long idencomendac) {
        this.idencomendac = idencomendac;
    }

    @Id
    @Column(name = "IDLOTE",insertable = false,updatable = false, nullable = false, precision = 0)
    public long getIdlote() {
        return idlote;
    }

    public void setIdlote(long idlote) {
        this.idlote = idlote;
    }

    @Basic
    @Column(name = "PRECOUNITARIO", nullable = true, precision = 0)
    public Long getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(Long precounitario) {
        this.precounitario = precounitario;
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
        LinhadeencomendacEntity that = (LinhadeencomendacEntity) o;
        return idencomendac == that.idencomendac && idlote == that.idlote && Objects.equals(precounitario, that.precounitario) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idencomendac, idlote, precounitario, descricao);
    }

    @ManyToOne
    @JoinColumn(name = "IDENCOMENDAC", referencedColumnName = "IDENCOMENDAC",insertable = false,updatable = false, nullable = false)
    public EncomendacEntity getEncomendacByIdencomendac() {
        return encomendacByIdencomendac;
    }

    public void setEncomendacByIdencomendac(EncomendacEntity encomendacByIdencomendac) {
        this.encomendacByIdencomendac = encomendacByIdencomendac;
    }

    @ManyToOne
    @JoinColumn(name = "IDLOTE", referencedColumnName = "IDLOTE",insertable = false,updatable = false, nullable = false)
    public LoteEntity getLoteByIdlote() {
        return loteByIdlote;
    }

    public void setLoteByIdlote(LoteEntity loteByIdlote) {
        this.loteByIdlote = loteByIdlote;
    }
}
