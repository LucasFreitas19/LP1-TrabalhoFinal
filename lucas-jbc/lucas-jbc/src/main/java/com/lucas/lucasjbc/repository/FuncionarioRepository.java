package com.lucas.lucasjbc.repository;

import com.lucas.lucasjbc.Analista;
import com.lucas.lucasjbc.domain.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Funcionario> findAll() {
        List<Funcionario> FindFuncionario = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {


            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:h2:mem:testdb",
                    "admin",
                    "123456"
            );

            statement = connection.createStatement();

            String FindFuncionariosql = "select * from funcionario";

            resultSet = statement.executeQuery(FindFuncionariosql);

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String tipo = resultSet.getString("tipo");


               Funcionario funcionario = new Analista(nome, tipo, 0,0);

                FindFuncionario.add(funcionario);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        return FindFuncionario;
    }

}


