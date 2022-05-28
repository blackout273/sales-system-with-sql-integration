
package com.estacio.trabalho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendedor extends Pessoa {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;

    
    public Vendedor(Integer id, String nome, String cpf,float salario) {
        this.id= id; 
        this.nome = nome; 
        this.cpf= cpf;
        this.salario = salario;
    }

    public Vendedor() {
    }

    private float salario;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
