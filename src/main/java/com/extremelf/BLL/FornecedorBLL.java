package com.extremelf.BLL;

import com.extremelf.DAL.AguaEntity;
import com.extremelf.DAL.EspecieEntity;
import com.extremelf.DAL.FornecedorEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class FornecedorBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(FornecedorEntity fornecedor) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(fornecedor);
        em.getTransaction().commit();
    }

    public static List<FornecedorEntity> readAll() {
        List<FornecedorEntity> listaFornecedores = new ArrayList<>();

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Fornecedor.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listaFornecedores.add((FornecedorEntity) resultado);
        }

        return listaFornecedores;
    }

    public static FornecedorEntity readById(int idFornecedor) {
        FornecedorEntity fornecedor;

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Fornecedor.findById");
        q1.setParameter("idFornecedor", idFornecedor);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            fornecedor = ((FornecedorEntity) obj);
        } else {
            return null;
        }

        return fornecedor;
    }


    public static FornecedorEntity readByNome(String nome) {
        FornecedorEntity fornecedor;

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Fornecedor.findByNome");
        q1.setParameter("Nome", nome);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            fornecedor = ((FornecedorEntity) obj);
        } else {
            return null;
        }

        return fornecedor;
    }


    public static void update(FornecedorEntity fornecedor) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(fornecedor);
        em.getTransaction().commit();
    }

    public static void delete(FornecedorEntity fornecedor) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(fornecedor);
        em.getTransaction().commit();
    }


}
