package com.estacio.trabalho.model;

import com.estacio.trabalho.controller.ItemController;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item extends ItensVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String unidade;
    private float valor;
    
    
    
    public Item(String nome, String unidade, float valor, Integer id) {
        this.id= id; 
        this.nome = nome;
        this.unidade = unidade;
        this.valor = valor;
    }
    
    public Item(){
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o Nome do item");
        this.nome = sc.next();
    }

    public String getUnidade() {
        return this.unidade;
    }

    public void setUnidade(String unidade) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a unidade de itens");
        this.unidade = sc.next();
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o valor do item");
        this.valor = sc.nextFloat();
        
        
    }
}
