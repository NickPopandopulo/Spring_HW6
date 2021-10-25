package com.geekbrains.ru.springmvcdemo.component;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class HibernateSessionFactory {

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
}
