package com.meals.on.wheels.daos;

import com.meals.on.wheels.models.CustomerModel;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomerDAO extends CrudRepository<CustomerModel, Long> {
}
