package com.extremelf.BLL;

import com.extremelf.DAL.ClienteEntity;
import com.extremelf.DAL.ControlodequalidadeEntity;
import com.extremelf.DAL.LinhadeencomendacEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LinhaencomendaCBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;


    public static void create(LinhadeencomendacEntity linhaDeEncomendaC){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(linhaDeEncomendaC);
        em.getTransaction().commit();
    }
/**
    public static List<LinhadeencomendacEntity> readAll() {
        List<ClienteEntity> listaEncomendaClientes = new ArrayList<>();
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Linhaencomendac.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listaEncomendaClientes.add((ClienteEntity) resultado);
        }

        return listaEncomendaClientes;
    }
*/

    public static void update(LinhadeencomendacEntity encomendaC) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(encomendaC);
        em.getTransaction().commit();
    }

    public static void delete(LinhadeencomendacEntity encomendaC) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(encomendaC);
        em.getTransaction().commit();
    }

}
