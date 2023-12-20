package controller;


import model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class FornecedorDAO {
    Connection conn;
    public FornecedorDAO() throws SQLException {
        this.conn = Conexao_SQLite.getConexao();
    }
    public ArrayList<Fornecedor> getAll() throws SQLException{

        ArrayList<Fornecedor>fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedor; ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(resultSet.getInt("Id"));
            fornecedor.setCnpjCpf(resultSet.getString("CNPJ/CPF"));
            fornecedor.setRazaoSocial(resultSet.getString("Razaõ Social"));
            fornecedor.setNome(resultSet.getString("Nome"));

            fornecedores.add(fornecedor);

        }

        return fornecedores;
    }

    public void insert() throws SQLException{
        String sql = "INSERT INTO Fornecedor VALUES (null,?,?,?);";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o CNPJ/CPF do fornecedor: ");
        String cnpjCpf = sc.nextLine();
        System.out.println("Informe a razao social do fornecedor: ");
        String razaoSocial = sc.nextLine();
        System.out.println("Informe o nome do fornecedor: ");
        String nome = sc.nextLine();
        preparedStatement.setString(1, cnpjCpf);
        preparedStatement.setString(2, razaoSocial);
        preparedStatement.setString(3, nome);
        preparedStatement.executeUpdate();
    }

    public void update() throws SQLException{
        String sql = "UPDATE Fornecedor SET CNPJ/CPF =?, Razaõ Social =?, Nome =? WHERE Id =?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id do fornecedor: ");
        int id = sc.nextInt();
        System.out.println("Informe o CNPJ/CPF do fornecedor: ");
        String cnpjCpf = sc.nextLine();
        System.out.println("Informe a razao social do fornecedor: ");
        String razaoSocial = sc.nextLine();
        System.out.println("Informe o nome do fornecedor: ");
        String nome = sc.nextLine();
    }

    public void delete() throws SQLException{
        String sql = "DELETE FROM Fornecedor WHERE Id =?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id do fornecedor: ");
        int id = sc.nextInt();
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public Fornecedor getById(int id) throws SQLException{
        String sql = "SELECT * FROM Fornecedor WHERE Id =?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(resultSet.getInt("Id"));
            fornecedor.setCnpjCpf(resultSet.getString("CNPJ/CPF"));
            fornecedor.setRazaoSocial(resultSet.getString("Razaõ Social"));
            fornecedor.setNome(resultSet.getString("Nome"));

            return fornecedor;

        }

        return null;
    }



}
