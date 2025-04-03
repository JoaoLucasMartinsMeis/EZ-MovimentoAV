package com.senai.avaliacao030425.models;

import com.senai.avaliacao030425.Enums.Classificacao;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "movimento")
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data_movimento;
    private double valor;
    private String observacao;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    public Movimento() {}

    public Movimento(Long id, Date data_movimento, double valor, String observacao, Classificacao classificacao) {
        this.id = id;
        this.data_movimento = data_movimento;
        this.valor = valor;
        this.observacao = observacao;
        this.classificacao = classificacao;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_movimento() {
        return data_movimento;
    }
    public void setData_movimento(Date data_movimento) {
        this.data_movimento = data_movimento;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movimento movimento = (Movimento) o;
        return Double.compare(valor, movimento.valor) == 0 && Objects.equals(id, movimento.id) && Objects.equals(data_movimento, movimento.data_movimento) && Objects.equals(observacao, movimento.observacao) && classificacao == movimento.classificacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data_movimento, valor, observacao, classificacao);
    }
}
