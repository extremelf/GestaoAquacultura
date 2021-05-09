package com.extremelf.DAL;

import jdk.jfr.Name;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "TANQUEESPECIE", schema = "DATABASEPROJ", catalog = "")
@NamedQueries({
        @NamedQuery(name= "Tanqueespecie.findAll", query = "SELECT a from TanqueespecieEntity a "),
        @NamedQuery(name = "Tanqueespecie.findbyId", query = "SELECT a from TanqueespecieEntity a where a.idlotedecriacao = :idlotedecriacao"),
        @NamedQuery(name = "Tanqueespecie.findbyEspecie", query = "SELECT a FROM TanqueespecieEntity a where a.idespecie = :idespecie"),
        @NamedQuery(name = "Tanqueespecie.findbyTanque", query = "SELECT a FROM TanqueespecieEntity a where a.idtanque = :idtanque")
})
public class TanqueespecieEntity {
    private long idlotedecriacao;
    private String fasedecrescimento;
    private String tamanho;
    private Long peso;
    private Long quantidade;
    private Time data;
    private Long idespecie;
    private Long idracao;
    private Long idtanque;
    private EspecieEntity especieByIdespecie;
    private RacaoEntity racaoByIdracao;
    private TanqueEntity tanqueByIdtanque;

    @Id
    @Column(name = "IDLOTEDECRIACAO", nullable = false, precision = 0)
    public long getIdlotedecriacao() {
        return idlotedecriacao;
    }

    public void setIdlotedecriacao(long idlotedecriacao) {
        this.idlotedecriacao = idlotedecriacao;
    }

    @Basic
    @Column(name = "FASEDECRESCIMENTO", nullable = true, length = 30)
    public String getFasedecrescimento() {
        return fasedecrescimento;
    }

    public void setFasedecrescimento(String fasedecrescimento) {
        this.fasedecrescimento = fasedecrescimento;
    }

    @Basic
    @Column(name = "TAMANHO", nullable = true, length = 50)
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Basic
    @Column(name = "PESO", nullable = true, precision = 0)
    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    @Basic
    @Column(name = "QUANTIDADE", nullable = true, precision = 0)
    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    @Basic
    @Column(name = "DATA", nullable = true)
    public Time getData() {
        return data;
    }

    public void setData(Time data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TanqueespecieEntity that = (TanqueespecieEntity) o;
        return idlotedecriacao == that.idlotedecriacao && Objects.equals(fasedecrescimento, that.fasedecrescimento) && Objects.equals(tamanho, that.tamanho) && Objects.equals(peso, that.peso) && Objects.equals(quantidade, that.quantidade) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idlotedecriacao, fasedecrescimento, tamanho, peso, quantidade, data);
    }

    @Basic
    @Column(name = "IDESPECIE",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(Long idespecie) {
        this.idespecie = idespecie;
    }

    @Basic
    @Column(name = "IDRACAO",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdracao() {
        return idracao;
    }

    public void setIdracao(Long idracao) {
        this.idracao = idracao;
    }

    @Basic
    @Column(name = "IDTANQUE",insertable = false,updatable = false, nullable = true, precision = 0)
    public Long getIdtanque() {
        return idtanque;
    }

    public void setIdtanque(Long idtanque) {
        this.idtanque = idtanque;
    }

    @ManyToOne
    @JoinColumn(name = "IDESPECIE", referencedColumnName = "IDESPECIE",insertable = false,updatable = false)
    public EspecieEntity getEspecieByIdespecie() {
        return especieByIdespecie;
    }

    public void setEspecieByIdespecie(EspecieEntity especieByIdespecie) {
        this.especieByIdespecie = especieByIdespecie;
    }

    @ManyToOne
    @JoinColumn(name = "IDRACAO", referencedColumnName = "IDRACAO",insertable = false,updatable = false)
    public RacaoEntity getRacaoByIdracao() {
        return racaoByIdracao;
    }

    public void setRacaoByIdracao(RacaoEntity racaoByIdracao) {
        this.racaoByIdracao = racaoByIdracao;
    }

    @ManyToOne
    @JoinColumn(name = "IDTANQUE", referencedColumnName = "IDTANQUE",insertable = false,updatable = false)
    public TanqueEntity getTanqueByIdtanque() {
        return tanqueByIdtanque;
    }

    public void setTanqueByIdtanque(TanqueEntity tanqueByIdtanque) {
        this.tanqueByIdtanque = tanqueByIdtanque;
    }
}
