package com.lucas.lucasjbc.domain;

public abstract class Funcionario {

    private String nome;
    private String tipo;
    private double valorHora;
    private double horasTrabalhadas;

    public String getNome() {
        return nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public String getTipo() {
        return tipo;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public Funcionario(String nome, String tipo, double valorHora, double horasTrabalhadas) {
        this.nome = nome;
        this.tipo = tipo;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public abstract Double CalcularSalario();


}
