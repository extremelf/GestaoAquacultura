package com.extremelf.DAL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "RACAO", schema = "PROJETO", catalog = "")
public class RacaoEntity {
    private long idracao;
    private Long preco;
    private String marcasdealimento;
    private String descricao;
    private Collection<TanqueespecieEntity> tanqueespeciesByIdracao;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "IDRACAO", nullable = false, precision = 0)
    public long getIdracao() {
        return idracao;
    }

    public void setIdracao(long idracao) {
        this.idracao = idracao;
    }

    @Basic
    @Column(name = "PRECO", nullable = true, precision = 0)
    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    @Basic
    @Column(name = "MARCASDEALIMENTO", nullable = true, length = 30)
    public String getMarcasdealimento() {
        return marcasdealimento;
    }

    public void setMarcasdealimento(String marcasdealimento) {
        this.marcasdealimento = marcasdealimento;
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
        RacaoEntity that = (RacaoEntity) o;
        return idracao == that.idracao && Objects.equals(preco, that.preco) && Objects.equals(marcasdealimento, that.marcasdealimento) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idracao, preco, marcasdealimento, descricao);
    }

    @OneToMany(mappedBy = "racaoByIdracao")
    public Collection<TanqueespecieEntity> getTanqueespeciesByIdracao() {
        return tanqueespeciesByIdracao;
    }

    public void setTanqueespeciesByIdracao(Collection<TanqueespecieEntity> tanqueespeciesByIdracao) {
        this.tanqueespeciesByIdracao = tanqueespeciesByIdracao;
    }
}
