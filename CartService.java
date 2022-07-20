package com.fresh_produce.fresh_produce_api.service;

import com.fresh_produce.fresh_produce_api.controllers.dto.CartDTO;
import com.fresh_produce.fresh_produce_api.controllers.dto.UserDTO;
import com.fresh_produce.fresh_produce_api.repositories.entities.Cart;
import com.fresh_produce.fresh_produce_api.repositories.entities.User;

public interface CartService {
    Cart save(CartDTO cartDTO);
    Cart update(CartDTO cartDTO);
    void delete(Integer id);
    Iterable<Cart> findAll();
    Object addToCart(Integer item_id, Integer user_id, Integer quantity);
}
