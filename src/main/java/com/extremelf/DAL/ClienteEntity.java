package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Cliente.findAll", query = "SELECT a FROM ClienteEntity a"),
        @NamedQuery(name = "Cliente.findById", query = "SELECT a FROM ClienteEntity a WHERE a.idcliente = :idCliente"),
        @NamedQuery(name = "Cliente.findByCC", query = "SELECT a FROM ClienteEntity a WHERE a.cc = :cc"),
        @NamedQuery(name = "Cliente.findByNome", query = "SELECT a FROM ClienteEntity a WHERE a.nome = :nome")
})
public class ClienteEntity {
    private long idcliente;
    private String nome;
    private String nomerua;
    private String codigopostal;
    private Long numeroporta;
    private Long contacto;
    private Long cc;
    private Long contacorrente;
    private CodpostalEntity codpostalByCodigopostal;
    private Collection<EncomendacEntity> encomendacsByIdcliente;
    private Collection<LoteEntity> lotesByIdcliente;

    @Id
    @Column(name = "IDCLIENTE", nullable = false, precision = 0)
    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    @Basic
    @Column(name = "NOME", nullable = true, length = 30)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    @Column(name = "CODIGOPOSTAL",insertable = false,updatable = false, nullable = true, length = 20)
    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
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

    @Basic
    @Column(name = "CC", nullable = true, precision = 0)
    public Long getCc() {
        return cc;
    }

    public void setCc(Long cc) {
        this.cc = cc;
    }

    @Basic
    @Column(name = "CONTACORRENTE", nullable = true, precision = 0)
    public Long getContacorrente() {
        return contacorrente;
    }

    public void setContacorrente(Long contacorrente) {
        this.contacorrente = contacorrente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return idcliente == that.idcliente && Objects.equals(nome, that.nome) && Objects.equals(nomerua, that.nomerua) && Objects.equals(codigopostal, that.codigopostal) && Objects.equals(numeroporta, that.numeroporta) && Objects.equals(contacto, that.contacto) && Objects.equals(cc, that.cc) && Objects.equals(contacorrente, that.contacorrente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcliente, nome, nomerua, codigopostal, numeroporta, contacto, cc, contacorrente);
    }

    @ManyToOne
    @JoinColumn(name = "CODIGOPOSTAL", referencedColumnName = "CODIGOPOSTAL",insertable = false,updatable = false)
    public CodpostalEntity getCodpostalByCodigopostal() {
        return codpostalByCodigopostal;
    }

    public void setCodpostalByCodigopostal(CodpostalEntity codpostalByCodigopostal) {
        this.codpostalByCodigopostal = codpostalByCodigopostal;
    }


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "clienteByIdcliente")
    public Collection<EncomendacEntity> getEncomendacsByIdcliente() {
        return encomendacsByIdcliente;
    }

    public void setEncomendacsByIdcliente(Collection<EncomendacEntity> encomendacsByIdcliente) {
        this.encomendacsByIdcliente = encomendacsByIdcliente;
    }


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "clienteByIdcliente")
    public Collection<LoteEntity> getLotesByIdcliente() {
        return lotesByIdcliente;
    }

    public void setLotesByIdcliente(Collection<LoteEntity> lotesByIdcliente) {
        this.lotesByIdcliente = lotesByIdcliente;
    }
}
