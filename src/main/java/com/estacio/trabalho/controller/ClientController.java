
package com.estacio.trabalho.controller;

import com.estacio.trabalho.model.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClientController {
    
    public ClientController(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager em = emf.createEntityManager();
    }

    // Cadastro de Cliente (int id, String nome, String cpf,float salario)
    public static void cadastrarCliente(String nome, String cpf, String endereco) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
       
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        c.setEndereco(endereco);
        entityManager.persist(c);
       
        entityManager.getTransaction().commit();
    }

    // Listar um Cliente (int id)
    public static Cliente listarUm(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
        Cliente c = entityManager.find(Cliente.class, id);
        entityManager.getTransaction().commit();
        
        return c;
    }

    // Listar todos os Clientes
    @SuppressWarnings("unchecked")
    public static List<ClientController> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();

        return entityManager.createQuery("SELECT id FROM " + Cliente.class.getSimpleName() +" WHERE DTYPE = 'Cliente' " ).getResultList();
    }

    // Alterar um Cliente (String nome, String endereco, int id)
    public static void update(String nome, String cpf, String endereco, int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
        Cliente c = entityManager.find(Cliente.class, id);
        c.setNome(nome);
        c.setCpf(cpf);
        c.setEndereco(endereco);
       
        entityManager.getTransaction().commit();
    }

    // Excluir um Cliente (int id)
    public static void delete(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
        Cliente c = entityManager.find(Cliente.class, id);
        entityManager.remove(c);
       
        entityManager.getTransaction().commit();
    }
    
}
