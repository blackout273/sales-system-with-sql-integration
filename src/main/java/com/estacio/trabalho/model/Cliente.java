
package com.estacio.trabalho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente extends Pessoa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    public Cliente(Integer id, String nome, String cpf,String endereco) {
        this.id= id; 
        this.nome = nome; 
        this.cpf=cpf;
        this.endereco = endereco;
    }
    public Cliente(){
        
    }
    private String endereco;

    public String getEndereco() {
        return endereco;
    }
  
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
