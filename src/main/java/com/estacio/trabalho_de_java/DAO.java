
package com.estacio.trabalho_de_java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAO {
    
    public DAO(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager em = emf.createEntityManager();
    }
}
