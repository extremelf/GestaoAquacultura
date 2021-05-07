package com.extremelf.BLL;

import com.extremelf.DAL.ControlodequalidadeEntity;
import com.extremelf.DAL.EncomendacEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EncomendaCBLL {

    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(EncomendacEntity encomendacEntity){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(encomendacEntity);
        em.getTransaction().commit();
    }

    public static EncomendacEntity readByIdCliente(int idCliente){
        EncomendacEntity encomendac;
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Encomenda.findByIdCliente");
        q1.setParameter("idCliente",idCliente);

        Object obj = q1.getSingleResult();

        if(obj != null){
            encomendac = (EncomendacEntity) obj;
        }
        else{
            return null;
        }

        return encomendac;
    }

    public static EncomendacEntity readByIdEncomendaC(int idEncomendaC){
        EncomendacEntity encomendac;
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Encomenda.findByIdEncomendaC");
        q1.setParameter("idEncomendaC",idEncomendaC);

        Object obj = q1.getSingleResult();

        if(obj != null){
            encomendac = (EncomendacEntity) obj;
        }
        else{
            return null;
        }

        return encomendac;
    }

    public static List<EncomendacEntity> readAll(){
        List<EncomendacEntity> encomendaC = new ArrayList<>();
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("EncomendaC.findAll");
        List<Object> result = q1.getResultList();

        for(Object resultado: result){
            encomendaC.add((EncomendacEntity) resultado);
        }

        return encomendaC;
    }

    public static void update(EncomendacEntity encomendac){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();


        em.getTransaction().begin();
        em.merge(encomendac);
        em.getTransaction().commit();
    }

    public static void delete(EncomendacEntity encomendac){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(encomendac);
        em.getTransaction().commit();
    }
}
