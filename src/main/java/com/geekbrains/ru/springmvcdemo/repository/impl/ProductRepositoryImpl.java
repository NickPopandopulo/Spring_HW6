package com.geekbrains.ru.springmvcdemo.repository.impl;

import com.geekbrains.ru.springmvcdemo.component.HibernateSessionFactory;
import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final HibernateSessionFactory<Product> factory;

    @Autowired
    public ProductRepositoryImpl(HibernateSessionFactory<Product> factory) {
        this.factory = factory;
    }

    @Override
    public Product get(Long id) {
        return factory.get(id, Product.class);
    }

    @Override
    public List<Product> findAll() {
        return factory.findAll("select p from Product p", Product.class);
    }

}
