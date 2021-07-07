package com.lucas.lucasjbc;

import com.lucas.lucasjbc.domain.Funcionario;

public class Gerente extends Funcionario {




    public Gerente(String nome, String tipo, double valorHora, double horasTrabalhadas) {
        super(nome,tipo, valorHora, horasTrabalhadas);
    }

    @Override
    public Double CalcularSalario() {
        double salario = getValorHora() * getHorasTrabalhadas();
        return salario;
    }
}
