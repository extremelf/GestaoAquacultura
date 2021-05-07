package com.extremelf.BLL;

import com.extremelf.DAL.CargoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CargoBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(CargoEntity cargo) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(cargo);
        em.getTransaction().commit();
    }

    public static List<CargoEntity> readAll() {
        List<CargoEntity> listaCargos = new ArrayList<>();

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Cargo.findAll");
        List<Object> result = q1.getResultList();

        for (Object resultado : result) {
            listaCargos.add((CargoEntity) resultado);
        }

        return listaCargos;
    }

    public static CargoEntity readById(int idCargo) {
        CargoEntity cargo;

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Cargo.findByIdCargo");
        q1.setParameter("idCargo", idCargo);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            cargo = ((CargoEntity) obj);
        } else {
            return null;
        }

        return cargo;
    }

    public static void update(CargoEntity cargo) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(cargo);
        em.getTransaction().commit();
    }

    public static void delete(CargoEntity cargo) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(cargo);
        em.getTransaction().commit();
    }

}
