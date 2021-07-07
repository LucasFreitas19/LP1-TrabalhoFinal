package com.lucas.lucasjbc.controller;

import com.lucas.lucasjbc.Analista;
import com.lucas.lucasjbc.Gerente;
import com.lucas.lucasjbc.domain.Funcionario;
import com.lucas.lucasjbc.repository.FuncionarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {


    @GetMapping
    public void criarTabelaFuncionario() {



        double HorasA = Math.random() * 24;
        double HorasB = Math.random() * 24;
        double HorasC = Math.random() * 24;
        double[] ArrayHoras = new double[3];
        ArrayHoras[0] = HorasA;
        ArrayHoras[1] = HorasB;
        ArrayHoras[2] = HorasC;

        double ValorA = Math.random() * 40;
        double ValorB = Math.random() * 40;
        double ValorC = Math.random() * 40;
        double[] ArrayValores = new double[3];
        ArrayValores[0] = ValorA;
        ArrayValores[1] = ValorB;
        ArrayValores[2] = ValorC;


        Funcionario funcionario = new Analista("Lucas", "Analista", ArrayHoras[0], ArrayValores[0]);
        Funcionario funcionario1 = new Analista("Paola","Analista", ArrayHoras[1], ArrayValores[1]);
        Funcionario funcionario2 = new Gerente("Visionne", "Gerente", ArrayHoras[2], ArrayValores[2]);

        System.out.println("repositorio");
        FuncionarioRepository repositoryFuncionario = new FuncionarioRepository();

        System.out.println("criando tabela");
        repositoryFuncionario.criarTabelaFuncionario();

        System.out.println("Salvando Funcionario");
        repositoryFuncionario.addFuncionario(funcionario);
        repositoryFuncionario.addFuncionario(funcionario1);
        repositoryFuncionario.addFuncionario(funcionario2);


    }


}

