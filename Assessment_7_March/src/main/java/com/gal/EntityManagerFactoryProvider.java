package com.gal;

import java.sql.Date;
import java.util.List;

import com.gal.model.Item;
import com.gal.model.Supplier;
import com.gal.model.Supply;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EntityManagerFactoryProvider {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("supplyCompany_pu");
        }
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
        if (em != null && em.isOpen())
            em.close();

        if (emf != null && emf.isOpen())
            emf.close();
    }

    public static void main(String[] args) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        try {

            // SUPPLIERS
            Supplier s1 = new Supplier(1, "Rajan enterprises", 4.5, "Delhi");
            Supplier s2 = new Supplier(2, "Indian supply", 3.4, "Gurugram");

            em.persist(s1);
            em.persist(s2);

            // ITEMS
            Item i1 = new Item(1, "Tomato", "Veg");
            Item i2 = new Item(2, "Onion", "Veg");
            Item i3 = new Item(3, "Sugar", "Groc");

            em.persist(i1);
            em.persist(i2);
            em.persist(i3);

            // SUPPLY
            Supply sp1 = new Supply(1, s1, i2, Date.valueOf("2019-03-03"), 36, 50);
            Supply sp2 = new Supply(2, s1, i3, Date.valueOf("2019-05-05"), 10, 45);
            Supply sp3 = new Supply(3, s2, i1, Date.valueOf("2019-08-15"), 50, 10);

            em.persist(sp1);
            em.persist(sp2);
            em.persist(sp3);

            em.getTransaction().commit();

            System.out.println("DATA INSERTED");
        }
        catch (Exception e){
            System.out.println("Data already exists");
        }
        finally {
            // QUERY 1 : Write the query to find all suppliers name.
            System.out.println("Supplier Names:");

            Query query = em.createQuery("select s.sname from Supplier s");
            List<String> supplierNames = query.getResultList();

            for (String name : supplierNames) {
                System.out.println(name);
            }

            //QUERY 2 : Write query to find the suppliers from Dehi.
            System.out.println("\nSuppliers from Delhi:");

            Query query2 = em.createQuery("from Supplier s where s.city='Delhi'");
            List<?> delhiSuppliers = query2.getResultList();

            for (Object s : delhiSuppliers) {
                System.out.println(s);
            }


            //QUERY 3 :  Find the names of items supplied by supplier with sid = 1.
            System.out.println("\nItems supplied by Supplier with sid = 1:");

            Query query3 = em.createQuery(
                    "select sp.item.name from Supply sp where sp.supplier.sid = 1");

            List<String> items = query3.getResultList();

            for (String item : items) {
                System.out.println(item);
            }
        }
        closeConnections();
    }
}