package com.extremelf.BLL;

import com.extremelf.DAL.ReportaavariaEntity;
import com.extremelf.DAL.TanqueloteEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TanqueLoteBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(TanqueloteEntity tanquelote) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(tanquelote);
        em.getTransaction().commit();
    }

    public static List<TanqueloteEntity> readAll() {
        List<TanqueloteEntity> listarTanquesLotes = new ArrayList<>();
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Tanquelote.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listarTanquesLotes.add((TanqueloteEntity) resultado);
        }

        return listarTanquesLotes;
    }



    public static void update(TanqueloteEntity tanquelote) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(tanquelote);
        em.getTransaction().commit();
    }

    public static void delete(TanqueloteEntity tanquelote) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(tanquelote);
        em.getTransaction().commit();
    }
}
