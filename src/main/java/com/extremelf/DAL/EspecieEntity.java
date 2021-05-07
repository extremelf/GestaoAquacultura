package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ESPECIE", schema = "PROJETO", catalog = "")
public class EspecieEntity {
    private long idespecie;
    private String nome;
    private String descricao;
    private Collection<LinhaencomendafEntity> linhaencomendafsByIdespecie;
    private Collection<LoteEntity> lotesByIdespecie;
    private Collection<TanqueespecieEntity> tanqueespeciesByIdespecie;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDESPECIE", nullable = false, precision = 0)
    public long getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(long idespecie) {
        this.idespecie = idespecie;
    }

    @Basic
    @Column(name = "NOME", nullable = true, length = 100)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        EspecieEntity that = (EspecieEntity) o;
        return idespecie == that.idespecie && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idespecie, nome, descricao);
    }

    @OneToMany(mappedBy = "especieByIdespecie")
    public Collection<LinhaencomendafEntity> getLinhaencomendafsByIdespecie() {
        return linhaencomendafsByIdespecie;
    }

    public void setLinhaencomendafsByIdespecie(Collection<LinhaencomendafEntity> linhaencomendafsByIdespecie) {
        this.linhaencomendafsByIdespecie = linhaencomendafsByIdespecie;
    }

    @OneToMany(mappedBy = "especieByIdespecie")
    public Collection<LoteEntity> getLotesByIdespecie() {
        return lotesByIdespecie;
    }

    public void setLotesByIdespecie(Collection<LoteEntity> lotesByIdespecie) {
        this.lotesByIdespecie = lotesByIdespecie;
    }

    @OneToMany(mappedBy = "especieByIdespecie")
    public Collection<TanqueespecieEntity> getTanqueespeciesByIdespecie() {
        return tanqueespeciesByIdespecie;
    }

    public void setTanqueespeciesByIdespecie(Collection<TanqueespecieEntity> tanqueespeciesByIdespecie) {
        this.tanqueespeciesByIdespecie = tanqueespeciesByIdespecie;
    }
}
