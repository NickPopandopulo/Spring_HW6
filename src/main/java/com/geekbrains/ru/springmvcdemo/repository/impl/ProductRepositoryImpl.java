package com.geekbrains.ru.springmvcdemo.repository.impl;

import com.geekbrains.ru.springmvcdemo.component.HibernateSessionFactory;
import com.geekbrains.ru.springmvcdemo.domain.Category;
import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.CategoryRepository;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final HibernateSessionFactory sessionFactory;

    @Override
    public Product get(Long id) {
        Product product;
        try(Session session = sessionFactory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        }

        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products;
        try(Session session = sessionFactory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            products = session.createQuery("select p from Product p", Product.class).getResultList();
            session.getTransaction().commit();
        }

        return products;
    }

}
