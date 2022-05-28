
package com.estacio.trabalho.model;

import com.estacio.trabalho.interfaces.MetodoPagamento;
import java.util.ArrayList;

public class Venda implements MetodoPagamento{

    public Integer id;
    private String dataDaVenda;
    private String formaPagamento;
    private Vendedor vendedor;
    private Cliente cliente;
    ArrayList<ItensVenda> listaItens = new ArrayList<>(); 

    public Venda(String forma_pagamento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String pagarDinheiro(){
        return "Pagou no Dinheiro";
    }
    
    @Override
    public String pagarPix(){
        return "Pagou no Pix";
    }
    
    @Override
    public String pagarCartao(){
        return "Pagou no cartão";
    }
    
    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(String dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }
    public float getValorTotal(){
       return 1;
    }
    public String getEnderecoEntrega(){
        System.out.println(cliente.getEndereco());
    }
    public String getQtdItens(){
        return "teste";
    }
    public void pagar(){
        return ;
    }
}
