package com.extremelf.BLL;

import com.extremelf.DAL.AguaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AguaBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(AguaEntity agua){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(agua);
        em.getTransaction().commit();
    }
    public static AguaEntity read(int idAgua){
        AguaEntity agua;
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Agua.findByIdAgua");
        q1.setParameter("idAgua",idAgua);
        Object obj = q1.getSingleResult();

        if(obj != null){
            agua = ((AguaEntity) obj);
        }
        else{
            return null;
        }

        return agua;

    }

    public static List<AguaEntity> readAll(){
        List<AguaEntity> listaAgua = new ArrayList<>();

        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Agua.findAll");
        List<Object> result = q1.getResultList();

        for(Object resultado: result){
            listaAgua.add((AguaEntity) resultado);
        }

        return listaAgua;
    }

    public static void update(AguaEntity agua){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(agua);
        em.getTransaction().commit();
    }

    public static void delete(AguaEntity agua){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(agua);
        em.getTransaction().commit();
    }

}
