package com.fresh_produce.fresh_produce_api.repositories;

import com.fresh_produce.fresh_produce_api.repositories.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
