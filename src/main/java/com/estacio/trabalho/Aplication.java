package com.estacio.trabalho;

import com.estacio.trabalho.controller.ClientController;
import com.estacio.trabalho.controller.ItemController;
import java.util.Scanner;

import com.estacio.trabalho.model.Cliente;
import com.estacio.trabalho.controller.VendedorController;
import com.estacio.trabalho.model.Item;
import com.estacio.trabalho.model.Venda;
import com.estacio.trabalho.model.Vendedor;


public class Aplication {

    boolean isRunning = true;

    public void vendedor() {
        while (isRunning) {
            
                Scanner opt = new Scanner(System.in);
                String nome_vendedor, cpf_vendedor;
                float salario_vendedor, valor;
                int id;
                System.out.print("Menu: 1 para cadastrar um Vendedor | 2 para listar os Vendedores | 3 para editar um Vendedor | 4 para excluir um Vendedor | 5 para listar um Vendedor ou 0 para sair \n");
                valor = Integer.parseInt(opt.nextLine());
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
                if(valor == 5){
                  Vendedor objeto_vendedor;
                  int id_vendedor;
                  System.out.println("Insira o ID do vendedor");
                  id_vendedor = opt.nextInt();
                  objeto_vendedor = VendedorController.listarUm(id_vendedor);
                  System.out.println("Selecionou vendedor : "+objeto_vendedor.getNome());
                }
                if (valor == 0) {
                    isRunning = false;
                }
            

        }
    }

    public void cliente() {
        while (isRunning) {
            try {
                Scanner opt = new Scanner(System.in);
                String nome_cliente, cpf_cliente, endereco;
                int id,valor;
                
                System.out.print("Menu: 1 para cadastrar um Cliente | 2 para listar os Cliente | 3 para editar um Cliente | 4 para excluir um Cliente | 5 para listar um Cliente | ou 0 para sair \n");
                valor = Integer.parseInt(opt.nextLine());
                if (valor == 1) {

                    System.out.println("Insira o nome do Cliente: ");
                    nome_cliente = opt.nextLine();
                    System.out.println("CPF do Cliente: ");
                    cpf_cliente = opt.nextLine();
                    System.out.println("Endereco do Cliente: ");
                    endereco = opt.nextLine();

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
                if(valor == 5){
                Cliente objeto_cliente;
                int id_cliente;
                
                System.out.println("Insira o ID do cliente");
                id_cliente = opt.nextInt();
                objeto_cliente = ClientController.listarUm(id_cliente);
                System.out.println("Selecionou cliente : "+objeto_cliente.getNome());
                }
                if (valor == 0) {
                    isRunning = false;
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
    }

    public void item() {
        while (isRunning) {
            try{
                Scanner opt = new Scanner(System.in);
            String nome_item, unidade_item;
            int id;
            float valor_item,valor;
            System.out.print("Menu: 1 para cadastrar um Item | 2 para listar os Itens | 3 para editar um Item | 4 para excluir um Item | 5 para listar um item | ou 0 para sair \n");
            valor = Integer.parseInt(opt.nextLine());
            if (valor == 1) {

                System.out.println("Insira o nome do Item \n");
                nome_item = opt.next();
                System.out.println("Unidade do Item \n");
                unidade_item = opt.next();
                System.out.println("Valor do Item \n");
                valor_item = opt.nextFloat();

                // Salvar Item no banco
                ItemController.cadastrarItem(nome_item, unidade_item,valor_item);

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
            if(valor == 5){
                Item objeto_item;
                int id_item;
                System.out.println("Insira o ID do item");
                id_item = opt.nextInt();
                objeto_item = ItemController.listarUm(id_item);
                System.out.println("Selecionou cliente : "+objeto_item.getNome());
            }
            if (valor == 0) {
                isRunning = false;
            }
            }
            catch(Exception ex ){
                System.out.println(ex);
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
                float valor_pago;
                Scanner opt = new Scanner(System.in);
                System.out.println("ID dos clientes: ");
                System.out.println(ClientController.listar());
                System.out.println("Insira o ID do cliente");
                id_cliente = opt.nextInt();
                objeto_cliente = ClientController.listarUm(id_cliente);
                System.out.println("Selecionou cliente : "+objeto_cliente.getNome());
                System.out.println("Valor Pago para o vendedor");
                valor_pago = opt.nextFloat();
                
                System.out.println("ID dos Vendedores: ");
                System.out.println(VendedorController.listar());
                System.out.println("Insira o ID do vendedor");
                id_vendedor = opt.nextInt();
                objeto_vendedor = VendedorController.listarUm(id_vendedor);
                System.out.println("Selecionou vendedor : "+objeto_vendedor.getNome());


                
                System.out.println("Informe a data da venda");
                data_da_venda = opt.next();
                
                System.out.println("Informe o metodo de pagamento");
                forma_de_pagamento = opt.next();

                Venda vd = new Venda(data_da_venda, forma_de_pagamento, objeto_vendedor, objeto_cliente,valor_pago);
                
                //System.out.println("Valor total: "+vd.getValorTotal());
                System.out.println("Situação: "+vd.pagar(vd.getValorTotal())); // aqui
                System.out.println("Data da venda: ");
                System.out.println(vd.getDataDaVenda());
                System.out.println("Cliente: ");
                System.out.println(vd.getCliente().getNome());
                System.out.println("Vendedor");
                System.out.println(vd.getVendedor().getNome());
                System.out.println("Forma de pagamento");
                System.out.println(vd.getFormaPagamento());
                System.out.println("Endereco do cliente");
                System.out.println(vd.getEnderecoEntrega());
                isRunning = false;
            } catch (Exception ex) {
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
            valor = Integer.parseInt(opt.nextLine());
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
