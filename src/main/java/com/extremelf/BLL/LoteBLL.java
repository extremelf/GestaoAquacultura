package com.extremelf.BLL;


import com.extremelf.DAL.ClienteEntity;
import com.extremelf.DAL.LoteEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LoteBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(LoteEntity lote) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(lote);
        em.getTransaction().commit();
    }

    public static List<LoteEntity> readAll(){
        List<LoteEntity> listarLotes = new ArrayList<>();
        if (factory==null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        }
        if (em==null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Lote.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result){
            listarLotes.add((LoteEntity) resultado);
        }

        return listarLotes;
    }

    public static void update(LoteEntity lote) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(lote);
        em.getTransaction().commit();
    }

    public static void delete(LoteEntity lote) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(lote);
        em.getTransaction().commit();
    }





}
