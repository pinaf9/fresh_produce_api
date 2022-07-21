package com.fresh_produce.fresh_produce_api.service;

import com.fresh_produce.fresh_produce_api.controllers.dto.CartDTO;
import com.fresh_produce.fresh_produce_api.repositories.CartRepository;
import com.fresh_produce.fresh_produce_api.repositories.entities.Cart;
import com.fresh_produce.fresh_produce_api.repositories.entities.Item;
import com.fresh_produce.fresh_produce_api.repositories.entities.User;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ItemService itemService;
    private final UserService userService;

    public CartServiceImpl(CartRepository cartRepository, ItemService itemService, UserService userService) {
        this.cartRepository = cartRepository;
        this.itemService = itemService;
        this.userService = userService;
    }


    @Override
    public Cart save(CartDTO cartDTO) {
        Cart cart = new Cart(cartDTO);
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(CartDTO cartDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        cartRepository.delete(cartRepository.findById(id).get());
    }

    @Override
    public Iterable<Cart> findAll() {
       return cartRepository.findAll();
    }
    @Override
    public Object addToCart(Integer item_id, Integer user_id, Integer quantity){
       Item item = itemService.findById(item_id);
       User user = userService.findById(user_id);
       CartDTO cartDTO = new CartDTO(item, user, quantity);
       Cart cart = new Cart(cartDTO);
       return cartRepository.save(cart);
    }
}
