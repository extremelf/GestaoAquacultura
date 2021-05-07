package com.extremelf.BLL;

import com.extremelf.DAL.ClienteEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClienteBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    public static EntityManagerFactory factory = null;
    public static EntityManager em = null;

    public static void create(ClienteEntity cliente) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public static List<ClienteEntity> readAll() {
        List<ClienteEntity> listaCliente = new ArrayList<>();
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Cliente.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listaCliente.add((ClienteEntity) resultado);
        }

        return listaCliente;
    }

    public static ClienteEntity readById(int idCliente) {
        ClienteEntity cliente;

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Cliente.findById");
        q1.setParameter("idCliente", idCliente);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            cliente = ((ClienteEntity) obj);
        } else {
            return null;
        }

        return cliente;
    }

    public static ClienteEntity readByCc(int cc) {
        ClienteEntity cliente;
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Cliente.findByCC");
        q1.setParameter("cc", cc);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            cliente = ((ClienteEntity) obj);
        } else {
            return null;
        }

        return cliente;
    }

    public static ClienteEntity readByNome(String nome) {
        ClienteEntity cliente;
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Cliente.findByNome");
        q1.setParameter("nome", nome);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            cliente = ((ClienteEntity) obj);
        } else {
            return null;
        }

        return cliente;

    }

    public static void update(ClienteEntity cliente) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public static void delete(ClienteEntity cliente) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }

}
