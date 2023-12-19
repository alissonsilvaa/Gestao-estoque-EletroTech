package org.example;

import controller.ProdutoDAO;
import model.Produto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<Produto> produtos = produtoDAO.getAll();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Listar");
            System.out.println("5 - Sair");
            System.out.println("Digite a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    produtoDAO.insert();
                    break;
                case 2:
                    produtoDAO.update();
                    System.out.print("Digite o ID do produto:");
                    int id = scanner.nextInt();
                    System.out.print(produtos.get(id));
                    System.out.println("Produto atualizado com sucesso! ");
                    break;
                case 3:
                    produtoDAO.delete();
                    System.out.println("Produto deletado com sucesso! ");
                    break;
                case 4:
                    for (Produto produto : produtos) {
                        System.out.println(produto);
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while(opcao > 0);


        //ArrayList<Produto> produtos = new ArrayList<>();
        produtoDAO.insert();
        produtoDAO.update();
        produtoDAO.delete();





        }




    }
