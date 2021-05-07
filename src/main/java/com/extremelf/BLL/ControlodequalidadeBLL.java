package com.extremelf.BLL;

import com.extremelf.DAL.CodpostalEntity;
import com.extremelf.DAL.ControlodequalidadeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ControlodequalidadeBLL {

    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(ControlodequalidadeEntity controlodequalidade){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(controlodequalidade);
        em.getTransaction().commit();
    }

    public static ControlodequalidadeEntity read(int idControloQualidade, int idFuncionario,int idTanque){
        ControlodequalidadeEntity controlodequalidade;
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("ControloDeQualidade.findByIds");
        q1.setParameter("idTipoControlo",idControloQualidade);
        q1.setParameter("idFuncionario",idFuncionario);
        q1.setParameter("idTanque",idTanque);

        Object obj = q1.getSingleResult();

        if(obj != null){
            controlodequalidade = (ControlodequalidadeEntity) obj;
        }
        else{
            return null;
        }

        return controlodequalidade;
    }

    public static List<ControlodequalidadeEntity> readAll(){
        List<ControlodequalidadeEntity> controlodequalidade = new ArrayList<>();
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("ControloDeQualidade.findAll");
        List<Object> result = q1.getResultList();

        for(Object resultado: result){
            controlodequalidade.add((ControlodequalidadeEntity) resultado);
        }

        return controlodequalidade;
    }

    public static void update(ControlodequalidadeEntity controlodequalidade){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();


        em.getTransaction().begin();
        em.merge(controlodequalidade);
        em.getTransaction().commit();
    }

    public static void delete(ControlodequalidadeEntity controlodequalidade){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if(em == null) em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(controlodequalidade);
        em.getTransaction().commit();
    }
}
