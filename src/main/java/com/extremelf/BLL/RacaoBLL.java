package com.extremelf.BLL;

import com.extremelf.DAL.ClienteEntity;
import com.extremelf.DAL.LoteEntity;
import com.extremelf.DAL.RacaoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RacaoBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(RacaoEntity racao) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(racao);
        em.getTransaction().commit();
    }

    public static List<RacaoEntity> readAll() {
        List<RacaoEntity> listarRacao = new ArrayList<>();
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Racao.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listarRacao.add((RacaoEntity) resultado);
        }

        return listarRacao;
    }

    public static void update(RacaoEntity racao) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(racao);
        em.getTransaction().commit();
    }

    public static void delete(RacaoEntity racao) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(racao);
        em.getTransaction().commit();
    }


}
