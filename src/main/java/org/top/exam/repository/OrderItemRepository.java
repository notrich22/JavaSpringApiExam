package org.top.exam.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.exam.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
}
