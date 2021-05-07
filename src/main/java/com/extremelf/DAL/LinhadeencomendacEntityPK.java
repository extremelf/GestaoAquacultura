package com.extremelf.DAL;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LinhadeencomendacEntityPK implements Serializable {
    private long idencomendac;
    private long idlote;

    @Column(name = "IDENCOMENDAC", nullable = false, precision = 0)
    @Id
    public long getIdencomendac() {
        return idencomendac;
    }

    public void setIdencomendac(long idencomendac) {
        this.idencomendac = idencomendac;
    }

    @Column(name = "IDLOTE", nullable = false, precision = 0)
    @Id
    public long getIdlote() {
        return idlote;
    }

    public void setIdlote(long idlote) {
        this.idlote = idlote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhadeencomendacEntityPK that = (LinhadeencomendacEntityPK) o;
        return idencomendac == that.idencomendac && idlote == that.idlote;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idencomendac, idlote);
    }
}
