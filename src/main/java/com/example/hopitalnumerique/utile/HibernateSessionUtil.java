package com.example.hopitalnumerique.utile;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {

    public static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}