package com.extremelf.BLL;

import com.extremelf.DAL.ClienteEntity;
import com.extremelf.DAL.ReportaavariaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ReportaAvariaBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;


    public static void create(ReportaavariaEntity reportaAvaria) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(reportaAvaria);
        em.getTransaction().commit();
    }

    public static List<ReportaavariaEntity> readAll() {
        List<ReportaavariaEntity> listarAvarias = new ArrayList<>();
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Reportaavaria.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listarAvarias.add((ReportaavariaEntity) resultado);
        }

        return listarAvarias;
    }

    public static ReportaavariaEntity readById(int idAvaria, int idTanque, int idFuncionarios) {
        ReportaavariaEntity avaria = new ReportaavariaEntity();
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Reportaavaria.findByIds");
        q1.setParameter("idTanque",idTanque);
        q1.setParameter("idFuncionario",idFuncionarios);
        q1.setParameter("idTipoAvaria",idAvaria);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            avaria = ((ReportaavariaEntity) obj);
        } else {
            return null;
        }

        return avaria;
    }



    public static void update(ReportaavariaEntity reportaAvaria) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(reportaAvaria);
        em.getTransaction().commit();
    }

    public static void delete(ReportaavariaEntity reportaAvaria) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(reportaAvaria);
        em.getTransaction().commit();
    }

}
