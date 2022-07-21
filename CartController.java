package com.fresh_produce.fresh_produce_api.controllers;

import com.fresh_produce.fresh_produce_api.repositories.CartRepository;
import com.fresh_produce.fresh_produce_api.repositories.entities.Cart;
import com.fresh_produce.fresh_produce_api.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
// post cart api
    @CrossOrigin
    @PostMapping("/add")
    public Object AddItemToCart(@RequestParam Integer item_id, @RequestParam Integer user_id, @RequestParam Integer quantity ){
        return this.cartService.addToCart(item_id,user_id,quantity);
    }

    //get all cart items  for a user
    @CrossOrigin
    @GetMapping
    public Iterable<Cart> GetAll(){
        return this.cartService.findAll();
    }

    // delete a cart item for a user
    @CrossOrigin
    @DeleteMapping("/{cartId}")
    public void deleteCartItem(@PathVariable Integer cartId){
        this.cartService.delete(cartId);
    }
}
