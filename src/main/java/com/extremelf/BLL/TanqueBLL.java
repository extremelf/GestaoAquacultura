package com.extremelf.BLL;

import com.extremelf.DAL.ReportaavariaEntity;
import com.extremelf.DAL.TanqueEntity;
import com.extremelf.DAL.TanqueespecieEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TanqueBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(TanqueEntity tanque) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(tanque);
        em.getTransaction().commit();
    }

    public static List<TanqueEntity> readAll() {
        List<TanqueEntity> listarTanques = new ArrayList<>();
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Tanque.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listarTanques.add((TanqueEntity) resultado);
        }

        return listarTanques;
    }


    public static void update(TanqueEntity tanque) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(tanque);
        em.getTransaction().commit();
    }

    public static void delete(TanqueEntity tanque) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(tanque);
        em.getTransaction().commit();
    }
}
