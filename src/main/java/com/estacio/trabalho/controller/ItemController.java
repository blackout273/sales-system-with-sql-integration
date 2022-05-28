
package com.estacio.trabalho.controller;


import com.estacio.trabalho.model.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ItemController {
    public ItemController(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager em = emf.createEntityManager();
    }

    // Cadastro de Item (int id, String nome, String unidade,float valor)
    public static void cadastrarItem(String nome, String unidade, float valor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
       
        Item i = new Item();
        i.setNome(nome);
        i.setUnidade(unidade);
        i.setValor(valor);
        entityManager.persist(i);
       
        entityManager.getTransaction().commit();
    }

    // Listar um Item (int id)
    public static Item listarUm(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
        Item i = entityManager.find(Item.class, id);
        entityManager.getTransaction().commit();
        
        return i;
    }

    // Listar todos os Itens
    @SuppressWarnings("unchecked")
    public static List<ItemController> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();

        return entityManager.createQuery("SELECT id FROM " + Item.class.getSimpleName()).getResultList();
    }

    // Alterar um Item (String nome, String unidade, float valor, int id)
    public static void update(String nome, String unidade,float valor, int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
        Item i = entityManager.find(Item.class, id);
        i.setNome(nome);
        i.setUnidade(unidade);
        i.setValor(valor);
       
        entityManager.getTransaction().commit();
    }

    // Excluir um Item (int id)
    public static void delete(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager entityManager = emf.createEntityManager();
       
        entityManager.getTransaction().begin();
        Item i = entityManager.find(Item.class, id);
        entityManager.remove(i);
       
        entityManager.getTransaction().commit();
    }
}
