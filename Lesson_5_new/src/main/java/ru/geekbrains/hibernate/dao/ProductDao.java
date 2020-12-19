package ru.geekbrains.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.hibernate.PrepareDataApp;
import ru.geekbrains.hibernate.model.Product;

import java.util.List;


public class ProductDao {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            init();
//            findAll();
//            saveProduct(7L, "Orange", 6);
//            findById(2L);
//            updateProduct(7L, "Orange", 55);
            deleteProduct(7L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void init() {
//        PrepareDataApp.forcePrepareData();
        sessionFactory = new Configuration()
                .configure("config/crud/hibernate.cfg.xml" )
                .buildSessionFactory();
    }

    public static void shutdown() {
        sessionFactory.close();
    }

    public static void saveProduct(Long id, String title, int price) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = new Product(id, title, price);
            session.save(product);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void findById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            System.out.println(product.toString());
            session.close();
        }
    }

    public static void findAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> items = session.createQuery("from Product").getResultList();
            System.out.println(items + "\n");
            session.getTransaction().commit();
        }
    }

    public static void updateProduct(Long id, String title, int price) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setTitle(title);
            product.setPrice(price);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void deleteProduct(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
            session.close();
        }
    }
}
