package com.fresh_produce.fresh_produce_api.repositories;

import com.fresh_produce.fresh_produce_api.repositories.entities.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
