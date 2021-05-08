package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "FORNECEDOR", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Fornecedor.findAll", query = "SELECT a FROM FornecedorEntity a"),
        @NamedQuery(name = "Fornecedor.findById", query = "SELECT a FROM FornecedorEntity a WHERE a.idfornecedor = :idFornecedor"),
        @NamedQuery(name = "Fornecedor.findByNome", query = "SELECT a FROM FornecedorEntity a WHERE a.nomeempresafornecedor = :Nome")
})
public class FornecedorEntity {
    private long idfornecedor;
    private String nomeempresafornecedor;
    private String nomerua;
    private Long numeroporta;
    private Long contacto;
    private String codigopostal;
    private Collection<EncomendafEntity> encomendafsByIdfornecedor;
    private CodpostalEntity codpostalByCodigopostal;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDFORNECEDOR", nullable = false, precision = 0)
    public long getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(long idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    @Basic
    @Column(name = "NOMEEMPRESAFORNECEDOR", nullable = true, length = 100)
    public String getNomeempresafornecedor() {
        return nomeempresafornecedor;
    }

    public void setNomeempresafornecedor(String nomeempresafornecedor) {
        this.nomeempresafornecedor = nomeempresafornecedor;
    }

    @Basic
    @Column(name = "NOMERUA", nullable = true, length = 30)
    public String getNomerua() {
        return nomerua;
    }

    public void setNomerua(String nomerua) {
        this.nomerua = nomerua;
    }

    @Basic
    @Column(name = "NUMEROPORTA", nullable = true, precision = 0)
    public Long getNumeroporta() {
        return numeroporta;
    }

    public void setNumeroporta(Long numeroporta) {
        this.numeroporta = numeroporta;
    }

    @Basic
    @Column(name = "CONTACTO", nullable = true, precision = 0)
    public Long getContacto() {
        return contacto;
    }

    public void setContacto(Long contacto) {
        this.contacto = contacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FornecedorEntity that = (FornecedorEntity) o;
        return idfornecedor == that.idfornecedor && Objects.equals(nomeempresafornecedor, that.nomeempresafornecedor) && Objects.equals(nomerua, that.nomerua) && Objects.equals(numeroporta, that.numeroporta) && Objects.equals(contacto, that.contacto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfornecedor, nomeempresafornecedor, nomerua, numeroporta, contacto);
    }

    @Basic
    @Column(name = "CODIGOPOSTAL",insertable = false,updatable = false, nullable = true, length = 10)
    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    @OneToMany(mappedBy = "fornecedorByIdfornecedor")
    public Collection<EncomendafEntity> getEncomendafsByIdfornecedor() {
        return encomendafsByIdfornecedor;
    }

    public void setEncomendafsByIdfornecedor(Collection<EncomendafEntity> encomendafsByIdfornecedor) {
        this.encomendafsByIdfornecedor = encomendafsByIdfornecedor;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGOPOSTAL", referencedColumnName = "CODIGOPOSTAL")
    public CodpostalEntity getCodpostalByCodigopostal() {
        return codpostalByCodigopostal;
    }

    public void setCodpostalByCodigopostal(CodpostalEntity codpostalByCodigopostal) {
        this.codpostalByCodigopostal = codpostalByCodigopostal;
    }
}
