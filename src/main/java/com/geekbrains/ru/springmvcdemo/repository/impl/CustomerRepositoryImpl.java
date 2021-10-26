package com.geekbrains.ru.springmvcdemo.repository.impl;

import com.geekbrains.ru.springmvcdemo.component.HibernateSessionFactory;
import com.geekbrains.ru.springmvcdemo.domain.Category;
import com.geekbrains.ru.springmvcdemo.domain.Customer;
import com.geekbrains.ru.springmvcdemo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final HibernateSessionFactory<Customer> factory;

    @Autowired
    public CustomerRepositoryImpl(HibernateSessionFactory<Customer> factory) {
        this.factory = factory;
    }

    @Override
    public Customer get(Long id) {
        return factory.get(id, Customer.class);
    }

    @Override
    public List<Customer> findAll() {
        return factory.findAll("select c from Customer c",Customer.class);
    }
}
