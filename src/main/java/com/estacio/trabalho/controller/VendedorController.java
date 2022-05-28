
package com.estacio.trabalho.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import com.estacio.trabalho.model.Vendedor;

public class VendedorController {
    
    public VendedorController(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager em = emf.createEntityManager();
    }

    // Cadastro de Vendedor (int id, String nome, String cpf,float salario)
    public static void cadastrarVendedor(String nome, String cpf, float salario) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
       
        Vendedor v = new Vendedor();
        v.setNome(nome);
        v.setCpf(cpf);
        v.setSalario(salario);
        entityManager.persist(v);
       
        entityManager.getTransaction().commit();
    }

    // Listar um Vendedor (int id)
    public static Vendedor listarUm(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
        Vendedor v = entityManager.find(Vendedor.class, id);
        entityManager.getTransaction().commit();
        
        return v;
    }

    // Listar todos os Vendedores
    @SuppressWarnings("unchecked")
    public static List<VendedorController> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();

        return entityManager.createQuery("SELECT  id FROM " + Vendedor.class.getSimpleName() +" WHERE DTYPE = 'Vendedor' " ).getResultList();
    }

    // Alterar um Vendedor (String nome, float salario, int id)
    public static void update(String nome, String cpf, float salario, int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
        Vendedor v = entityManager.find(Vendedor.class, id);
        v.setNome(nome);
        v.setSalario(salario);
        v.setCpf(cpf);
       
        entityManager.getTransaction().commit();
    }

    // Excluir um Vendedor (int id)
    public static void delete(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
        Vendedor v = entityManager.find(Vendedor.class, id);
        entityManager.remove(v);
       
        entityManager.getTransaction().commit();
    }
    
}
