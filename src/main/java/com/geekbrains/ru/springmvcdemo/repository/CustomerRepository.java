package com.geekbrains.ru.springmvcdemo.repository;

import com.geekbrains.ru.springmvcdemo.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer get(Long id);

    List<Customer> findAll();
}
