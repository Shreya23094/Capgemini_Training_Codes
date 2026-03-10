package com.gal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// singleton design pattern : emf : one , em : many
public class EntityManagerFactoryProvider {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("shopping_pu");
        }
        System.out.println(emf);
        return emf;

    }

    public static EntityManager getEntityManager() {
        if (emf == null)
            getEntityManagerFactory();
        if (em == null || !em.isOpen())
            em = emf.createEntityManager();
        return em;
    }

    public static void closeConnections() {
        getEntityManager().close();
        getEntityManagerFactory().close();
    }

}