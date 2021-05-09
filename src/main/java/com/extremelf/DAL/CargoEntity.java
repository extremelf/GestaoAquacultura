package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CARGO", schema = "PROJETO", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Cargo.findAll", query = "SELECT a FROM CargoEntity a" ),
        @NamedQuery(name = "Cargo.findByIdCargo", query = "SELECT a FROM CargoEntity a WHERE a.idcargo = :idCargo")
})
public class CargoEntity {
    private long idcargo;
    private String descricao;
    private Collection<FuncionarioEntity> funcionariosByIdcargo;

    @Id
    @Column(name = "IDCARGO", nullable = false, precision = 0)
    public long getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(long idcargo) {
        this.idcargo = idcargo;
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
        CargoEntity that = (CargoEntity) o;
        return idcargo == that.idcargo && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcargo, descricao);
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cargoByIdcargo")
    public Collection<FuncionarioEntity> getFuncionariosByIdcargo() {
        return funcionariosByIdcargo;
    }

    public void setFuncionariosByIdcargo(Collection<FuncionarioEntity> funcionariosByIdcargo) {
        this.funcionariosByIdcargo = funcionariosByIdcargo;
    }
}
