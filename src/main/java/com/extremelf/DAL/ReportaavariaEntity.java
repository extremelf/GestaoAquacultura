package com.extremelf.DAL;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "REPORTAAVARIA", schema = "PROJETO", catalog = "")
@IdClass(ReportaavariaEntityPK.class)
public class ReportaavariaEntity {
    private long idtipodeavaria;
    private long idfuncionario;
    private long idtanque;
    private Time data;
    private String descricao;
    private TipoDeAvariaEntity tipoDeAvariaByIdtipodeavaria;
    private FuncionarioEntity funcionarioByIdfuncionario;
    private TanqueEntity tanqueByIdtanque;

    @Id
    @Column(name = "IDTIPODEAVARIA", nullable = false, precision = 0)
    public long getIdtipodeavaria() {
        return idtipodeavaria;
    }

    public void setIdtipodeavaria(long idtipodeavaria) {
        this.idtipodeavaria = idtipodeavaria;
    }

    @Id
    @Column(name = "IDFUNCIONARIO", nullable = false, precision = 0)
    public long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @Id
    @Column(name = "IDTANQUE", nullable = false, precision = 0)
    public long getIdtanque() {
        return idtanque;
    }

    public void setIdtanque(long idtanque) {
        this.idtanque = idtanque;
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
        ReportaavariaEntity that = (ReportaavariaEntity) o;
        return idtipodeavaria == that.idtipodeavaria && idfuncionario == that.idfuncionario && idtanque == that.idtanque && Objects.equals(data, that.data) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtipodeavaria, idfuncionario, idtanque, data, descricao);
    }

    @ManyToOne
    @JoinColumn(name = "IDTIPODEAVARIA", referencedColumnName = "IDTIPODEAVARIA", nullable = false)
    public TipoDeAvariaEntity getTipoDeAvariaByIdtipodeavaria() {
        return tipoDeAvariaByIdtipodeavaria;
    }

    public void setTipoDeAvariaByIdtipodeavaria(TipoDeAvariaEntity tipoDeAvariaByIdtipodeavaria) {
        this.tipoDeAvariaByIdtipodeavaria = tipoDeAvariaByIdtipodeavaria;
    }

    @ManyToOne
    @JoinColumn(name = "IDFUNCIONARIO", referencedColumnName = "IDFUNCIONARIO", nullable = false)
    public FuncionarioEntity getFuncionarioByIdfuncionario() {
        return funcionarioByIdfuncionario;
    }

    public void setFuncionarioByIdfuncionario(FuncionarioEntity funcionarioByIdfuncionario) {
        this.funcionarioByIdfuncionario = funcionarioByIdfuncionario;
    }

    @ManyToOne
    @JoinColumn(name = "IDTANQUE", referencedColumnName = "IDTANQUE", nullable = false)
    public TanqueEntity getTanqueByIdtanque() {
        return tanqueByIdtanque;
    }

    public void setTanqueByIdtanque(TanqueEntity tanqueByIdtanque) {
        this.tanqueByIdtanque = tanqueByIdtanque;
    }
}
