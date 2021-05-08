package com.extremelf.BLL;


import com.extremelf.DAL.LinhadeencomendacEntity;
import com.extremelf.DAL.LinhaencomendafEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LinhaencomendaFBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(LinhaencomendafEntity linhaDeEncomendaF){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(linhaDeEncomendaF);
        em.getTransaction().commit();
    }
    /**
     public static List<LinhadeencomendacEntity> readAll() {
     List<ClienteEntity> listaEncomendaClientes = new ArrayList<>();
     if (factory == null) {
     factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
     }
     if (em == null) em = factory.createEntityManager();

     Query q1 = em.createNamedQuery("Linhaencomendaf.findAll");
     List<Object> result = q1.getResultList();

     for (Object resultado : result) {
     listaEncomendaClientes.add((ClienteEntity) resultado);
     }

     return listaEncomendaClientes;
     }
     */


    public static void update(LinhaencomendafEntity encomendaF) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(encomendaF);
        em.getTransaction().commit();
    }

    public static void delete(LinhaencomendafEntity encomendaF) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(encomendaF);
        em.getTransaction().commit();
    }

}
