package org.example;

import controller.FornecedorDAO;
import controller.ProdutoDAO;
import model.Fornecedor;
import model.Produto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ProdutoDAO produto = new ProdutoDAO();
        FornecedorDAO fornecedor = new FornecedorDAO();
        int opcao = 0;
        do {
            System.out.println(
                    "\n[1] - Produto" +
                            "\n[2] - Fornecedor" +
                            "\n[3] - Sair");

            opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println("Oque deseja fazer? " +
                        "\n[1] - Inserir" +
                        "\n[2] - Atualizar " +
                        "\n[3] - Deletar ");

            } else if (opcao == 2) {
                System.out.println("Oque deseja fazer? " +
                        "\n[1] - Inserir" +
                        "\n[2] - Atualizar " +
                        "\n[3] - Deletar ");

            } while (opcao != 0) ;

        }
}










