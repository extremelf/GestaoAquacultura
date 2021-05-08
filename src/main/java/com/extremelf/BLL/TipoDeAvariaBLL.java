package com.extremelf.BLL;

import com.extremelf.DAL.ReportaavariaEntity;
import com.extremelf.DAL.TipoDeAvariaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TipoDeAvariaBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(TipoDeAvariaEntity tipoDeAvaria) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(tipoDeAvaria);
        em.getTransaction().commit();
    }

    public static List<TipoDeAvariaEntity> readAll() {
        List<TipoDeAvariaEntity> listarTipoDeAvarias = new ArrayList<>();
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("TipoDeAvaria.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listarTipoDeAvarias.add((TipoDeAvariaEntity) resultado);
        }

        return listarTipoDeAvarias;
    }


    public static void update(TipoDeAvariaEntity tipoDeAvaria) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(tipoDeAvaria);
        em.getTransaction().commit();
    }

    public static void delete(TipoDeAvariaEntity tipoDeAvaria) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(tipoDeAvaria);
        em.getTransaction().commit();
    }
}
