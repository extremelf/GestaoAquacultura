package com.extremelf.DAL;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TanqueloteEntityPK implements Serializable {
    private long idlote;
    private long idtanque;

    @Column(name = "IDLOTE", nullable = false, precision = 0)
    @Id
    public long getIdlote() {
        return idlote;
    }

    public void setIdlote(long idlote) {
        this.idlote = idlote;
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
        TanqueloteEntityPK that = (TanqueloteEntityPK) o;
        return idlote == that.idlote && idtanque == that.idtanque;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idlote, idtanque);
    }
}
