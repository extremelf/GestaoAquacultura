package com.extremelf.DAL;

import org.hibernate.validator.constraints.time.DurationMax;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ENCOMENDAF", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name = "EncomendaF.findAll", query = "SELECT a FROM EncomendafEntity a"),
        @NamedQuery(name = "EncomendaF.findByIdEncomendaF", query = "SELECT a FROM EncomendafEntity a WHERE a.idencomendaf = :idEncomendaF")

})
public class EncomendafEntity {
    private long idencomendaf;
    private Long precototal;
    private Time data;
    private Long idfornecedor;
    private Long idfuncionario;
    private FornecedorEntity fornecedorByIdfornecedor;
    private FuncionarioEntity funcionarioByIdfuncionario;
    private Collection<LinhaencomendafEntity> linhaencomendafsByIdencomendaf;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDENCOMENDAF", nullable = false, precision = 0)
    public long getIdencomendaf() {
        return idencomendaf;
    }

    public void setIdencomendaf(long idencomendaf) {
        this.idencomendaf = idencomendaf;
    }

    @Basic
    @Column(name = "PRECOTOTAL", nullable = true, precision = 0)
    public Long getPrecototal() {
        return precototal;
    }

    public void setPrecototal(Long precototal) {
        this.precototal = precototal;
    }

    @Basic
    @Column(name = "DATA", nullable = true)
    public Time getData() {
        return data;
    }

    public void setData(Time data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncomendafEntity that = (EncomendafEntity) o;
        return idencomendaf == that.idencomendaf && Objects.equals(precototal, that.precototal) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idencomendaf, precototal, data);
    }

    @Basic
    @Column(name = "IDFORNECEDOR", nullable = true, precision = 0)
    public Long getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(Long idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    @Basic
    @Column(name = "IDFUNCIONARIO", nullable = true, precision = 0)
    public Long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @ManyToOne
    @JoinColumn(name = "IDFORNECEDOR", referencedColumnName = "IDFORNECEDOR")
    public FornecedorEntity getFornecedorByIdfornecedor() {
        return fornecedorByIdfornecedor;
    }

    public void setFornecedorByIdfornecedor(FornecedorEntity fornecedorByIdfornecedor) {
        this.fornecedorByIdfornecedor = fornecedorByIdfornecedor;
    }

    @ManyToOne
    @JoinColumn(name = "IDFUNCIONARIO", referencedColumnName = "IDFUNCIONARIO")
    public FuncionarioEntity getFuncionarioByIdfuncionario() {
        return funcionarioByIdfuncionario;
    }

    public void setFuncionarioByIdfuncionario(FuncionarioEntity funcionarioByIdfuncionario) {
        this.funcionarioByIdfuncionario = funcionarioByIdfuncionario;
    }

    @OneToMany(mappedBy = "encomendafByIdencomendaf")
    public Collection<LinhaencomendafEntity> getLinhaencomendafsByIdencomendaf() {
        return linhaencomendafsByIdencomendaf;
    }

    public void setLinhaencomendafsByIdencomendaf(Collection<LinhaencomendafEntity> linhaencomendafsByIdencomendaf) {
        this.linhaencomendafsByIdencomendaf = linhaencomendafsByIdencomendaf;
    }
}
