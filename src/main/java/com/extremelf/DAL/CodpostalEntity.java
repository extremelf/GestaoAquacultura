package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CODPOSTAL", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name = "CodPostal.findAll", query = "SELECT a FROM CodpostalEntity a"),
        @NamedQuery(name = "CodPostal.findByIdCodPostal", query = "SELECT a FROM CodpostalEntity a WHERE a.codigopostal = :idCodPostal")
})
public class CodpostalEntity {
    private String codigopostal;
    private String descricao;
    private Collection<ClienteEntity> clientesByCodigopostal;
    private Collection<FornecedorEntity> fornecedorsByCodigopostal;
    private Collection<FuncionarioEntity> funcionariosByCodigopostal;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "CODIGOPOSTAL", nullable = false, length = 10, insertable = false, updatable = false)
    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
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
        CodpostalEntity that = (CodpostalEntity) o;
        return Objects.equals(codigopostal, that.codigopostal) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigopostal, descricao);
    }
  
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "codpostalByCodigopostal")
    public Collection<ClienteEntity> getClientesByCodigopostal() {
        return clientesByCodigopostal;
    }

    public void setClientesByCodigopostal(Collection<ClienteEntity> clientesByCodigopostal) {
        this.clientesByCodigopostal = clientesByCodigopostal;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "codpostalByCodigopostal")
    public Collection<FornecedorEntity> getFornecedorsByCodigopostal() {
        return fornecedorsByCodigopostal;
    }

    public void setFornecedorsByCodigopostal(Collection<FornecedorEntity> fornecedorsByCodigopostal) {
        this.fornecedorsByCodigopostal = fornecedorsByCodigopostal;
    }
  
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "codpostalByCodigopostal")
    public Collection<FuncionarioEntity> getFuncionariosByCodigopostal() {
        return funcionariosByCodigopostal;
    }

    public void setFuncionariosByCodigopostal(Collection<FuncionarioEntity> funcionariosByCodigopostal) {
        this.funcionariosByCodigopostal = funcionariosByCodigopostal;
    }
}
