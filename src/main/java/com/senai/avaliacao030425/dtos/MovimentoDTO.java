package com.senai.avaliacao030425.dtos;

import com.senai.avaliacao030425.Enums.Classificacao;

import java.util.Date;

public class MovimentoDTO {
    private Long id;
    private Date data_movimento;
    private double valor;
    private String observacao;
    private Classificacao classificacao;

    public MovimentoDTO() {}

    public MovimentoDTO(Long id, Date data_movimento, double valor, String observacao, Classificacao classificacao) {
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

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
}
