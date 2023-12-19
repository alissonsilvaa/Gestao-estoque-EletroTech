package controller;

import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoDAO { // DATA ACCESS OBJECTS
    Connection conn;

    public ProdutoDAO()throws SQLException {
        this.conn = Conexao_SQLite.getConexao();
    }

    public ArrayList<Produto> getAll()throws SQLException{

        ArrayList<Produto>produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto; ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getInt("Id"));
            produto.setNome(resultSet.getString("Nome"));
            produto.setDescricao(resultSet.getString("Descricao"));
            produto.setCategoria(resultSet.getString("Categoria"));

            produtos.add(produto);

        }



        return produtos;
    }

    public void insert() throws SQLException{
        String sql = "INSERT INTO Produto VALUES (null, ?,?,?);";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o nome do produto: ");
        String nome = sc.nextLine();
        System.out.println("Informe a descrição do produto: ");
        String descricao = sc.nextLine();
        System.out.println("Informe a categoria do produto: ");
        String categoria = sc.nextLine();
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);
        preparedStatement.setString(3, categoria);
        preparedStatement.executeUpdate();

    }

    public void update() throws SQLException{
        String sql = "UPDATE Produto SET Nome =?, Descricao =?, Categoria =? WHERE Id =?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id do produto: ");
        int id = sc.nextInt();
        System.out.print(String sql = "SELECT Id, Nome, Descricao, Categoria");
        System.out.println("Informe o nome do produto: ");
        String nome = sc.nextLine();
        System.out.println("Informe a descrição do produto: ");
        String descricao = sc.nextLine();
        System.out.println("Informe a categoria do produto: ");
        String categoria = sc.nextLine();
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, nome);
        preparedStatement.setString(3, descricao);
        preparedStatement.setString(4, categoria);
        preparedStatement.executeUpdate();

    }

    public void delete() throws SQLException{
        String sql = "DELETE FROM Produto WHERE Id =?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id do produto: ");
        int id = sc.nextInt();
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public Produto getById(int id) throws SQLException{
        String sql = "SELECT * FROM Produto WHERE Id =?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getInt("Id"));
            produto.setNome(resultSet.getString("Nome"));
            produto.setDescricao(resultSet.getString("Descricao"));
            produto.setCategoria(resultSet.getString("Categoria"));

            return produto;

        }

        return null;
    }



}
