package com.extremelf.BLL;

import com.extremelf.DAL.ReportaavariaEntity;
import com.extremelf.DAL.TipoDeControloEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TipoDeControloBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;


    public static void create(TipoDeControloEntity TipoDeControlo) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(TipoDeControlo);
        em.getTransaction().commit();
    }

    public static List<TipoDeControloEntity> readAll() {
        List<TipoDeControloEntity> listarTipoDeControlos = new ArrayList<>();
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("TipoDeControlo.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listarTipoDeControlos.add((TipoDeControloEntity) resultado);
        }

        return listarTipoDeControlos;
    }



    public static void update(TipoDeControloEntity tipoDeControlo) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(tipoDeControlo);
        em.getTransaction().commit();
    }

    public static void delete(TipoDeControloEntity tipoDeControlo) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(tipoDeControlo);
        em.getTransaction().commit();
    }
}
