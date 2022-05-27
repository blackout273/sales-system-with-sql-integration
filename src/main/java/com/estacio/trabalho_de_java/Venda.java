
package com.estacio.trabalho_de_java;

import java.util.ArrayList;
public abstract class Venda implements MetodoPagamento{
    private String dataDaVenda;
    private String formaPagamento;
    private Vendedor vendedor;
    private Cliente cliente;
    ArrayList<ItensVenda> listaItens = new ArrayList<ItensVenda>(); 

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
    
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
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
       
    }
}
