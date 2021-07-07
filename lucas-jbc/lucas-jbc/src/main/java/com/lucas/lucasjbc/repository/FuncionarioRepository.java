package com.lucas.lucasjbc.repository;

import com.lucas.lucasjbc.Analista;
import com.lucas.lucasjbc.domain.Funcionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncionarioRepository {

    private String jdbcDriver = "org.h2.Driver";
    private String url = "jdbc:h2:mem:testdb";
    private String username = "admin";
    private String password = "123456";

    public void criarTabelaFuncionario() {

        Statement statement = null;
        Connection connection = null;

        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();


            String sqlFuncionario = "create table funcionario (" + "nome varchar(255) not null, "+ "tipo varchar(50) not null, " + "horasTrabalhadas double not null, " + "valorHoras double not null " + ")";

            statement.execute(sqlFuncionario);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }


            } catch (SQLException throwables) {

                throwables.printStackTrace();
            }

        }


    }


    public void addFuncionario(Funcionario funcionario) {
        Statement statement = null;
        Connection connection = null;

        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();


            String sqlFuncionario = "insert into funcionario (nome, tipo, horasTrabalhadas, valorHoras) " + "values ( '" + funcionario.getNome() + "' , '" + funcionario.getTipo() + "' , '" + funcionario.getHorasTrabalhadas() + "' , '" + funcionario.getValorHora() + "' )";

            statement.executeUpdate(sqlFuncionario);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }


            } catch (SQLException throwables) {

                throwables.printStackTrace();
            }

        }


    }
}


