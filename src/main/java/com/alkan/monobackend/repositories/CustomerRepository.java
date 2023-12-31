package com.alkan.monobackend.repositories;

import com.alkan.monobackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsCustomerByEmail(String email);

    Customer findByEmail(String email);
}
