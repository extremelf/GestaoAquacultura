package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "LOTE", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name= "Lote.findAll", query = "SELECT a from LoteEntity a "),
        @NamedQuery(name = "Lote.findbyId", query = "SELECT a from LoteEntity a where a.idlote = :idlote")
})
public class LoteEntity {
    private long idlote;
    private Long quantidade;
    private Long idespecie;
    private Long idfuncionario;
    private Long idcliente;
    private Collection<LinhadeencomendacEntity> linhadeencomendacsByIdlote;
    private EspecieEntity especieByIdespecie;
    private FuncionarioEntity funcionarioByIdfuncionario;
    private ClienteEntity clienteByIdcliente;
    private Collection<TanqueloteEntity> tanquelotesByIdlote;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDLOTE", nullable = false, precision = 0)
    public long getIdlote() {
        return idlote;
    }

    public void setIdlote(long idlote) {
        this.idlote = idlote;
    }

    @Basic
    @Column(name = "QUANTIDADE", nullable = true, precision = 0)
    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoteEntity that = (LoteEntity) o;
        return idlote == that.idlote && Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idlote, quantidade);
    }

    @Basic
    @Column(name = "IDESPECIE",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(Long idespecie) {
        this.idespecie = idespecie;
    }

    @Basic
    @Column(name = "IDFUNCIONARIO",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @Basic
    @Column(name = "IDCLIENTE",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    @OneToMany(mappedBy = "loteByIdlote")
    public Collection<LinhadeencomendacEntity> getLinhadeencomendacsByIdlote() {
        return linhadeencomendacsByIdlote;
    }

    public void setLinhadeencomendacsByIdlote(Collection<LinhadeencomendacEntity> linhadeencomendacsByIdlote) {
        this.linhadeencomendacsByIdlote = linhadeencomendacsByIdlote;
    }

    @ManyToOne
    @JoinColumn(name = "IDESPECIE", referencedColumnName = "IDESPECIE")
    public EspecieEntity getEspecieByIdespecie() {
        return especieByIdespecie;
    }

    public void setEspecieByIdespecie(EspecieEntity especieByIdespecie) {
        this.especieByIdespecie = especieByIdespecie;
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

    @OneToMany(mappedBy = "loteByIdlote")
    public Collection<TanqueloteEntity> getTanquelotesByIdlote() {
        return tanquelotesByIdlote;
    }

    public void setTanquelotesByIdlote(Collection<TanqueloteEntity> tanquelotesByIdlote) {
        this.tanquelotesByIdlote = tanquelotesByIdlote;
    }
}
