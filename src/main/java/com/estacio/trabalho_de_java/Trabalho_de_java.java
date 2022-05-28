package com.estacio.trabalho_de_java;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import java.io.IOException;

public class Trabalho_de_java {

    boolean isRunning = true;

    public void vendedor() {
        while (isRunning) {
            Scanner opt = new Scanner(System.in);
            String nome_vendedor,cpf_vendedor, endereco;
            float salario_vendedor ;
            int valor;
            System.out.print("Menu: 1 para cadastrar um Vendedor 2 para listar os Vendedor 3 para editar um Vendedor 4 para excluir um Vendedor ou 0 para sair \n");
            valor = opt.nextInt();
            if (valor == 1) {
                
                System.out.println("Insira o nome do Vendedor \n");
                nome_vendedor = opt.next();
                System.out.println("CPF do vendedor \n");
                cpf_vendedor = opt.next();
                System.out.println("Salario do vendedor \n");
                salario_vendedor=opt.nextFloat();
                Vendedor v1 = new Vendedor(null, nome_vendedor, cpf_vendedor, salario_vendedor);
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(v1);
                em.getTransaction().commit();
                em.close();
                System.out.println("Vendedor Cadastrado com sucesso");

            }
            if(valor == 2 ){
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                
            }
            if (valor == 0) {
                isRunning = false;
            }

        }
    }

    public void cliente() {

    }

    public void item() {

    }

    public void venda() {

    }

    public static void main(String[] args) {
        var mainInstance = new Trabalho_de_java();
        Cliente cliente1 = new Cliente(1, "danillo", "555-555-55.44", "Rua tal tal");
        Scanner opt = new Scanner(System.in);
        int valor;
        //EntityManagerFactory emf= Persistence.createEntityManagerFactory("trabalho-java");
        //EntityManager em = emf.createEntityManager();

        //em.getTransaction().begin();
        //em.persist(p1);
        //em.getTransaction().commit();
        while (mainInstance.isRunning) {
            System.out.print("Menu: 1 para Vendedor 2 para cliente 3 para Item 4 para venda ou 0 para sair \n");
            valor = opt.nextInt();
            switch (valor) {
                case 1 ->
                    mainInstance.vendedor();
                case 2 ->
                    mainInstance.cliente();
                case 3 ->
                    mainInstance.item();
                case 4 ->
                    mainInstance.venda();
                case 0 ->
                    mainInstance.isRunning = false;
                default ->
                    System.out.println("Opção invalida");
            }

        }

    }
}
