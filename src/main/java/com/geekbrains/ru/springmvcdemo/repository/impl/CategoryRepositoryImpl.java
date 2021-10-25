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

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final HibernateSessionFactory sessionFactory;

    @Override
    public Category get(Long id) {
        Category category;
        try(Session session = sessionFactory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            category = session.get(Category.class, id);
            session.getTransaction().commit();
        }

        return category;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories;
        try(Session session = sessionFactory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            categories = session.createQuery("select c from Category c", Category.class).getResultList();
            session.getTransaction().commit();
        }

        return categories;
    }

}
