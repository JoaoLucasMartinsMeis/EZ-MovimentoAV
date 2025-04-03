package com.senai.avaliacao030425.Enums;

public enum Classificacao {
    ENTRADA("Entrada"),
    SAIDA("Saída");

    private final String descricao;

    Classificacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
