package com.geekbrains.ru.springmvcdemo.repository.impl;

import com.geekbrains.ru.springmvcdemo.component.HibernateSessionFactory;
import com.geekbrains.ru.springmvcdemo.domain.Category;
import com.geekbrains.ru.springmvcdemo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final HibernateSessionFactory<Category> factory;

    @Autowired
    public CategoryRepositoryImpl(HibernateSessionFactory<Category> factory) {
        this.factory = factory;
    }

    @Override
    public Category get(Long id) {
        return factory.get(id, Category.class);
    }

    @Override
    public List<Category> findAll() {
        return factory.findAll("select c from Category c",Category.class);
    }

}
