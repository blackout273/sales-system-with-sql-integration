
package com.estacio.trabalho.model;

import com.estacio.trabalho.controller.ItemController;
import com.estacio.trabalho.interfaces.MetodoPagamento;
import java.util.ArrayList;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda implements MetodoPagamento{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    private String dataDaVenda;
    private String formaPagamento;
    private Vendedor vendedor;
    private Cliente cliente;
    ArrayList<ItensVenda> listaItens = new ArrayList<>(); 
    
     public Venda(Integer id, String dataDaVenda, String formaPagamento, Vendedor vendedor, Cliente cliente) {
        
        this.id = id;
        this.dataDaVenda = dataDaVenda;
        this.formaPagamento = formaPagamento;
        this.vendedor = vendedor;
        this.cliente = cliente;
    }
    
    
    public Venda(){
        
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
        if(this.formaPagamento.equals("cartao")){
        return this.pagarCartao();
        }if(this.formaPagamento.equals("pix")){
        return this.pagarPix();
        }if(this.formaPagamento.equals("dinheiro")){
        return this.pagarDinheiro();
        }
        return "opção invalida";
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
        Item objeto_item;
        int qtd,id_item;
        String nomeItem,unidadeItem;
        float valorItem,valor_total;
        Scanner sc = new Scanner(System.in);
        ItensVenda iv = new ItensVenda();
        System.out.println("Informa quantidade de itens");
        qtd = iv.setQuantidade(sc.nextInt());
        System.out.println("Insira o ID do item");
        id_item = sc.nextInt();
        objeto_item = ItemController.listarUm(id_item);
        valor_total = qtd * objeto_item.getValor();
       return valor_total;
    }
    public String getEnderecoEntrega(){
        return cliente.getEndereco();
    }
    public String getQtdItens(){
        ItensVenda iv = new ItensVenda();
        return iv.getQtdItens() ;
    }
    public void pagar(){
        return ;
    }
}
