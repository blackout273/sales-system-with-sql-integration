package com.estacio.trabalho.model;

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
    public Item(){
    }
    public Item(String nome, String unidade, float valor, int quantidade) {
        this.setNome(nome);
        this.setUnidade(unidade);
        this.setValor(valor);
        this.setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o Nome");
        this.nome = sc.next();
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a unidade");
        this.unidade = sc.next();
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o valor");
        this.valor = sc.nextFloat();
    }
}
