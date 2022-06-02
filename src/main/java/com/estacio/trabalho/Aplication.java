package com.estacio.trabalho;

import com.estacio.trabalho.controller.ClientController;
import com.estacio.trabalho.controller.ItemController;
import com.estacio.trabalho.controller.VendaController;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

import com.estacio.trabalho.model.Cliente;
import com.estacio.trabalho.controller.VendedorController;
import com.estacio.trabalho.model.ItensVenda;
import com.estacio.trabalho.model.Venda;
import com.estacio.trabalho.model.Vendedor;
import javax.persistence.PersistenceException;

public class Aplication {

    boolean isRunning = true;

    public void vendedor() {
        while (isRunning) {
            try {
                Scanner opt = new Scanner(System.in);
                String nome_vendedor, cpf_vendedor;
                float salario_vendedor;
                int valor, id;
                System.out.print("Menu: 1 para cadastrar um Vendedor 2 para listar os Vendedores 3 para editar um Vendedor 4 para excluir um Vendedor ou 0 para sair \n");
                valor = opt.nextInt();
                if (valor == 1) {

                    System.out.println("Insira o nome do Vendedor \n");
                    nome_vendedor = opt.next();
                    System.out.println("CPF do vendedor \n");
                    cpf_vendedor = opt.next();
                    System.out.println("Salario do vendedor \n");
                    salario_vendedor = opt.nextFloat();

                    // Salvar Vendedor no banco
                    VendedorController.cadastrarVendedor(nome_vendedor, cpf_vendedor, salario_vendedor);

                    System.out.println("Vendedor Cadastrado com sucesso");

                }
                if (valor == 2) {
                    System.out.println(VendedorController.listar());
                }
                if (valor == 3) {

                    System.out.println("ID do vendedor");
                    id = opt.nextInt();
                    System.out.println("Insira o nome do Vendedor \n");
                    nome_vendedor = opt.next();
                    System.out.println("CPF do vendedor \n");
                    cpf_vendedor = opt.next();
                    System.out.println("Salario do vendedor \n");
                    salario_vendedor = opt.nextFloat();
                    VendedorController.update(nome_vendedor, cpf_vendedor, salario_vendedor, id);
                    System.out.println("Dados alterados! Nome: " + nome_vendedor + " CPF do vendedor: " + " Salario do vendedor: " + salario_vendedor);

                }
                if (valor == 4) {
                    System.out.println("ID do vendedor");
                    id = opt.nextInt();
                    VendedorController.delete(id);
                    System.out.println("Usuario Apagado!");
                }
                if (valor == 0) {
                    isRunning = false;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex);
            }

        }
    }

    public void cliente() {
        while (isRunning) {
            try {
                Scanner opt = new Scanner(System.in);
                String nome_cliente, cpf_cliente, endereco;
                int valor, id;
                System.out.print("Menu: 1 para cadastrar um Cliente 2 para listar os Cliente 3 para editar um Cliente 4 para excluir um Cliente ou 0 para sair \n");
                valor = opt.nextInt();
                if (valor == 1) {

                    System.out.println("Insira o nome do Cliente \n");
                    nome_cliente = opt.next();
                    System.out.println("CPF do Cliente \n");
                    cpf_cliente = opt.next();
                    System.out.println("Endereco do Cliente \n");
                    endereco = opt.next();

                    // Salvar Vendedor no banco
                    ClientController.cadastrarCliente(nome_cliente, cpf_cliente, endereco);

                    System.out.println("Cliente Cadastrado com sucesso");

                }
                if (valor == 2) {
                    System.out.println(ClientController.listar());
                }
                if (valor == 3) {

                    System.out.println("ID do Cliente");
                    id = opt.nextInt();
                    System.out.println("Insira o nome do Cliente \n");
                    nome_cliente = opt.next();
                    System.out.println("CPF do Cliente \n");
                    cpf_cliente = opt.next();
                    System.out.println("Endereço do cliente \n");
                    endereco = opt.next();
                    ClientController.update(nome_cliente, cpf_cliente, endereco, id);
                    System.out.println("Dados alterados! Nome: " + nome_cliente + " CPF do Cliente: " + cpf_cliente + " Endereco do cliente: " + endereco);

                }
                if (valor == 4) {
                    System.out.println("ID do Cliente");
                    id = opt.nextInt();
                    ClientController.delete(id);
                    System.out.println("Usuario Apagado!");
                }
                if (valor == 0) {
                    isRunning = false;
                }

            } catch (IllegalArgumentException ex) {
                System.out.println(ex);
            }

        }
    }

