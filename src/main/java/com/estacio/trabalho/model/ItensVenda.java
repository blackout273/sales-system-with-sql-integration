
package com.estacio.trabalho.model;

public class ItensVenda extends Venda{
    private Item item;
    private int quantidade;

    public Item getItem() {
        return item;
    }
S
    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }   
}
