package com.extremelf.BLL;

import com.extremelf.DAL.EncomendacEntity;
import com.extremelf.DAL.EspecieEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EspecieBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(EspecieEntity especie){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(especie);
        em.getTransaction().commit();
    }

    public static List<EspecieEntity> readAll(){
        List<EspecieEntity> listaEspecies = new ArrayList<>();
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Especie.findAll");

        List<Object> result = q1.getResultList();

        for(Object resultado: result){
            listaEspecies.add((EspecieEntity) resultado);
        }
        return listaEspecies;
    }

    public static EspecieEntity readById(int idEspecie){
        EspecieEntity especie;
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Especie.findById");

        Object obj = q1.getSingleResult();

        if(obj != null){
            especie = ((EspecieEntity) obj);
        }
        else{
            return null;
        }

        return especie;
    }

    public static void update(EspecieEntity especie){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(especie);
        em.getTransaction().commit();
    }

    public static void delete(EspecieEntity especie){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(especie);
        em.getTransaction().commit();
    }
}
