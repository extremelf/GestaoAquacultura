package com.extremelf.DAL;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ControlodequalidadeEntityPK implements Serializable {
    private long idtipodecontrolo;
    private long idfuncionario;
    private long idtanque;

    @Column(name = "IDTIPODECONTROLO", nullable = false, precision = 0)
    @Id
    public long getIdtipodecontrolo() {
        return idtipodecontrolo;
    }

    public void setIdtipodecontrolo(long idtipodecontrolo) {
        this.idtipodecontrolo = idtipodecontrolo;
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
        ControlodequalidadeEntityPK that = (ControlodequalidadeEntityPK) o;
        return idtipodecontrolo == that.idtipodecontrolo && idfuncionario == that.idfuncionario && idtanque == that.idtanque;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtipodecontrolo, idfuncionario, idtanque);
    }
}
