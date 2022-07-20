package com.fresh_produce.fresh_produce_api.controllers.dto;

import com.fresh_produce.fresh_produce_api.repositories.entities.Item;
import com.fresh_produce.fresh_produce_api.repositories.entities.User;

public class CartDTO {

    private Item item;
    private User user;
    private Integer quantity;

    public CartDTO() {
    }

    public CartDTO(Item item, User user, Integer quantity) {
        this.item = item;
        this.user = user;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "item=" + item +
                ", user=" + user +
                ", quantity=" + quantity +
                '}';
    }
}
