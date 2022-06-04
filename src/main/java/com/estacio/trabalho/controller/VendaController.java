package com.estacio.trabalho.controller;

import com.estacio.trabalho.model.Cliente;
import com.estacio.trabalho.model.Venda;
import com.estacio.trabalho.model.Vendedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.ArrayList;

public class VendaController {

    public VendaController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager em = emf.createEntityManager();
    }

    public static void cadastrarVenda(String dataDaVenda, String formaPagamento, Vendedor vendedor, Cliente cliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-java");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDataDaVenda(dataDaVenda);
        venda.setFormaPagamento(formaPagamento);
        venda.setVendedor(vendedor);
        em.persist(venda);

        em.getTransaction().commit();
    }

}
