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
    private String nome, unidade;
    private float valor;
    
  
    public Item(String nome, String unidade, float valor, int id) {
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
        this.nome = nome;
    }

    public String getUnidade() {
        return this.unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
        
        
    }
}
