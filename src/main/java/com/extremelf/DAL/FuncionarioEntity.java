package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "FUNCIONARIO", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Funcionario.findAll", query = "SELECT a FROM FuncionarioEntity a"),
        @NamedQuery(name = "Funcionario.findById", query = "SELECT a FROM FuncionarioEntity a WHERE a.idfuncionario = :idFuncionario"),
        @NamedQuery(name = "Funcionario.findByCargo",query = "SELECT a FROM FuncionarioEntity a WHERE a.idcargo =:idCargo"),
        @NamedQuery(name = "Funcionario.findByCc", query = "SELECT a FROM FuncionarioEntity a WHERE a.cc = :cc")
})
public class FuncionarioEntity {
    private long idfuncionario;
    private String nome;
    private String nomerua;
    private Long numeroporta;
    private Long contacto;
    private Long cc;
    private Long idcargo;
    private String codigopostal;
    private Collection<ControlodequalidadeEntity> controlodequalidadesByIdfuncionario;
    private Collection<EncomendacEntity> encomendacsByIdfuncionario;
    private Collection<EncomendafEntity> encomendafsByIdfuncionario;
    private CargoEntity cargoByIdcargo;
    private CodpostalEntity codpostalByCodigopostal;
    private Collection<LoteEntity> lotesByIdfuncionario;
    private Collection<ReportaavariaEntity> reportaavariasByIdfuncionario;
    private Collection<TanqueEntity> tanquesByIdfuncionario;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDFUNCIONARIO", nullable = false, precision = 0)
    public long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @Basic
    @Column(name = "NOME", nullable = true, length = 40)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioEntity that = (FuncionarioEntity) o;
        return idfuncionario == that.idfuncionario && Objects.equals(nome, that.nome) && Objects.equals(nomerua, that.nomerua) && Objects.equals(numeroporta, that.numeroporta) && Objects.equals(contacto, that.contacto) && Objects.equals(cc, that.cc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfuncionario, nome, nomerua, numeroporta, contacto, cc);
    }

    @Basic
    @Column(name = "IDCARGO",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Long idcargo) {
        this.idcargo = idcargo;
    }

    @Basic
    @Column(name = "CODIGOPOSTAL",insertable = false, updatable = false, nullable = true, length = 20)
    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    @OneToMany(mappedBy = "funcionarioByIdfuncionario")
    public Collection<ControlodequalidadeEntity> getControlodequalidadesByIdfuncionario() {
        return controlodequalidadesByIdfuncionario;
    }

    public void setControlodequalidadesByIdfuncionario(Collection<ControlodequalidadeEntity> controlodequalidadesByIdfuncionario) {
        this.controlodequalidadesByIdfuncionario = controlodequalidadesByIdfuncionario;
    }

    @OneToMany(mappedBy = "funcionarioByIdfuncionario")
    public Collection<EncomendacEntity> getEncomendacsByIdfuncionario() {
        return encomendacsByIdfuncionario;
    }

    public void setEncomendacsByIdfuncionario(Collection<EncomendacEntity> encomendacsByIdfuncionario) {
        this.encomendacsByIdfuncionario = encomendacsByIdfuncionario;
    }

    @OneToMany(mappedBy = "funcionarioByIdfuncionario")
    public Collection<EncomendafEntity> getEncomendafsByIdfuncionario() {
        return encomendafsByIdfuncionario;
    }

    public void setEncomendafsByIdfuncionario(Collection<EncomendafEntity> encomendafsByIdfuncionario) {
        this.encomendafsByIdfuncionario = encomendafsByIdfuncionario;
    }

    @ManyToOne
    @JoinColumn(name = "IDCARGO", referencedColumnName = "IDCARGO")
    public CargoEntity getCargoByIdcargo() {
        return cargoByIdcargo;
    }

    public void setCargoByIdcargo(CargoEntity cargoByIdcargo) {
        this.cargoByIdcargo = cargoByIdcargo;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGOPOSTAL", referencedColumnName = "CODIGOPOSTAL")
    public CodpostalEntity getCodpostalByCodigopostal() {
        return codpostalByCodigopostal;
    }

    public void setCodpostalByCodigopostal(CodpostalEntity codpostalByCodigopostal) {
        this.codpostalByCodigopostal = codpostalByCodigopostal;
    }

    @OneToMany(mappedBy = "funcionarioByIdfuncionario")
    public Collection<LoteEntity> getLotesByIdfuncionario() {
        return lotesByIdfuncionario;
    }

    public void setLotesByIdfuncionario(Collection<LoteEntity> lotesByIdfuncionario) {
        this.lotesByIdfuncionario = lotesByIdfuncionario;
    }

    @OneToMany(mappedBy = "funcionarioByIdfuncionario")
    public Collection<ReportaavariaEntity> getReportaavariasByIdfuncionario() {
        return reportaavariasByIdfuncionario;
    }

    public void setReportaavariasByIdfuncionario(Collection<ReportaavariaEntity> reportaavariasByIdfuncionario) {
        this.reportaavariasByIdfuncionario = reportaavariasByIdfuncionario;
    }

    @OneToMany(mappedBy = "funcionarioByIdfuncionario")
    public Collection<TanqueEntity> getTanquesByIdfuncionario() {
        return tanquesByIdfuncionario;
    }

    public void setTanquesByIdfuncionario(Collection<TanqueEntity> tanquesByIdfuncionario) {
        this.tanquesByIdfuncionario = tanquesByIdfuncionario;
    }
}
