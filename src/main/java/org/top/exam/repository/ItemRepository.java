package org.top.exam.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.exam.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    Item findByName(String name);
}
