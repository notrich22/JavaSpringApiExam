package org.top.exam.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.exam.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
