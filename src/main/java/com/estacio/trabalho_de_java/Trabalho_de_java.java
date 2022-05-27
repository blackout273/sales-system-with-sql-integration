
package com.estacio.trabalho_de_java;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class Trabalho_de_java {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null,"Danillo","danillo_teste@gmail.com",23);
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();
        System.out.println("Commitou");
    }
}
