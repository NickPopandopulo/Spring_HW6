package com.geekbrains.ru.springmvcdemo.component;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class HibernateSessionFactory<T> {

    private final SessionFactory factory;

    public HibernateSessionFactory() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public SessionFactory getFactory() {
        return factory;
    }

    @PreDestroy
    public void destroy() {
        factory.close();
    }

    public T get(Long id, Class<T> clazz) {
        T object;

        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            object = session.get(clazz, id);
            session.getTransaction().commit();
        }

        return object;
    }

    public List<T> findAll(String query, Class<T> clazz) {
        List<T> objects;
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            objects = session.createQuery(query, clazz).getResultList();
            session.getTransaction().commit();
        }

        return objects;
    }
}
