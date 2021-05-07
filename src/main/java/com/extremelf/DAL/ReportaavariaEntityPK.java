package com.extremelf.DAL;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ReportaavariaEntityPK implements Serializable {
    private long idtipodeavaria;
    private long idfuncionario;
    private long idtanque;

    @Column(name = "IDTIPODEAVARIA", nullable = false, precision = 0)
    @Id
    public long getIdtipodeavaria() {
        return idtipodeavaria;
    }

    public void setIdtipodeavaria(long idtipodeavaria) {
        this.idtipodeavaria = idtipodeavaria;
    }

    @Column(name = "IDFUNCIONARIO", nullable = false, precision = 0)
    @Id
    public long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @Column(name = "IDTANQUE", nullable = false, precision = 0)
    @Id
    public long getIdtanque() {
        return idtanque;
    }

    public void setIdtanque(long idtanque) {
        this.idtanque = idtanque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportaavariaEntityPK that = (ReportaavariaEntityPK) o;
        return idtipodeavaria == that.idtipodeavaria && idfuncionario == that.idfuncionario && idtanque == that.idtanque;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtipodeavaria, idfuncionario, idtanque);
    }
}
