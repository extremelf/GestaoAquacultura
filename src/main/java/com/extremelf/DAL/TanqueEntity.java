package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TANQUE", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name= "Tanque.findAll", query = "SELECT a from TanqueEntity a "),
        @NamedQuery(name = "Tanque.findbyId", query = "SELECT a from TanqueEntity a where a.idtanque = :idtanque"),
        @NamedQuery(name = "Tanque.findbyFase", query = "SELECT  a FROM TanqueEntity a where a.fasetanque = :fasetanque" ),
        @NamedQuery(name = "Tanque.findbylote", query = "SELECT  a FROM TanqueEntity a where a.loteinserido = :loteinserido" )
})
public class TanqueEntity {
    private long idtanque;
    private String fasetanque;
    private Long loteinserido;
    private Long tamanholitroscubicos;
    private Long idagua;
    private Long idfuncionario;
    private Collection<ControlodequalidadeEntity> controlodequalidadesByIdtanque;
    private Collection<ReportaavariaEntity> reportaavariasByIdtanque;
    private AguaEntity aguaByIdagua;
    private FuncionarioEntity funcionarioByIdfuncionario;
    private Collection<TanqueespecieEntity> tanqueespeciesByIdtanque;
    private Collection<TanqueloteEntity> tanquelotesByIdtanque;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDTANQUE", nullable = false, precision = 0)
    public long getIdtanque() {
        return idtanque;
    }

    public void setIdtanque(long idtanque) {
        this.idtanque = idtanque;
    }

    @Basic
    @Column(name = "FASETANQUE", nullable = true, length = 30)
    public String getFasetanque() {
        return fasetanque;
    }

    public void setFasetanque(String fasetanque) {
        this.fasetanque = fasetanque;
    }

    @Basic
    @Column(name = "LOTEINSERIDO", nullable = true, precision = 0)
    public Long getLoteinserido() {
        return loteinserido;
    }

    public void setLoteinserido(Long loteinserido) {
        this.loteinserido = loteinserido;
    }

    @Basic
    @Column(name = "TAMANHOLITROSCUBICOS", nullable = true, precision = 0)
    public Long getTamanholitroscubicos() {
        return tamanholitroscubicos;
    }

    public void setTamanholitroscubicos(Long tamanholitroscubicos) {
        this.tamanholitroscubicos = tamanholitroscubicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TanqueEntity that = (TanqueEntity) o;
        return idtanque == that.idtanque && Objects.equals(fasetanque, that.fasetanque) && Objects.equals(loteinserido, that.loteinserido) && Objects.equals(tamanholitroscubicos, that.tamanholitroscubicos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtanque, fasetanque, loteinserido, tamanholitroscubicos);
    }

    @Basic
    @Column(name = "IDAGUA",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdagua() {
        return idagua;
    }

    public void setIdagua(Long idagua) {
        this.idagua = idagua;
    }

    @Basic
    @Column(name = "IDFUNCIONARIO",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @OneToMany(mappedBy = "tanqueByIdtanque")
    public Collection<ControlodequalidadeEntity> getControlodequalidadesByIdtanque() {
        return controlodequalidadesByIdtanque;
    }

    public void setControlodequalidadesByIdtanque(Collection<ControlodequalidadeEntity> controlodequalidadesByIdtanque) {
        this.controlodequalidadesByIdtanque = controlodequalidadesByIdtanque;
    }

    @OneToMany(mappedBy = "tanqueByIdtanque")
    public Collection<ReportaavariaEntity> getReportaavariasByIdtanque() {
        return reportaavariasByIdtanque;
    }

    public void setReportaavariasByIdtanque(Collection<ReportaavariaEntity> reportaavariasByIdtanque) {
        this.reportaavariasByIdtanque = reportaavariasByIdtanque;
    }

    @ManyToOne
    @JoinColumn(name = "IDAGUA", referencedColumnName = "IDAGUA",insertable = false,updatable = false)
    public AguaEntity getAguaByIdagua() {
        return aguaByIdagua;
    }

    public void setAguaByIdagua(AguaEntity aguaByIdagua) {
        this.aguaByIdagua = aguaByIdagua;
    }

    @ManyToOne
    @JoinColumn(name = "IDFUNCIONARIO", referencedColumnName = "IDFUNCIONARIO",insertable = false,updatable = false)
    public FuncionarioEntity getFuncionarioByIdfuncionario() {
        return funcionarioByIdfuncionario;
    }

    public void setFuncionarioByIdfuncionario(FuncionarioEntity funcionarioByIdfuncionario) {
        this.funcionarioByIdfuncionario = funcionarioByIdfuncionario;
    }

    @OneToMany(mappedBy = "tanqueByIdtanque")
    public Collection<TanqueespecieEntity> getTanqueespeciesByIdtanque() {
        return tanqueespeciesByIdtanque;
    }

    public void setTanqueespeciesByIdtanque(Collection<TanqueespecieEntity> tanqueespeciesByIdtanque) {
        this.tanqueespeciesByIdtanque = tanqueespeciesByIdtanque;
    }

    @OneToMany(mappedBy = "tanqueByIdtanque")
    public Collection<TanqueloteEntity> getTanquelotesByIdtanque() {
        return tanquelotesByIdtanque;
    }

    public void setTanquelotesByIdtanque(Collection<TanqueloteEntity> tanquelotesByIdtanque) {
        this.tanquelotesByIdtanque = tanquelotesByIdtanque;
    }
}
