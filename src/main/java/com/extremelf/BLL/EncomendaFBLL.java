package com.extremelf.BLL;

import com.extremelf.DAL.EncomendacEntity;
import com.extremelf.DAL.EncomendafEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EncomendaFBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(EncomendafEntity encomendaF){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(encomendaF);
        em.getTransaction().commit();
    }

    public static List<EncomendafEntity> readAll(){
        List<EncomendafEntity> listaEncomendaF = new ArrayList<>();
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("EncomendaF.findAll");

        List<Object> result = q1.getResultList();

        for(Object resultado: result){
            listaEncomendaF.add((EncomendafEntity) resultado);
        }

        return listaEncomendaF;
    }

    public static EncomendafEntity readById(int idEncomendaF){
        EncomendafEntity encomendaF;
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("EncomendaF.findByIdEncomendaF");
        q1.setParameter("idEncomendaF",idEncomendaF);

        Object obj = q1.getSingleResult();

        if(obj != null){
            encomendaF = ((EncomendafEntity) obj);
        }
        else{
            return null;
        }

        return encomendaF;
    }

    public static void update(EncomendafEntity encomendaf){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(encomendaf);
        em.getTransaction().commit();
    }

    public static void delete(EncomendafEntity encomendaf){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(encomendaf);
        em.getTransaction().commit();
    }
}
