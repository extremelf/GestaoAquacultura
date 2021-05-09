package com.extremelf.BLL;

import com.extremelf.DAL.FornecedorEntity;
import com.extremelf.DAL.FuncionarioEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(FuncionarioEntity funcionario) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
    }

    public static List<FuncionarioEntity> readAll() {
        List<FuncionarioEntity> listaFuncionarios = new ArrayList<>();

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Funcionario.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listaFuncionarios.add((FuncionarioEntity) resultado);
        }

        return listaFuncionarios;
    }

    public static FuncionarioEntity readById(int idFuncionario) {
        FuncionarioEntity funcionario;

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Funcionario.findById");
        q1.setParameter("idFuncionario", idFuncionario);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            funcionario = ((FuncionarioEntity) obj);
        } else {
            return null;
        }

        return funcionario;
    }


    public static FuncionarioEntity readByIdCargo(int idCargo) {
        FuncionarioEntity funcionario;

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Funcionario.findByCargo");
        q1.setParameter("idCargo", idCargo);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            funcionario = ((FuncionarioEntity) obj);
        } else {
            return null;
        }

        return funcionario;
    }

    public static FuncionarioEntity readByCc(int cc) {
        FuncionarioEntity funcionario;

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Funcionario.findByCc");
        q1.setParameter("cc", cc);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            funcionario = ((FuncionarioEntity) obj);
        } else {
            return null;
        }

        return funcionario;
    }


    public static void update(FuncionarioEntity funcionario) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
    }

    public static void delete(FuncionarioEntity funcionario) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(funcionario);
        em.getTransaction().commit();
    }


}
