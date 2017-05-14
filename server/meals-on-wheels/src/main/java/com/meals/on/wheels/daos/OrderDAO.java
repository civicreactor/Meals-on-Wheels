package com.meals.on.wheels.daos;

import com.meals.on.wheels.models.OrderModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OrderDAO extends CrudRepository<OrderModel, Long> {
}