    public void item() {
        while (isRunning) {
            Scanner opt = new Scanner(System.in);
            String nome_item, unidade_item;
            int id, valor;
            float valor_item;
            System.out.print("Menu: 1 para cadastrar um Item 2 para listar os Itens 3 para editar um Item 4 para excluir um Item ou 0 para sair \n");
            valor = opt.nextInt();
            if (valor == 1) {

                System.out.println("Insira o nome do Item \n");
                nome_item = opt.next();
                System.out.println("Unidade do Item \n");
                unidade_item = opt.next();
                System.out.println("Valor do Item \n");
                valor_item = opt.nextFloat();

                // Salvar Item no banco
                ItemController.cadastrarItem(nome_item, unidade_item, valor_item);

                System.out.println("Item Cadastrado com sucesso");

            }
            if (valor == 2) {
                System.out.println(ItemController.listar());
            }
            if (valor == 3) {

                System.out.println("ID do Item");
                id = opt.nextInt();
                System.out.println("Insira o nome do Item \n");
                nome_item = opt.next();
                System.out.println("Unidade do item \n");
                unidade_item = opt.next();
                System.out.println("Valor do item \n");
                valor_item = opt.nextFloat();
                ItemController.update(nome_item, unidade_item, valor_item, id);
                System.out.println("Dados alterados! Nome: " + nome_item + " Unidade: " + unidade_item + " Valor do item: " + valor_item);

            }
            if (valor == 4) {
                System.out.println("ID do Item");
                id = opt.nextInt();
                ItemController.delete(id);
                System.out.println("Item Apagado!");
            }
            if (valor == 0) {
                isRunning = false;
            }

        }
    }

    public void venda() {
        while (isRunning) {
            try {
                String data_da_venda, forma_de_pagamento;
                int id_cliente,id_vendedor;
                Cliente objeto_cliente;
                Vendedor objeto_vendedor;
                
                Scanner opt = new Scanner(System.in);
                System.out.println("Insira o ID do cliente");
                id_cliente = opt.nextInt();
                objeto_cliente = ClientController.listarUm(id_cliente);
                System.out.println("Selecionou cliente : "+objeto_cliente.nome);
                
                System.out.println("Insira o ID do vendedor");
                id_vendedor = opt.nextInt();
                objeto_vendedor = VendedorController.listarUm(id_vendedor);
                System.out.println("Selecionou vendedor : "+objeto_vendedor.nome);
                
                
                System.out.println("Informe a data da venda");
                data_da_venda = opt.next();
                
                System.out.println("Informe o metodo de pagamento");
                forma_de_pagamento = opt.next();

                Venda vd = new Venda(data_da_venda, forma_de_pagamento, objeto_vendedor, objeto_cliente);
                
                System.out.println("Valor total: "+vd.getValorTotal());
                System.out.println("Venda cadastrada com sucesso");
                System.out.println("Data da venda: ");
                System.out.println(vd.getDataDaVenda());
                System.out.println("Cliente: ");
                System.out.println(vd.getCliente().nome);
                System.out.println("Vendedor");
                System.out.println(vd.getVendedor().nome );
                System.out.println("Forma de pagamento");
                System.out.println(vd.getFormaPagamento());
                System.out.println("Endereco do cliente");
                System.out.println(vd.getEnderecoEntrega());
                
                 

            } catch (PersistenceException ex) {
                System.out.println("Erro: " + ex);
            }

        }
    }

    public static void main(String[] args) {
        var mainInstance = new Aplication();
        Scanner opt = new Scanner(System.in);
        int valor;

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
