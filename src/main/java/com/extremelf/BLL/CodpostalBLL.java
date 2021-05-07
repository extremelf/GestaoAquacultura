package com.extremelf.BLL;

import com.extremelf.DAL.AguaEntity;
import com.extremelf.DAL.CodpostalEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CodpostalBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(CodpostalEntity codpostal){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(codpostal);
        em.getTransaction().commit();
    }
    public static CodpostalEntity read(int idCodPostal){
        CodpostalEntity codPostal;
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("CodPostal.findByIdCodPostal");
        q1.setParameter("idCodPostal",idCodPostal);
        Object obj = q1.getSingleResult();

        if(obj != null){
            codPostal = ((CodpostalEntity) obj);
        }
        else{
            return null;
        }

        return codPostal;

    }

    public static List<CodpostalEntity> readAll(){
        List<CodpostalEntity> codPostal = new ArrayList<>();

        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("CodPostal.findAll");
        List<Object> result = q1.getResultList();

        for(Object resultado: result){
            codPostal.add((CodpostalEntity) resultado);
        }

        return codPostal;
    }

    public static void update(CodpostalEntity codPostal){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(codPostal);
        em.getTransaction().commit();
    }

    public static void delete(CodpostalEntity codpostal){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(codpostal);
        em.getTransaction().commit();
    }

}
