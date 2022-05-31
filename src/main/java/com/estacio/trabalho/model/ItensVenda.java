package com.estacio.trabalho.model;

import java.util.Scanner;

public class ItensVenda extends Venda {

    private Item item;
    private int quantidade;


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this.quantidade;
    }
}
