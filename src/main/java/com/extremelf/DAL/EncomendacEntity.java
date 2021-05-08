package com.extremelf.DAL;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ENCOMENDAC", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name = "EncomendaC.findAll", query = "SELECT a FROM EncomendacEntity a"),
        @NamedQuery(name = "Encomenda.findByIdEncomendaC", query = "SELECT a FROM EncomendacEntity a WHERE a.idencomendac = :idEncomendaC"),
        @NamedQuery(name = "Encomenda.findByIdCliente", query = "SELECT a FROM EncomendacEntity a WHERE a.idcliente = :idCliente")
})
public class EncomendacEntity {
    private long idencomendac;
    private Time data;
    private Long precototal;
    private Long idfuncionario;
    private Long idcliente;
    private FuncionarioEntity funcionarioByIdfuncionario;
    private ClienteEntity clienteByIdcliente;
    private Collection<LinhadeencomendacEntity> linhadeencomendacsByIdencomendac;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDENCOMENDAC", nullable = false, precision = 0)
    public long getIdencomendac() {
        return idencomendac;
    }

    public void setIdencomendac(long idencomendac) {
        this.idencomendac = idencomendac;
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
    @Column(name = "PRECOTOTAL", nullable = true, precision = 0)
    public Long getPrecototal() {
        return precototal;
    }

    public void setPrecototal(Long precototal) {
        this.precototal = precototal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncomendacEntity that = (EncomendacEntity) o;
        return idencomendac == that.idencomendac && Objects.equals(data, that.data) && Objects.equals(precototal, that.precototal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idencomendac, data, precototal);
    }

    @Basic
    @Column(name = "IDFUNCIONARIO", nullable = true, precision = 0)
    public Long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @Basic
    @Column(name = "IDCLIENTE", nullable = true, precision = 0)
    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    @ManyToOne
    @JoinColumn(name = "IDFUNCIONARIO", referencedColumnName = "IDFUNCIONARIO")
    public FuncionarioEntity getFuncionarioByIdfuncionario() {
        return funcionarioByIdfuncionario;
    }

    public void setFuncionarioByIdfuncionario(FuncionarioEntity funcionarioByIdfuncionario) {
        this.funcionarioByIdfuncionario = funcionarioByIdfuncionario;
    }

    @ManyToOne
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    public ClienteEntity getClienteByIdcliente() {
        return clienteByIdcliente;
    }

    public void setClienteByIdcliente(ClienteEntity clienteByIdcliente) {
        this.clienteByIdcliente = clienteByIdcliente;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "encomendacByIdencomendac")
    public Collection<LinhadeencomendacEntity> getLinhadeencomendacsByIdencomendac() {
        return linhadeencomendacsByIdencomendac;
    }

    public void setLinhadeencomendacsByIdencomendac(Collection<LinhadeencomendacEntity> linhadeencomendacsByIdencomendac) {
        this.linhadeencomendacsByIdencomendac = linhadeencomendacsByIdencomendac;
    }
}
