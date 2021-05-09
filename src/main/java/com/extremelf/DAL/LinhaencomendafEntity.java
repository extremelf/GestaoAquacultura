package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LINHAENCOMENDAF", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name= "Linhaencomendaf.findAll", query = "SELECT a from LinhaencomendafEntity a "),
        @NamedQuery(name = "Linhaencomendaf.findbyIdlinha", query = "SELECT a from LinhaencomendafEntity a where a.idlinhaf = :idlinhaf"),
        @NamedQuery(name = "Linhaencomendaf.findbyIdencomenda", query = "SELECT a FROM LinhaencomendafEntity a where a.idencomendaf = :idencomendaf")
})
public class LinhaencomendafEntity {
    private long idlinhaf;
    private Long quantidade;
    private Long precounitario;
    private Long idencomendaf;
    private Long idespecie;
    private EncomendafEntity encomendafByIdencomendaf;
    private EspecieEntity especieByIdespecie;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDLINHAF", nullable = false, precision = 0)
    public long getIdlinhaf() {
        return idlinhaf;
    }

    public void setIdlinhaf(long idlinhaf) {
        this.idlinhaf = idlinhaf;
    }

    @Basic
    @Column(name = "QUANTIDADE", nullable = true, precision = 0)
    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    @Basic
    @Column(name = "PRECOUNITARIO", nullable = true, precision = 0)
    public Long getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(Long precounitario) {
        this.precounitario = precounitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaencomendafEntity that = (LinhaencomendafEntity) o;
        return idlinhaf == that.idlinhaf && Objects.equals(quantidade, that.quantidade) && Objects.equals(precounitario, that.precounitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idlinhaf, quantidade, precounitario);
    }

    @Basic
    @Column(name = "IDENCOMENDAF",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdencomendaf() {
        return idencomendaf;
    }

    public void setIdencomendaf(Long idencomendaf) {
        this.idencomendaf = idencomendaf;
    }

    @Basic
    @Column(name = "IDESPECIE",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(Long idespecie) {
        this.idespecie = idespecie;
    }

    @ManyToOne
    @JoinColumn(name = "IDENCOMENDAF", referencedColumnName = "IDENCOMENDAF")
    public EncomendafEntity getEncomendafByIdencomendaf() {
        return encomendafByIdencomendaf;
    }

    public void setEncomendafByIdencomendaf(EncomendafEntity encomendafByIdencomendaf) {
        this.encomendafByIdencomendaf = encomendafByIdencomendaf;
    }

    @ManyToOne
    @JoinColumn(name = "IDESPECIE", referencedColumnName = "IDESPECIE")
    public EspecieEntity getEspecieByIdespecie() {
        return especieByIdespecie;
    }

    public void setEspecieByIdespecie(EspecieEntity especieByIdespecie) {
        this.especieByIdespecie = especieByIdespecie;
    }
}
