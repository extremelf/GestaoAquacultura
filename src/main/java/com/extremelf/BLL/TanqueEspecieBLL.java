package com.extremelf.BLL;

import com.extremelf.DAL.ReportaavariaEntity;
import com.extremelf.DAL.TanqueespecieEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TanqueEspecieBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(TanqueespecieEntity tanqueespecie) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(tanqueespecie);
        em.getTransaction().commit();
    }

    public static List<TanqueespecieEntity> readAll() {
        List<TanqueespecieEntity> listarTanqueEspecie = new ArrayList<>();
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Tanqueespecie.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listarTanqueEspecie.add((TanqueespecieEntity) resultado);
        }

        return listarTanqueEspecie;
    }



    public static void update(TanqueespecieEntity tanquespecie) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(tanquespecie);
        em.getTransaction().commit();
    }

    public static void delete(TanqueespecieEntity tanqueespecie) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(tanqueespecie);
        em.getTransaction().commit();
    }
}
